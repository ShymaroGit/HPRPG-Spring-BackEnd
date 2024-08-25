package com.medrano.marino.demoHprpg2022.Wand;

import com.medrano.marino.demoHprpg2022.Elements;

import javax.persistence.*;

@Entity
@Table
public class Woods extends Elements {
    public Woods() {
    }

    public Woods(String name, String description) {
        super(name, description, true);
    }

    public Woods(int id, String name, String description) {
        super(id, name, description, true);
    }

}
