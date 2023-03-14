package com.app.dronesapp.service;

import java.util.List;
import java.util.Optional;

import com.app.dronesapp.entity.model;

public interface model_service {
    public List<model> getAllModels();
    public Optional<model> getModelById(int id);
}
