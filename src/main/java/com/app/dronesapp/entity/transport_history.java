package com.app.dronesapp.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="transport_history")
public class transport_history {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int history_id;

    private Date pickup_date;

    private Date delivery_date;

    private boolean delivered;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "drone_id")
    private drone drone;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "medication_id")
    private medication medication;

    public int getHistory_id() {
        return history_id;
    }

    public void setHistory_id(int history_id) {
        this.history_id = history_id;
    }

    public Date getPickup_date() {
        return pickup_date;
    }

    public void setPickup_date(Date pickup_date) {
        this.pickup_date = pickup_date;
    }

    public Date getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(Date delivery_date) {
        this.delivery_date = delivery_date;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public drone getDrone() {
        return drone;
    }

    public void setDrone(drone drone) {
        this.drone = drone;
    }

    public medication getMedication() {
        return medication;
    }

    public void setMedication(medication medication) {
        this.medication = medication;
    }
}
