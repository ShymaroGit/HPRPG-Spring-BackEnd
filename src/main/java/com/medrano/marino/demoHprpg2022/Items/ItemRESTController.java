package com.medrano.marino.demoHprpg2022.Items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/hprpg/items/")
public class ItemRESTController {
    private ItemService itemService;

    @Autowired
    public ItemRESTController(ItemService itemService) {
        this.itemService = itemService;
    }
    //Read
    @GetMapping(path = "types")
    public List<ItemType> getTypes(){
        return itemService.getItemTypes();
    }

    @GetMapping(path = "search/{words}")
    public List<Items> getByWordsInDescription(@PathVariable("words") String words){
        return itemService.getByWordInDescription(words);
    }
    //Create
    /**
     * {
     *     "name": [NAME],
     *     "description": [Description],
     *     "is_visible": true,
     *     "max_progression": 100,
     *     "item_type": "BOOKS"
     * }
     * @param item
     */
    @PostMapping(path = "add")
    public void createItem(@RequestBody Items item){
        System.out.println(item.toString());
        if(item.getName().isEmpty() || item.getName().isBlank() || item.getDescription().isBlank() || item.getDescription().isEmpty()){
            System.out.println("Empty name or description");
        }else{
            Boolean itemIsEmpty = this.itemService.getByName(item.getName()).isEmpty();

            if(itemIsEmpty)
                itemService.createItem(item);
        }
    }
    //Update
    @PutMapping(path = "update")
    public void updateItem(@RequestBody Items item){
        System.out.println(item.toString());
        if(item.getName().isEmpty() || item.getName().isBlank() || item.getDescription().isBlank() || item.getDescription().isEmpty()){
            System.out.println("Empty name or description");
        }else{
            Items itemFound = this.itemService.getById(item.getId());
            Boolean itemIsNotEmpty = !itemFound.getName().isEmpty();
            System.out.println(itemIsNotEmpty);

            if(itemIsNotEmpty)
                itemService.updateItem(item);
        }
    }
    //Delete
    @DeleteMapping(path = "delete/{id}")
    public void deleteItem(@PathVariable("id")int id, @RequestBody Items item){
        if(id >= 0){
            System.out.println("DELETE");
            System.out.println(item.toString());

            Items itemFound = this.itemService.getById(id);
            System.out.println(itemFound);

            Boolean itemsMatch = item.equals(itemFound);
            System.out.println(itemsMatch);

            if(itemsMatch)
                this.itemService.deleteItem(item);
        }

    }
}
