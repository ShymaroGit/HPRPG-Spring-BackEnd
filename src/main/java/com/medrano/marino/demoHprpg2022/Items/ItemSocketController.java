package com.medrano.marino.demoHprpg2022.Items;

import com.medrano.marino.demoHprpg2022.Debugger;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@Controller
public class ItemSocketController {
    private ItemService itemService;
    @Autowired
    public ItemSocketController(ItemService itemService) {
        this.itemService = itemService;
    }

    @MessageMapping("/items")
    @SendTo("/hprpg/i/")
    public List<Items> getItems() throws Exception{
        Debugger.log("Item List");
         return itemService.getAllItems();
     }
    @MessageMapping("/i/count")
    @SendTo("/hprpg/i/count")
     public String getItemsCount() throws Exception{
        String itemCount =
                "{\"itemCount\": \""
                + HtmlUtils.htmlEscape("" + itemService.getAllItems().size())
                + "\"}";
        return itemCount;
    }
    @MessageMapping("/i/addTest")
    @SendTo("/hprpg/i/count")
     public String  updateItem(){
        itemService.createItem(new Items("Test" + itemService.getAllItems().size() + 1,"Test d'un item suivit d'un nombre", ItemType.Other));
        String itemCount =
                "{\"itemCount\": \""
                        + HtmlUtils.htmlEscape("" + itemService.getAllItems().size())
                        + "\"}";
        return itemCount;
    }

}
