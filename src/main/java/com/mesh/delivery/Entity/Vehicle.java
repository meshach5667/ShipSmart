package com.mesh.delivery.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String plateNumber;
    private String status;
    private String type;
    private float fuelCapacity;
    private float carryingWeight;
    private float totalWeight;

    @OneToMany
    private List<Item> items;

    @Version
    private Long version = 0L;

    public Vehicle() {}

    public Vehicle(Long id, String name, String plateNumber, String status, String type,
                   float fuelCapacity, float carryingWeight, float totalWeight, List<Item> items) {

        this.version = 0L;
        this.id = id;
        this.name = name;
        this.plateNumber = plateNumber;
        this.status = status;
        this.type = type;
        this.fuelCapacity = fuelCapacity;
        this.carryingWeight = carryingWeight;
        this.totalWeight = totalWeight;
        this.items = items;
       
    }
}