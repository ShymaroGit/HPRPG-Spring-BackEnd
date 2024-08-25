package com.medrano.marino.demoHprpg2022.Inventory;

import com.medrano.marino.demoHprpg2022.Character.Characters;
import com.medrano.marino.demoHprpg2022.Items.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InventoryService {
    private InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }

    public List<IInventorySimple> getInventories(){
        return inventoryRepository.getInventories();
    }

    public List<IInventorySimple> getInventoryByCharacterId(int id) {
        return inventoryRepository.getInventoryByCharacterId(id);
    }

    public ICharacterInventoryCount getCharacterAmount(int id){
        return inventoryRepository.getItemsCountByCharacterId(id);
    }

    public void addItemToCharacterInventory(Inventory invSent){
        inventoryRepository.save(invSent);
    }

    private List<Inventory> objToInventoryCompact(List<Object[]> list){
        List<Inventory> inv = new ArrayList<Inventory>();
        for(int i = 0; i < list.size(); i++) {
            System.out.println("-- " + i);

            for(int j = 0; j < Arrays.stream(list.stream().toList().get(i)).toList().size();j++){
                System.out.println(j + ": "  + Arrays.stream(list.stream().toList().get(i)).toList().get(j));
            }

            List invList = Arrays.stream(list.stream().toList().get(i)).toList();
            int inv_id = (int) invList.get(0);
            Date inv_date =  (Date) invList.get(1);
            Characters c = (Characters) invList.get(2);
            Boolean is_visible = (Boolean) invList.get(3);
            Items item = (Items) invList.get(4);
            int inv_progression = (int) invList.get(5);
            int inv_quantity = (int) invList.get(6);

            System.out.println(c);
            System.out.println(item);

            Inventory n = new Inventory(inv_id,c,item,inv_progression,inv_quantity,is_visible,inv_date);
            inv.add(n);
        }
        return inv;
    }

    
}
