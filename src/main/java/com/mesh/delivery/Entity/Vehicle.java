package com.mesh.delivery.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

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
    private java.util.List<Item> items;

    public Vehicle() {}

    public Vehicle(Long id, String name, String plateNumber, String status, String type,
                   float fuelCapacity, float carryingWeight, float totalWeight, java.util.List<Item> items) {
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