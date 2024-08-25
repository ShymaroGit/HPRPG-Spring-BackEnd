package com.medrano.marino.demoHprpg2022.Character;

import com.medrano.marino.demoHprpg2022.Character.ICharacterSimple;
import com.medrano.marino.demoHprpg2022.Items.Items;

import javax.persistence.MappedSuperclass;
import java.util.Date;
@MappedSuperclass
public interface ICharacterElementsSimple {
    int getId();
    ICharacterSimple getCharacter();
    int getProgression();
    int getQuantity();
    boolean getVisible();
    Date getAdded_at();
}
