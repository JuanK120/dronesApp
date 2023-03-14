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

    public int getState_id() {
        return state_id;
    }

    public void setState_id(int state_id) {
        this.state_id = state_id;
    }

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }
}
