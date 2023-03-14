package com.app.dronesapp.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;


@Entity
@Table(name="drone")
public class drone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int drone_id;

    @Nonnull
    @Size(max = 100)
    private String serial_number;

    @Nonnull
    @Min(0)
    @Max(100)
    private int battery_capacity;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "state_id")
    private drone_state state;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "model_id")
    private model model;

    public int getDrone_id() {
        return drone_id;
    }

    public void setDrone_id(int drone_id) {
        this.drone_id = drone_id;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public int getBattery_capacity() {
        return battery_capacity;
    }

    public void setBattery_capacity(int battery_capacity) {
        this.battery_capacity = battery_capacity;
    }

    public drone_state getState() {
        return state;
    }

    public void setState(drone_state state) {
        this.state = state;
    }

    public com.app.dronesapp.entity.model getModel() {
        return model;
    }

    public void setModel(com.app.dronesapp.entity.model model) {
        this.model = model;
    }
}
