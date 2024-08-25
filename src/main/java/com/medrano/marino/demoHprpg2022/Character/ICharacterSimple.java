package com.medrano.marino.demoHprpg2022.Character;

import com.medrano.marino.demoHprpg2022.Houses.IHouseSafe;

public interface ICharacterSimple {
    int getId();
    String getFirst_name();
    String getLast_name();
    int getAge();
    boolean isNpc();
    String getType();
    IHouseSafe getHouse();
}
