package com.medrano.marino.demoHprpg2022.Inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/hprpg/inv/")
public class InventoryRESTController {
    private InventoryService inventoryService;
    @Autowired
    public InventoryRESTController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    public List<IInventorySimple> getIventorys(){
        return inventoryService.getInventories();
    }

    @GetMapping(path = "{id}")
    public List<IInventorySimple> getInventoryByCharacterId(@PathVariable("id") int id){
        return inventoryService.getInventoryByCharacterId(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "qty/{id}")
    public ICharacterInventoryCount getInventoryAmountByCharacterId(@PathVariable("id") int id){
        return inventoryService.getCharacterAmount(id);
    }

    @PostMapping(path = "add")
    public void addItemToCharacterInventory(@RequestBody Inventory invSent){
       if (invSent.getCharacter() != null && invSent.getItem() != null){

       }
    }

}
