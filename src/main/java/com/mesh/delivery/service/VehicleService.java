package com.mesh.delivery.service;

import com.mesh.delivery.Entity.Vehicle;

import java.util.List;



public interface VehicleService {
    void createVehicle(Vehicle vehicle);
    Vehicle updatVehicle(Long id, Vehicle vehicle);
    List<Vehicle> getAllVehicles();
    Vehicle getVehicleByPlateNumber(String number);
    void deleteVehicle(Long id);
}


    

