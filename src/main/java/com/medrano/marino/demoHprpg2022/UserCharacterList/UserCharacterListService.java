package com.medrano.marino.demoHprpg2022.UserCharacterList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCharacterListService {
    private UserCharacterListRepository userCharacterListRepository;

    @Autowired
    public UserCharacterListService(UserCharacterListRepository userCharacterListRepository) {
        this.userCharacterListRepository = userCharacterListRepository;
    }

    public List<IUserCharacterListSimple> getCharacterListByUserUuid(String uuid){
        return this.userCharacterListRepository.getCharacterListbyUserUUId(uuid);
    }

}
