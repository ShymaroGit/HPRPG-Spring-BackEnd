package com.medrano.marino.demoHprpg2022.Spells;

import com.medrano.marino.demoHprpg2022.Elements;
import com.medrano.marino.demoHprpg2022.Spellbook.SpellBooks;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table
public class Spells extends Elements {
    @Column(columnDefinition = "integer default 100")
    private int max_progression;
    @Column(columnDefinition = "varchar(255) default 'Charms'")
    @Enumerated(EnumType.STRING)
    private SpellType spell_type = SpellType.Charms;

    @OneToMany(mappedBy = "spell")
    private List<SpellBooks> spellbook;

    public Spells() {
    }

    public Spells(int id, String name, String description, boolean is_visible, int max_progression, SpellType spell_type) {
        super(id,name, description, is_visible);
        this.max_progression = max_progression;
        this.spell_type = spell_type;
    }
    public Spells(String name, String description, boolean is_visible, int max_progression, SpellType spell_type) {
        super(name, description, is_visible);
        this.max_progression = max_progression;
        this.spell_type = spell_type;
    }

    public int getMax_progression() {
        return max_progression;
    }

    public SpellType getSpell_type() {
        return spell_type;
    }

    @Override
    public String toString() {
        return "Spells{" +
                "spell_id=" + super.getId() +
                ", max_progression=" + max_progression +
                ", spell_type=" + spell_type +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", is_visible=" + visible +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spells spells = (Spells) o;
        return id == spells.id && max_progression == spells.max_progression && spell_type == spells.spell_type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, max_progression, spell_type);
    }
}
