package com.app.dronesapp.service;

import com.app.dronesapp.entity.drone;
import com.app.dronesapp.repository.drone_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class drone_service_implementation implements drone_service{

    @Autowired
    drone_repository drone_repository;

    @Override
    public drone createDrone(drone drone) {
        return drone_repository.save(drone);
    }

    @Override
    public List<drone> getAllDrones() {
        return drone_repository.findAll();
    }

    @Override
    public Optional<drone> getDroneById(int id) {
        return drone_repository.findById(id);
    }

    @Override
    public List<drone> getAvailableDrones() {
        return drone_repository.getAvailableDrones();
    }


}
