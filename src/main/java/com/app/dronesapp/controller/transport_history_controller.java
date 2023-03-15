package com.app.dronesapp.controller;

import com.app.dronesapp.entity.drone;
import com.app.dronesapp.service.drone_service;
import com.app.dronesapp.service.transport_history_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.dronesapp.entity.medication;
import com.app.dronesapp.entity.transport_history;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/transport")
public class transport_history_controller {

    @Autowired
    com.app.dronesapp.service.drone_service drone_service;

    @Autowired
    com.app.dronesapp.service.transport_history_service transport_history_service;


    @GetMapping("/getPayload/{id}")
    public ResponseEntity<List<transport_history>> getDronePayload(@PathVariable("id") int id){
        return drone_service.getDroneById(id).map(
                drone -> new ResponseEntity<>(
                        transport_history_service.checkDronePayload(id), HttpStatus.OK
                        )
        ).orElse(
                new ResponseEntity<>(HttpStatus.NOT_FOUND)
        );
    }

    @PostMapping()
    public ResponseEntity<transport_history> loadDrone(@RequestBody transport_history transport_history){
        drone drone = transport_history.getDrone();
        medication medication=transport_history.getMedication();
        if (drone.getBattery_capacity() < 25){
            return new ResponseEntity<>(
                    HttpStatus.BAD_REQUEST
            );
        } else if (transport_history_service.checkDroneWeigth(drone.getDrone_id())
                +medication.getWeight() > drone.getModel().getWeight_limit()){
            return new ResponseEntity<>(
                    HttpStatus.BAD_REQUEST
            );
        }
        return new ResponseEntity<>(
                transport_history_service.createTransportHistory(transport_history),
                HttpStatus.CREATED
        );
    }

    @PutMapping()
    public ResponseEntity<transport_history> deliverMedication(@RequestBody transport_history transport_history){
        return new ResponseEntity<>(
                transport_history_service.deliverMedication(transport_history),
                HttpStatus.OK
        );
    }
}
