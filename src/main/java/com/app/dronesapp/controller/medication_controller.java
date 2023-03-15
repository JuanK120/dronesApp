package com.app.dronesapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.dronesapp.service.medication_service;
import com.app.dronesapp.entity.medication;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/medication")
public class medication_controller {

    @Autowired
    medication_service medication_service;

    @GetMapping()
    public ResponseEntity<List<medication>> getAllMedications(){
        return new ResponseEntity<>(medication_service.getAllMedications(), HttpStatus.OK);
    };

    @GetMapping("/{id}")
    public ResponseEntity<medication> getAllMedications(@PathVariable("id")int id){
        return medication_service.getMedicationById(id).map(
                medication -> new ResponseEntity<>(medication, HttpStatus.OK)
        ).orElse(
                new ResponseEntity<>(HttpStatus.NOT_FOUND)
        );
    };

}


