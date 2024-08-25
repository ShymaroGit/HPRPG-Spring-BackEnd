package com.medrano.marino.demoHprpg2022;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Elements {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    protected int id;
    protected String name;
    protected String description;
    protected boolean visible;

    public Elements() {
    }

    public Elements(String name, String description, boolean visible) {
        this.name = name;
        this.description = description;
        this.visible = visible;
    }

    public Elements(int id, String name, String description, boolean visible) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.visible = visible;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
