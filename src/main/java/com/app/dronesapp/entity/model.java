package com.app.dronesapp.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name="model")
public class model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int model_id;

    @Nonnull
    private String model_name;

    @Nonnull
    @Min(0)
    @Max(500)
    private int weight_limit;

    public int getModel_id() {
        return model_id;
    }

    public void setModel_id(int model_id) {
        this.model_id = model_id;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public int getWeight_limit() {
        return weight_limit;
    }

    public void setWeight_limit(int weigth_limit) {
        this.weight_limit = weigth_limit;
    }
}