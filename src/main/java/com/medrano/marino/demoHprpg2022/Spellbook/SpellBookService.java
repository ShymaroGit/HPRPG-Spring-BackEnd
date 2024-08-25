package com.medrano.marino.demoHprpg2022.Spellbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpellBookService {
    private SpellBookRepository spellsRepository;
    @Autowired
    public SpellBookService(SpellBookRepository spellsRepository) {
        this.spellsRepository = spellsRepository;
    }

    public List<ISpellbookSimple> getAll(){
        return spellsRepository.getAllSpellBooks();
    }

    public ICharacterSpellbookCount getSpellbookCount(int id){
        return spellsRepository.getSpellsCountByCharacterId(id);
    }
}
