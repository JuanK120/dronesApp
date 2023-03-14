package com.app.dronesapp.service;

import com.app.dronesapp.entity.model;
import com.app.dronesapp.repository.model_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class model_service_implementation implements model_service{

    @Autowired
    model_repository model_repository;

    @Override
    public List<model> getAllModels() {
        return model_repository.findAll();
    }

    @Override
    public Optional<model> getModelById(int id) {
        return model_repository.findById(id);
    }
}
