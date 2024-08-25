package com.medrano.marino.demoHprpg2022.Character;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CharacterService {
    public final CharacterRepository characterRepository;

    @Autowired
    public CharacterService(CharacterRepository characterRepository){
        this.characterRepository = characterRepository;
    }

    public List<ICharacterSimple> getCharacters(){
        return characterRepository.getAllCharactersSimple();
    }

    public List<Characters> getTest(){
        return characterRepository.getCharacterById(1);
    }


    /*public List<Persos> getPersosByUser(){
        return persosRepository.getPersoByName();
    }*/
}
