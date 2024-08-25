package com.medrano.marino.demoHprpg2022.Character;

import com.medrano.marino.demoHprpg2022.Character.Characters;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
@MappedSuperclass
public class CharacterElements {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    protected int id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "fk_character_id", referencedColumnName = "id")
    protected Characters character;

    @Column(columnDefinition = "integer default 0")
    protected int progression = 0;
    @Column(columnDefinition = "integer default 1")
    protected int quantity = 1;
    @Column(columnDefinition = "boolean default true")
    protected boolean visible = true;

    @Basic(optional = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "added_at", nullable = false)
    @CreatedDate
    protected Date added_at;

    public CharacterElements() {
    }

    public CharacterElements(int id, Characters character, int progression, int quantity, boolean visible, Date added_at) {
        this.id = id;
        this.character = character;
        this.progression = progression;
        this.quantity = quantity;
        this.visible = visible;
        this.added_at = added_at;
    }

    public CharacterElements(Characters character, int progression, int quantity, boolean visible, Date added_at) {
        this.character = character;
        this.progression = progression;
        this.quantity = quantity;
        this.visible = visible;
        this.added_at = added_at;
    }

    public int getId() {
        return id;
    }

    public Characters getCharacter() {
        return character;
    }

    public int getProgression() {
        return progression;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isVisible() {
        return visible;
    }

    public Date getAdded_at() {
        return added_at;
    }
}
