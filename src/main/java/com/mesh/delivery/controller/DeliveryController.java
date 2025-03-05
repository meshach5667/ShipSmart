package com.mesh.delivery.controller;

import com.mesh.delivery.Entity.Vehicle;
import com.mesh.delivery.service.ItemService;
import com.mesh.delivery.Entity.Item;
import com.mesh.delivery.service.VehicleService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeliveryController {

    private final VehicleService vehicleService;
    private final ItemService itemService;

    public DeliveryController(VehicleService vehicleService, ItemService itemService) {
        this.vehicleService = vehicleService;
        this.itemService = itemService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/create-vehicle")
    public String createVehicle(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        model.addAttribute("allVehicles", vehicleService.getAllVehicles());
        model.addAttribute("allItems", itemService.getAllItems());
        return "feature";
    }

    @PostMapping("/post-vehicle")
    public String postVehicle(Model model, @ModelAttribute("vehicle") Vehicle vehicle) {
        vehicleService.createVehicle(vehicle);
        model.addAttribute("message", "Vehicle created successfully");
        return "redirect:/create-vehicle";
    }

    @GetMapping("/create-item")
    public String createItem(Model model) {
        model.addAttribute("item", new Item());
        model.addAttribute("allItems", itemService.getAllItems());
        return "item";
    }

    @PostMapping("/post-item")
    public String postItem(Model model, @ModelAttribute("item") Item item) {
        itemService.createItem(item);
        model.addAttribute("message", "Item created successfully");
        return "redirect:/create-item";
    }

    @PostMapping("/add-item-to-vehicle")
    public String postItem(Model model, @RequestParam Long itemId, @RequestParam String plateNumber) {
        Vehicle vehicle = vehicleService.getVehicleByPlateNumber(plateNumber);
        Item item = itemService.getItemById(itemId);

        if (vehicle == null || item == null) {
            model.addAttribute("message", "Vehicle or Item not found");
            return "redirect:/create-vehicle";
        }

        float totalWeight = vehicle.getItems().stream().map(Item::getWeight).reduce(0f, Float::sum);
//        float remainingWeight = 0.0F;
//        if (vehicle.getItems() != null && !vehicle.getItems().isEmpty()) {
//            remainingWeight = vehicle.getItems().stream()
//                    .map(Item::getWeight)
//                    .reduce(0f, Float::sum);
//        }
//        vehicle.setRemainingWeight(remainingWeight);


//        model.addAttribute("remainingWeight", remainingWeight);
//
//        if (remainingWeight < item.getWeight()) {
//            model.addAttribute("message", "Item weight exceeds vehicle carrying weight");
//            return "redirect:/create-vehicle";
//        }

        if ((totalWeight + item.getWeight()) <= vehicle.getCarryingWeight()) {
            vehicle.getItems().add(item);
            vehicleService.createVehicle(vehicle);
            model.addAttribute("message", "Item added to vehicle successfully");
        } else {
            model.addAttribute("message", "Too much weight for this vehicle");
        }
        return "redirect:/create-vehicle";
    }

}
