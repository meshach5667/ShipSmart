package com.mesh.delivery.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private float weight;
    @Column(unique = true)
    private String code;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Item() {
        this.code = generateUniqueCode();
    }

    public Item(Long id, String name, float weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.code = generateUniqueCode();
    }

    private String generateUniqueCode() {
        return UUID.randomUUID().toString();
    }
}