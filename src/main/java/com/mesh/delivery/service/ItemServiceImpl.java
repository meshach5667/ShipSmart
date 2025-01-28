package com.mesh.delivery.service;

import com.mesh.delivery.Entity.Item;
import com.mesh.delivery.repositorys.ItemsRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
     private ItemsRepository itemRepository;

    @Override
    public Item createItem() {
       return new Item();
    }


    @Override
    public Item createItem(Item item) {
        return null;
    }

    @Override
    public void deleteItem(Long id) {

    }
}
