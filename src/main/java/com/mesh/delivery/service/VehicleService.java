package com.mesh.delivery.service;

import com.mesh.delivery.Entity.Vehicle;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public interface VehicleService {

    Vehicle createVehicle(Vehicle vehicle);
    Vehicle updateVehicle(Long id, Vehicle vehicle);
    List<Vehicle> getAllVehicles();
    Vehicle getVehicleByPlateNumber(String plateNumber);
    void deleteVehicle(Long id);
}



    

