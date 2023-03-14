package com.app.dronesapp.service;

import com.app.dronesapp.entity.transport_history;

import java.util.List;

public interface transport_history_service {
    public transport_history createTransportHistory(transport_history transport_history);
    public transport_history deliverMedication(transport_history transport_history);
    public List<transport_history> checkDroneLoad(int droneId);
}
