package com.app.dronesapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.dronesapp.entity.medication;

@Repository
public interface medication_repository extends JpaRepository<medication,Integer>{
}