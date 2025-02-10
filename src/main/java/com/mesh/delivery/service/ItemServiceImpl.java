package com.mesh.delivery.service;

import com.mesh.delivery.Entity.Item;
import com.mesh.delivery.repositorys.ItemRepository;


import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {


 private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.findById(id).get();
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
