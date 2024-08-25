package com.medrano.marino.demoHprpg2022.Wand;

import javax.persistence.*;

@Entity
@Table
public class Wands {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    private int wand_length;
    @ManyToOne
    @JoinColumn(name = "fk_core_id", referencedColumnName = "id",nullable = false)
    private Cores core;
    @ManyToOne
    @JoinColumn(name = "fk_wood_id", referencedColumnName = "id",nullable = false)
    private Woods wood;

    public Wands() {
    }

    public Wands(int id, int wand_length, Cores core, Woods wood) {
        this.id = id;
        this.wand_length = wand_length;
        this.core = core;
        this.wood = wood;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWand_length() {
        return wand_length;
    }

    public void setWand_length(int wand_length) {
        this.wand_length = wand_length;
    }

    public Cores getCore() {
        return core;
    }

    public void setCore(Cores core) {
        this.core = core;
    }

    public Woods getWood() {
        return wood;
    }

    public void setWood(Woods wood) {
        this.wood = wood;
    }
}
