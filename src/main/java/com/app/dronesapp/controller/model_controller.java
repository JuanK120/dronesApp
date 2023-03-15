package com.app.dronesapp.controller;


import com.app.dronesapp.entity.medication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.dronesapp.service.model_service;
import com.app.dronesapp.entity.model;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/model")
public class model_controller {

    @Autowired
    model_service model_service;

    @GetMapping()
    public ResponseEntity<List<model>> getAllModels(){
        return new ResponseEntity<>(model_service.getAllModels(), HttpStatus.OK);
    };

    @GetMapping("/{id}")
    public ResponseEntity<model> getModel(@PathVariable("id")int id){
        return model_service.getModelById(id).map(
                model -> new ResponseEntity<>(model, HttpStatus.OK)
        ).orElse(
                new ResponseEntity<>(HttpStatus.NOT_FOUND)
        );
    };
}
