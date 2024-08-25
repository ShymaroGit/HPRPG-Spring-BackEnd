package com.medrano.marino.demoHprpg2022.Items;

import java.util.stream.Stream;

public enum ItemType {
    Book("Book"),Broom("Broom"),Paper("Paper"),Accessory("Accessory"),
    Clothe("Clothe"),Other("Other"),Potion("Potions"),Tool("Tool"),
    Toy("Toy"),Collectible("Collectible"), Consumable("Consumable");

    private String item_type;

    ItemType(String item_type) {
        this.item_type = item_type;
    }

    public String getItem_type(){
        return item_type;
    }

    public static ItemType of(String item_type){
        return Stream.of(ItemType.values())
                .filter(i -> i.getItem_type().equalsIgnoreCase(item_type))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
