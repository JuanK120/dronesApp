package com.app.dronesapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.app.dronesapp.entity.drone_state;

import java.util.Optional;

@Repository
public interface drone_state_repository extends JpaRepository<drone_state,Integer> {
    @Query("from drone_state where state_name=?1")
    Optional<drone_state> findDroneStateByName(String name);
}
