package com.mesh.delivery.service;

import com.mesh.delivery.Entity.Item;

public interface ItemService {
    Item createItem(Item item);

    void deleteItem(Long id);
}
