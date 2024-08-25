package com.medrano.marino.demoHprpg2022.Users;

import com.medrano.marino.demoHprpg2022.Character.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/hprpg/persps")
public class UserConfig {
    private CharacterService characterService;
    @Autowired
    public UserConfig(CharacterService characterService) {
        this.characterService = characterService;
    }
}
