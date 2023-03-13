package com.app.dronesapp.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

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
    @JoinColumn(name = "state")
    private drone_state state;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "model")
    private model model;
}
