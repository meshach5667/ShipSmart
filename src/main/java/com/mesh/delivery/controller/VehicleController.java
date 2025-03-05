package com.mesh.delivery.controller;

import com.mesh.delivery.Entity.Item;
import com.mesh.delivery.service.ItemService;
import com.mesh.delivery.service.VehicleServiceImpl;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
    private VehicleServiceImpl vehicleServiceImpl;

    @Autowired
    private ItemService itemService;

    @PostMapping("/create-vehicle")
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
        vehicleService.createVehicle(vehicle);
        return ResponseEntity.ok(vehicle);
    }

    @PostMapping("/create-item")
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        Item newItem = itemService.createItem(item);
        return ResponseEntity.ok(newItem);
    }

    @GetMapping("/get-vehicle/{plateNumber}")
    ResponseEntity<Vehicle> getVehicleByPlateNumber(@PathVariable String plateNumber) {
        Vehicle vehicle = vehicleService.getVehicleByPlateNumber(plateNumber);
        return ResponseEntity.ok(vehicle);
    }

    @PostMapping("add-item-to-vehicle/{plateNumber}/item/{itemId}")
    ResponseEntity<?> addItemToVehicle(@PathVariable String plateNumber, @PathVariable Long itemId) {
        Item item = itemService.getItemById(itemId);
        Vehicle vehicle = vehicleService.getVehicleByPlateNumber(plateNumber);
        List<Item> items = vehicle.getItems();
        float weightOnVehicle = 0;
       
         if (vehicle == null || item == null) {
             return ResponseEntity.badRequest().body("Vehicle or Item not found");
         }

         float totalWeight = vehicle.getItems().stream().map(Item::getWeight).reduce(0f, Float::sum);
//         Float remainingWeight = vehicle.getCarryingWeight() - totalWeight;
//         if (remainingWeight < item.getWeight()) {
//             return ResponseEntity.badRequest().body("Item weight is more than the remaining weight of the vehicle");
//         }
//

        for (Item listItem : items) {
            weightOnVehicle += listItem.getWeight();
        }

        if ((weightOnVehicle + item.getWeight()) <= vehicle.getCarryingWeight()) {
            vehicle.getItems().add(item);
            vehicleService.createVehicle(vehicle);
            return ResponseEntity.ok(vehicle);
        } else {
            return ResponseEntity.badRequest().body("Too much weight for this vehicle");
        }
    }
}