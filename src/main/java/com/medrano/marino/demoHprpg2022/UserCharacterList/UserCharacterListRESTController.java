package com.medrano.marino.demoHprpg2022.UserCharacterList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Controller
@RestController
@RequestMapping("api/hprpg/MyCharacterList/")
public class UserCharacterListRESTController {
    private UserCharacterListService userCharacterListService;

    @Autowired
    public UserCharacterListRESTController(UserCharacterListService userCharacterListService) {
        this.userCharacterListService = userCharacterListService;
    }

    @GetMapping("{uuid}")
    public List<IUserCharacterListSimple> getAll(@PathVariable("uuid") String uuid){
        return this.userCharacterListService.getCharacterListByUserUuid(uuid);
    }
}
