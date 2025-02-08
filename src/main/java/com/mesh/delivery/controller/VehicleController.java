package com.mesh.delivery.controller;

import com.mesh.delivery.Entity.Item;
import com.mesh.delivery.service.ItemService;
import com.mesh.delivery.service.VehicleServiceImpl;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.mesh.delivery.Entity.Vehicle;
import com.mesh.delivery.service.VehicleService;

import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/v1/vehicle")
public class VehicleController {

    private final ItemService itemService;
    private final VehicleService vehicleService;

    public VehicleController(ItemService itemService, VehicleService vehicleService) {
        this.itemService = itemService;
        this.vehicleService = vehicleService;
    }

    @PostMapping("/create-vehicle")
    ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle){
        vehicleService.createVehicle(vehicle);
        return ResponseEntity.ok(vehicle);
    }

    @GetMapping("/get-vehicle/{plateNumber}")
    ResponseEntity<Vehicle> getVehicleByPlateNumber(@PathVariable String plateNumber){
        Vehicle vehicle = vehicleService.getVehicleByPlateNumber(plateNumber);
        return ResponseEntity.ok(vehicle);
    }

    @PostMapping("add-item-to-vehicle/{plateNumber}/item/{itemId}")
    ResponseEntity<Vehicle> addItemToVehicle(@PathVariable String plateNumber, @PathVariable Long itemId){
        Item item = itemService.getItemById(itemId);
        Vehicle vehicle = vehicleService.getVehicleByPlateNumber(plateNumber);
        List<Item> items = vehicle.getItems();
        float weightOnVehicle = 0;

        for(Item listItem: items){
            weightOnVehicle += listItem.getWeight();
        }

        if ((weightOnVehicle + item.getWeight()) < vehicle.getCarryingWeight()){
            vehicle.getItems().add(item);
            vehicleService.createVehicle(vehicle);
            return ResponseEntity.ok(vehicle);
        }else {
            throw new RuntimeException("Too much weight to this vehicle");
        }

    }
}
