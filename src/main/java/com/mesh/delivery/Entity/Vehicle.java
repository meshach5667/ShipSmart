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
//    @Column(nullable = false, columnDefinition = "FLOAT DEFAULT 0.0")
//    private Float remainingWeight;
//
//    public Float getRemainingWeight() {
//        return remainingWeight;
//    }
//
//    public void setRemainingWeight(Float remainingWeight) {
//        this.remainingWeight = remainingWeight;
//    }

    @OneToMany
    private List<Item> items;

    @Version
    private Long version = 0L;

    public Vehicle() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(float fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public float getCarryingWeight() {
        return carryingWeight;
    }

    public void setCarryingWeight(float carryingWeight) {
        this.carryingWeight = carryingWeight;
    }

    public float getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(float totalWeight) {
        this.totalWeight = totalWeight;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

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