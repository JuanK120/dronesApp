package com.app.dronesapp.service;

import com.app.dronesapp.entity.drone;
import com.app.dronesapp.entity.drone_state;

import java.util.List;
import java.util.Optional;

public interface drone_service {
    public drone createDrone(drone drone);
    public List<drone> getAllDrones();
    public Optional<drone> getDroneById(int id);
    public List<drone> getAvailableDrones();
    public boolean changeDroneState(int id, drone_state State);
    public void check_Battery_Levels();
}
