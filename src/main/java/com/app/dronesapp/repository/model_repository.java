package com.app.dronesapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.dronesapp.entity.model;

@Repository
public interface model_repository extends JpaRepository<model,Integer>{
}
