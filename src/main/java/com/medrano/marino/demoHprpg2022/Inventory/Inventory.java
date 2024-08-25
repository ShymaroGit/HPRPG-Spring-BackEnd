package com.medrano.marino.demoHprpg2022.Inventory;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.medrano.marino.demoHprpg2022.Character.Characters;
import com.medrano.marino.demoHprpg2022.Character.CharacterElements;
import com.medrano.marino.demoHprpg2022.Items.Items;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "characters_items")
public class Inventory extends CharacterElements {
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="fk_item_id", referencedColumnName = "id")
    private Items item;

    public Inventory() {
    }

    public Inventory(Characters character, Items item, int progression) {
        this.character = character;
        this.item = item;
        this.progression = progression;
        this.added_at = new Date();
    }

    public Inventory(Characters character, Items item, int progression, int quantity, boolean visible) {
        this.character = character;
        this.item = item;
        this.progression = progression;
        this.quantity = quantity;
        this.visible = visible;
        this.added_at = new Date();
    }

    public Inventory(@JsonProperty("id") int id, @JsonProperty("fk_character_id") Characters character, Items item, int progression, int quantity, boolean visible) {
        this.id = id;
        this.character = character;
        this.item = item;
        this.progression = progression;
        this.quantity = quantity;
        this.visible = visible;
        this.added_at = new Date();
    }
    public Inventory(@JsonProperty("id") int id,
                     @JsonProperty("fk_character_id") Characters character, Items item, int progression, int quantity, boolean visible, Date added_at) {
        this.id = id;
        this.character = character;
        this.item = item;
        this.progression = progression;
        this.quantity = quantity;
        this.visible = visible;
        this.added_at = added_at;
    }

    public Items getItem() {
        return item;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventory_id=" + id +
                ", character=" + character +
                ", item=" + item +
                ", progression=" + progression +
                ", quantity=" + quantity +
                ", isVisible=" + visible +
                ", added_at=" + added_at +
                '}';
    }
}
