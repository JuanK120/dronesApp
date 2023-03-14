package com.app.dronesapp.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="medication")
public class medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int medication_id;

    @Nonnull
    @Pattern(regexp = "^[a-zA-Z0-9_-]*$")
    private String name;

    @Nonnull
    private int weight;

    @Pattern(regexp = "^[A-Z0-9_]*$")
    private String code;

    @Lob
    @Column(name = "image", length = 1000)
    private byte[] image;

    public int getMedication_id() {
        return medication_id;
    }

    public void setMedication_id(int medication_id) {
        this.medication_id = medication_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
