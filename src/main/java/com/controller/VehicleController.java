package com.controller;

import com.mesh.delivery.Entity.Item;
import com.mesh.delivery.service.ItemService;
import com.mesh.delivery.service.VehicleServiceImplemenntation;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import com.mesh.delivery.Entity.Vehicle;
import com.mesh.delivery.service.VehicleService;

import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/v1/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private VehicleServiceImplemenntation vehicleServiceImplemenntation;

    @PostMapping("/create-vehicle")
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
        vehicleService.createVehicle(vehicle);
        return ResponseEntity.ok(vehicle);
    }

    @GetMapping("/get-vehicle/{plateNumber}")
    ResponseEntity<Vehicle> getVehicleByplateNumber(@PathVariable String plateNumber) {
        Vehicle vehicle = vehicleService.getVehicleByPlateNumber(plateNumber);
        return  ResponseEntity.ok(vehicle);
    }
    @PostMapping("add-item-to-vehicle/{plateNumber}/item/{itemId}")
    ResponseEntity<Vehicle> addItemToVehicle(@PathVariable String plateNumber, @PathVariable Long itemId){
        Item item = ItemService.getItemById(itemId);
        Vehicle vehicle = vehicleService.getVehicleByPlateNumber(plateNumber);
        vehicle.getItems().add(item);
        vehicleService.createVehicle(vehicle);
        return ResponseEntity.ok(vehicle);
    }

}
