package com.app.dronesapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.app.dronesapp.entity.transport_history;
import  com.app.dronesapp.entity.medication;

import java.util.List;

@Repository
public interface transport_history_repository extends JpaRepository<transport_history,Integer>{

    @Query("select sum(m.weight) from transport_history h join " +
            "                           medication m on h.medication.medication_id = m.medication_id" +
            "                      where h.drone.drone_id=?1 and h.delivered=false")
    int getDroneWeigth(int drone_id);


    @Query("from medication m where m in (" +
                "select h.medication from transport_history h " +
                    "where h.drone.drone_id = ?1 " +
            "          and h.delivered=false" +
            ")")
    List<medication> getDronePayload(int drone_id);
}
