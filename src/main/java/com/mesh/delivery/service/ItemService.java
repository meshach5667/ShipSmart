package com.mesh.delivery.service;

import com.mesh.delivery.Entity.Item;

public interface ItemService {
    static Item getItemById(Long itemId) {
        return null;
    }

    Item createItem();

    Item createItem(Item item);

    void deleteItem(Long id);
}
