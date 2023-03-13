package com.app.dronesapp.entity;

import jakarta.persistence.*;

import java.util.Date;

public class transport_history {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int history_id;

    private Date pickup_date;

    private Date delivery_date;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "drone")
    private drone drone;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "medication")
    private medication medication;
}
