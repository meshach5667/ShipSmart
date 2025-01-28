package com.mesh.delivery.service;

import com.mesh.delivery.Entity.Item;
import org.springframework.stereotype.Service;


public interface ItemService {

    static Item getItemById(Item itemId) {
        return itemId;
    }

    Item createItem();

    Item createItem(Item item);

    void deleteItem(Long id);
}
