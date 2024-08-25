package com.medrano.marino.demoHprpg2022.Spells;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SpellService {
    private SpellRepository spellRepository;
    @Autowired
    public SpellService(SpellRepository spellRepository) {
        this.spellRepository = spellRepository;
    }

    public List<Spells> getAllSpells(){
        return this.spellRepository.findAll();
    }

    public Spells getById(int id){
        return this.spellRepository.getById(id);
    }

    public List<Spells> getByName(String name){
        return this.spellRepository.getByName(name);
    }

    public List<Spells> getByType(String type){
        return this.spellRepository.getByType(type);
    }

    public List<Spells> getByWordInDescription(String word){
        return this.spellRepository.getByWordsInDescription(word);
    }

    public void createSpell(Spells item){
        this.spellRepository.save(item);
    }

    public void deleteSpell(Spells item){
        this.spellRepository.deleteById(item.getId());
    }
    public List<SpellType> getSpellsTypes(){
        return Arrays.stream(SpellType.values()).toList();
    }

    public void updateSpell(Spells item){
        this.spellRepository.updateSpell(item.getId(),item.getName(), item.getDescription(),item.getSpell_type(),item.getMax_progression(),item.isVisible());
    }
}
