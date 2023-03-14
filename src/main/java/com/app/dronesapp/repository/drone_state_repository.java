package com.app.dronesapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.dronesapp.entity.drone_state;

@Repository
public interface drone_state_repository extends JpaRepository<drone_state,Integer> {
}
