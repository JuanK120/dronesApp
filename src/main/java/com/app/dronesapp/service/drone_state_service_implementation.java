package com.app.dronesapp.service;

import com.app.dronesapp.entity.drone_state;
import com.app.dronesapp.repository.drone_state_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class drone_state_service_implementation implements drone_state_service{
    @Autowired
    drone_state_repository drone_state_repository;

    @Override
    public List<drone_state> getAllDroneStates() {
        return drone_state_repository.findAll();
    }

    @Override
    public Optional<drone_state> getDroneStateById(int id) {
        return drone_state_repository.findById(id);
    }

    @Override
    public Optional<drone_state> getDroneStateByName(String name) {
        return drone_state_repository.findDroneStateByName(name);
    }

}
