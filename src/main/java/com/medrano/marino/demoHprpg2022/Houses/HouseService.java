package com.medrano.marino.demoHprpg2022.Houses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HouseService {
    private HouseRepository houseRepository;

    @Autowired
    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    public List<Houses> getHouses(){
        return houseRepository.getHouses();
    }

    public Optional<Houses> getHouseByName(String name){
        if(name.isBlank() || name.isEmpty()){
            //Error
            System.out.println("Error: House name empty");
            return Optional.empty();
        }
        Optional<Houses> house = Optional.of(houseRepository.getHouseByName(name));
        if(house.isEmpty()){
            return Optional.ofNullable(houseRepository.getHouseByName("Gryffindor"));
        }
        return house;
    }
    public Optional<Houses> getHouseById(int id){
        if(id < 1 || id > 4){
            //Error
            System.out.println("Error: House id invalid or empty");
            return Optional.empty();
        }
        Optional<Houses> house = Optional.of(houseRepository.getHouseById(id));
        if(house.isEmpty()){
            return Optional.ofNullable(houseRepository.getHouseByName("Gryffindor"));
        }
        return house;
    }
}

