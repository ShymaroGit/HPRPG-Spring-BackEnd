package com.medrano.marino.demoHprpg2022.Character;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/hprpg/characters/")
public class CharacterRESTController {
    private CharacterService characterService;
    @Autowired
    public CharacterRESTController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    public List<Characters> getCharacters(){
        return characterService.getTest();
    }

    @GetMapping(path = "t/")
    public ResponseEntity<List<ICharacterSimple>> getTest(){
        return new ResponseEntity<>(characterService.getCharacters(), HttpStatus.OK);
    }


}
