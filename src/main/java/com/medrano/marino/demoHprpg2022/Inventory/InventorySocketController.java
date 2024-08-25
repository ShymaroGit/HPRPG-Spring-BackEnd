package com.medrano.marino.demoHprpg2022.Inventory;

import com.medrano.marino.demoHprpg2022.Debugger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class InventorySocketController {
    private InventoryService inventoryService;

    @Autowired
    public InventorySocketController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @MessageMapping("/inventory")
    @SendTo("/hprpg/inv/qty")
    public ICharacterInventoryCount getInventoryQtyByCharacId(int id) throws Exception{
        Debugger.log("Id:" + id);
        //Thread.sleep(5500);
       // Debugger.log("résulat:" + inventoryService.getCharacterAmount(id).getItems_count());
        return inventoryService.getCharacterAmount(id);
    }
}
