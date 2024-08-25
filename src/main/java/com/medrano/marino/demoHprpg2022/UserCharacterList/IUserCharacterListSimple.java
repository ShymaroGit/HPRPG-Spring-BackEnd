package com.medrano.marino.demoHprpg2022.UserCharacterList;

import com.medrano.marino.demoHprpg2022.Character.ICharacterElementsSimple;
import com.medrano.marino.demoHprpg2022.Character.ICharacterSimple;
import com.medrano.marino.demoHprpg2022.Users.IUserSafe;

public interface IUserCharacterListSimple {
    ICharacterSimple getCharacter();
    IUserSafe getUser();
    boolean isMain();
}
