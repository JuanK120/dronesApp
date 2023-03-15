package com.app.dronesapp.controller;


import com.app.dronesapp.entity.medication;
import com.app.dronesapp.service.medication_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.dronesapp.service.drone_state_service;
import com.app.dronesapp.entity.drone_state;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/drone_state")
public class drone_state_controller {

    @Autowired
    drone_state_service drone_state_service;

    @GetMapping()
    public ResponseEntity<List<drone_state>> getAllDroneStates(){
        return new ResponseEntity<>(drone_state_service.getAllDroneStates(), HttpStatus.OK);
    };

    @GetMapping("/{id}")
    public ResponseEntity<drone_state> getDroneState(@PathVariable("id")int id){
        return drone_state_service.getDroneStateById(id).map(
                medication -> new ResponseEntity<>(medication, HttpStatus.OK)
        ).orElse(
                new ResponseEntity<>(HttpStatus.NOT_FOUND)
        );
    };
}
