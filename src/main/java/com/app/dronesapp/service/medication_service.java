package com.app.dronesapp.service;

import com.app.dronesapp.entity.medication;

import java.util.List;
import java.util.Optional;

public interface medication_service {
    public List<medication> getAllMedications();
    public Optional<medication> getMedicationById(int id);
}
