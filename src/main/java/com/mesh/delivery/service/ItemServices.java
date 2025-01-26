package com.mesh.delivery.service;

import com.mesh.delivery.Entity.Item;

public interface ItemServices {
    Item createItem();

    Item createItem(Item item);

    void deleteItem(Long id);
}
