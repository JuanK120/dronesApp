package com.app.dronesapp.service;

import com.app.dronesapp.entity.medication;
import com.app.dronesapp.entity.transport_history;
import com.app.dronesapp.repository.transport_history_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class transport_history_service_implementation implements  transport_history_service{

    @Autowired
    transport_history_repository transport_history_repository;

    @Override
    public transport_history createTransportHistory(transport_history transport_history) {
        return transport_history_repository.save(transport_history);
    }

    @Override
    public Optional<transport_history> getTransportHistory(int id) {
        return transport_history_repository.findById(id);
    }

    @Override
    public transport_history deliverMedication(transport_history transport_history) {
        transport_history history = transport_history_repository.findById(
                transport_history.getHistory_id()).get();
        history.setDelivery_date(new Date());
        history.setDelivered(true);
        return transport_history_repository.save(history);
    }

    @Override
    public int checkDroneWeigth(int droneId) {

        if (transport_history_repository.getDroneWeigth(droneId)==null){
            System.out.println(transport_history_repository.getDroneWeigth(droneId));
            return 0;
        }else {
            System.out.println(transport_history_repository.getDroneWeigth(droneId).intValue());
            return transport_history_repository.getDroneWeigth(droneId).intValue();
        }
    }

    @Override
    public List<transport_history> checkDronePayload(int droneId) {
        return transport_history_repository.getDronePayload(droneId);
    }

}
