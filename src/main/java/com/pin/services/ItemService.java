package com.pin.services;

import com.pin.entities.ItemEntity;
import com.pin.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public String favorite(Long id) {
        ItemEntity item = findById(id);
        item.setFavorito(true);

        return item.getId() + " favorited";
    }

    public List<ItemEntity> findAllUnMarked(Long id) {
        List<ItemEntity> total = findAllGroup(id);
        List<ItemEntity> list = new ArrayList<>();
        for (ItemEntity item : total) {
            if (!item.isFeita()) {
                list.add(item);
            }
        }
        return list;
    }

    public List<ItemEntity> findAllGroup(Long id) {
        List<ItemEntity> total = itemRepository.findAll();
        List<ItemEntity> list = new ArrayList<>();
        for (ItemEntity item : total) {
            if (Objects.equals(item.getGrupo().getId(), id)) {
                list.add(item);
            }
        }
        return list;
    }

    public List<List<ItemEntity>> findAll20(Long id) {
        List<ItemEntity> total = findAllGroup(id);
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
