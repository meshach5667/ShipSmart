package com.mesh.delivery.controller;


import com.mesh.delivery.Entity.Vehicle;
import com.mesh.delivery.service.ItemService;
import com.mesh.delivery.Entity.Item;
import com.mesh.delivery.service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DeliveryController {

    private final VehicleService vehicleService;
    private final ItemService itemService;

    public DeliveryController(VehicleService vehicleService, ItemService itemService) {
        this.vehicleService = vehicleService;
        this.itemService = itemService;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/create-vehicle")
    public String createVehicle(Model model){
        Vehicle vehicle = new Vehicle();
        model.addAttribute("vehicle", vehicle)
                .addAttribute("allVehicles", vehicleService.getAllVehicles());
        return "feature";
    }

    @PostMapping("/post-vehicle")
    public String postVehicle(Model model, @ModelAttribute("vehicle") Vehicle vehicle){
        String message = "Vehicle created successfully";
        vehicleService.createVehicle(vehicle);
        model.addAttribute("message", message);
        return "feature";
    }

    @GetMapping("/create-item")
    public String createItem(Model model){
        Item item = new Item();
        model.addAttribute("item", item)
                .addAttribute("allItems", itemService.getAllItems());
        return "item";
    }

    @PostMapping("/post-item")
    public String postItem(Model model, @ModelAttribute("item") Item item){
        String message = "Item created successfully";
        itemService.createItem(item);
        model.addAttribute("message", message);
        return "item";
    }
}