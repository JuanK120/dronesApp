package com.app.dronesapp.service;

import java.util.List;
import java.util.Optional;

import com.app.dronesapp.entity.drone_state;


public interface drone_state_service {
    public List<drone_state> getAllDroneStates();
    public Optional<drone_state> getDroneStateById(int id);
}
