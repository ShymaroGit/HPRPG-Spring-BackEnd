package com.medrano.marino.demoHprpg2022.Inventory;

import com.medrano.marino.demoHprpg2022.Character.ICharacterElementsSimple;
import com.medrano.marino.demoHprpg2022.Items.Items;

public interface IInventorySimple extends ICharacterElementsSimple {
    Items getItem();
}
