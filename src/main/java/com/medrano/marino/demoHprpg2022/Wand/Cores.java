package com.medrano.marino.demoHprpg2022.Wand;

import com.medrano.marino.demoHprpg2022.Elements;

import javax.persistence.*;

@Entity
@Table
public class Cores extends Elements {
    public Cores() {
    }

    public Cores(String name, String description) {
        super(name, description, true);
    }

    public Cores(int id, String name, String description) {
        super(id, name, description, true);
    }

}
