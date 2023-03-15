package com.app.dronesapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.dronesapp.service.drone_service;
import com.app.dronesapp.entity.drone;
import com.app.dronesapp.service.transport_history_service;

@CrossOrigin("*")
@RestController
@RequestMapping("/drone")
public class drone_controller {
    @Autowired
    drone_service drone_service;

    @Autowired
    transport_history_service transport_history_service;

    @GetMapping("/getBattery/{id}")
    public  ResponseEntity<Integer> getBattery(@PathVariable("id") int id){
        return drone_service.getDroneById(id).map(
                drone -> new ResponseEntity<>(drone.getBattery_capacity(),HttpStatus.OK)
        ).orElse(
                new ResponseEntity<>(HttpStatus.NOT_FOUND)
        );
    }

    @PostMapping
    public ResponseEntity<drone> register_drone(@RequestBody drone drone){
        return new ResponseEntity<>(drone_service.createDrone(drone), HttpStatus.CREATED);
    }




}
