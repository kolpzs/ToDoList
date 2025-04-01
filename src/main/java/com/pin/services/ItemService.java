package com.pin.services;

import com.pin.entities.ItemEntity;
import com.pin.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public ItemEntity save(ItemEntity item) {
        return itemRepository.save(item);
    }

    public ItemEntity findById(Long id) {
        return itemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));
    }

    public List<List<ItemEntity>> findAll() {
        List<ItemEntity> total = itemRepository.findAll();
        List<List<ItemEntity>> separados = new ArrayList<>();

        for (int i = 0; i < total.size(); i += 20) {
            List<ItemEntity> subLista = total.subList(i, Math.min(i + 20, total.size()));
            separados.add(new ArrayList<>(subLista));
        }

        return separados;
    }

    public ItemEntity update(ItemEntity item) {
        return itemRepository.save(item);
    }

    public String delete(Long id) {
        itemRepository.deleteById(id);
        return "Item deleted";
    }
}
