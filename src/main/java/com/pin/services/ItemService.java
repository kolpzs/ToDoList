package com.pin.services;

import com.pin.entities.ItemEntity;
import com.pin.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public ItemEntity save(ItemEntity item){
        return itemRepository.save(item);
    }

    public ItemEntity findById(Long id){
        return itemRepository.findById(id).orElseThrow(()->new RuntimeException("Item not found"));
    }

    public List<ItemEntity> findAll(){
        return itemRepository.findAll();
    }

    public ItemEntity update(ItemEntity item){
        return itemRepository.save(item);
    }

    public String delete(Long id){
        itemRepository.deleteById(id);
        return "Item deleted";
    }
}
