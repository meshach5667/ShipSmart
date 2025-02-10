package com.mesh.delivery.service;

import com.mesh.delivery.Entity.Item;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ItemService {
    Item createItem(Item item);
    Item getItemById(Long id);
    List<Item> getAllItems();
    void deleteItem(Long id);
}

