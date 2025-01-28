package com.controller;

import com.mesh.delivery.Entity.Item;
import com.mesh.delivery.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/item")
public class ItemController {
    private final ItemService itemService;


    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("create-item")
    ResponseEntity<Item> createItem(@RequestBody Item item){
        Item newItem = ItemService.createItem(item);
        return ResponseEntity.ok(newItem);
    }
}
