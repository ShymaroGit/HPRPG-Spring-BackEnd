package com.medrano.marino.demoHprpg2022.Spellbook;

import com.medrano.marino.demoHprpg2022.Character.ICharacterElementsSimple;
import com.medrano.marino.demoHprpg2022.Spells.Spells;

public interface ISpellbookSimple extends ICharacterElementsSimple {
    Spells getSpell();
}
