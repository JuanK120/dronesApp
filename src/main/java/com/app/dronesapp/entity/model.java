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
    private int weigth_limit;
}