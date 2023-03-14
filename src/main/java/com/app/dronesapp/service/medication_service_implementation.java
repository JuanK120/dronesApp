package com.app.dronesapp.service;

import com.app.dronesapp.entity.medication;
import com.app.dronesapp.repository.medication_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class medication_service_implementation implements medication_service{

    @Autowired
    medication_repository medication_repository;

    @Override
    public List<medication> getAllMedications() {
        return medication_repository.findAll();
    }

    @Override
    public Optional<medication> getMedicationById(int id) {
        return medication_repository.findById(id);
    }
}
