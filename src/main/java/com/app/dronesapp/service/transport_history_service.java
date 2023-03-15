package com.app.dronesapp.service;

import com.app.dronesapp.entity.transport_history;
import com.app.dronesapp.entity.medication;

import java.util.List;
import java.util.Optional;

public interface transport_history_service {
    public transport_history createTransportHistory(transport_history transport_history);
    public Optional<transport_history> getTransportHistory(int id);
    public transport_history deliverMedication(transport_history transport_history);
    public int checkDroneWeigth(int droneId);
    public List<medication> checkDronePayload(int droneId);
}
