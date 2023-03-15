package com.app.dronesapp.service;

import com.app.dronesapp.entity.drone;
import com.app.dronesapp.entity.drone_state;
import com.app.dronesapp.repository.drone_repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class drone_service_implementation implements drone_service{

    @Autowired
    drone_repository drone_repository;

    @Autowired
    com.app.dronesapp.repository.drone_state_repository drone_state_repository;

    private static final Logger log = LoggerFactory.getLogger(drone_service_implementation.class);

    @Override
    public drone createDrone(drone drone) {
        if (drone.getBattery_capacity() < 25){
            drone.setState(drone_state_repository.findDroneStateByName("LOADED").get());
        }
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

    @Override
    public boolean changeDroneState(int id, drone_state State) {
        drone_repository.findById(id).map(
                drone -> {
                    drone.setState(State);
                    drone_repository.save(drone);
                    return true;
                }
        );
        return false;
    }

    @Scheduled(fixedRate = 30000)
    @Async
    public void check_Battery_Levels(){
        drone_repository.findAll().stream().forEach(drone -> {
            log.info("drone " + drone.getSerial_number() + " is at "+ drone.getBattery_capacity()+"% battery");
            if ((drone.getBattery_capacity()<25)
                    && (drone.getState().getState_name() == "LOADING")){
                drone_repository.findById(drone.getDrone_id()).map(
                        d -> {
                            d.setState(drone_state_repository.findDroneStateByName("LOADED").get());
                            drone_repository.save(drone);
                            return true;
                        }
                );
            }
        });
    }


}
