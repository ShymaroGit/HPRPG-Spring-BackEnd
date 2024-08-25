package com.medrano.marino.demoHprpg2022.Spellbook;

import com.medrano.marino.demoHprpg2022.Character.CharacterElements;
import com.medrano.marino.demoHprpg2022.Character.Characters;
import com.medrano.marino.demoHprpg2022.Spells.Spells;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "character_spells")
public class SpellBooks extends CharacterElements {

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_spell_id", referencedColumnName = "id")
    private Spells spell;

    public SpellBooks() {
    }

    public SpellBooks(int id, Characters character, Spells spell, int progression,  boolean visible, Date added_at) {
        super(id, character, progression,1, visible, added_at);
        this.spell = spell;
    }

    public SpellBooks(Characters character, Spells spell, int progression, boolean visible) {
        super(character, progression, 1, visible, new Date());
        this.spell = spell;
    }

    public Spells getSpell() {
        return spell;
    }
}
