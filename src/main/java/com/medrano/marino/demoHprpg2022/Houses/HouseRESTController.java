package com.medrano.marino.demoHprpg2022.Houses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/hprpg/houses/")
public class HouseRESTController {
    private HouseService houseService;

    @Autowired
    public HouseRESTController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping
    public List<Houses> getHouses(){
        return houseService.getHouses();
    }

    @GetMapping(path = "name/{name}")
    public Houses getHouseByName(@PathVariable("name") String name){
        return houseService.getHouseByName(name).get();
    }

    @GetMapping(path = "id/{id}")
    public Houses getHouseById(@PathVariable("id") int id){
        return houseService.getHouseById(id).get();
    }
}
