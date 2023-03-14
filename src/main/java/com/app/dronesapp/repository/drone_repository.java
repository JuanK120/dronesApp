package com.app.dronesapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.app.dronesapp.entity.drone;

import java.util.List;

@Repository
public interface drone_repository extends JpaRepository<drone,Integer>{

    @Query("from drone d where d.battery_capacity >= 25")
    List<drone> getAvailableDrones();
}
