package com.medrano.marino.demoHprpg2022.Items;

import com.medrano.marino.demoHprpg2022.Elements;
import com.medrano.marino.demoHprpg2022.Inventory.Inventory;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table
public class Items extends Elements {
    /*@Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int item_id;*/
    @Column(columnDefinition = "integer default 100")
    private int max_progression;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(255) default 'Other'")
    private ItemType item_type = ItemType.Other;

    @OneToMany(mappedBy = "item")
    private Set<Inventory> inventory;

    public Items() {
    }

    public Items(int id, String name, String description, boolean is_visible,  int max_progression, ItemType item_type) {
        super(id,name, description, is_visible);
        this.max_progression = max_progression;
        this.item_type = item_type;
    }

    public Items(String name, String description, ItemType item_type,boolean is_visible,  int max_progression) {
        super(name, description, is_visible);
        this.max_progression = max_progression;
        this.item_type = item_type;
    }

    public Items(String name, String description, ItemType item_type) {
        super(name, description, true);
        this.item_type = item_type;
        this.max_progression = 100;
    }

    /*public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }*/

    public int getMax_progression() {
        return max_progression;
    }

    public void setMax_progression(int max_progression) {
        this.max_progression = max_progression;
    }

    public ItemType getItem_type() {
        return item_type;
    }

    public void setItem_type(ItemType item_type) {
        this.item_type = item_type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Items items = (Items) o;
        return this.id == items.id && max_progression == items.max_progression && item_type.equals(items.item_type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getId(), max_progression, item_type);
    }

    @Override
    public String toString() {
        return "Items{" +
                "item_id=" + id +
                ", max_progression=" + max_progression +
                ", item_type='" + item_type + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", is_visible=" + visible +
                '}';
    }
}
