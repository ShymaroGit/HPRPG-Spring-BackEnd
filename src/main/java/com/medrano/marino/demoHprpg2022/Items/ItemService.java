package com.medrano.marino.demoHprpg2022.Items;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class ItemService {
    static boolean fullSearch = false;
    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Items> getAllItems(){
        return this.itemRepository.findAll();
    }

    public Items getById(int id){
        return this.itemRepository.getById(id);
    }

    public List<Items> getByName(String name){
        return this.itemRepository.getByName(name);
    }

    public List<Items> getByType(String type){
        return this.itemRepository.getByType(type);
    }

    public List<Items> getByWordInDescription(String word){
        return this.itemRepository.getByWordsInDescription(word);
    }

    public void createItem(Items item){
        this.itemRepository.save(item);
    }

    public void deleteItem(Items item){
        this.itemRepository.deleteById(item.getId());
    }
    public List<ItemType> getItemTypes(){
        return Arrays.stream(ItemType.values()).toList();
    }

    public void updateItem(Items item){
        this.itemRepository.updateItem(item.getId(),item.getName(), item.getDescription(),item.getItem_type(),item.getMax_progression(),item.isVisible());
    }
}
