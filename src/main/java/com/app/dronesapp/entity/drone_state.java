package com.app.dronesapp.entity;


import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

@Entity
@Table(name="drone_state")
public class drone_state {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int state_id;

    @Nonnull
    private String state_name;
}
