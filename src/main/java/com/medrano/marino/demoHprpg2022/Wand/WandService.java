package com.medrano.marino.demoHprpg2022.Wand;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class WandService {
    private WandRepository wandRepository;
    private WoodRepository woodRepository;
    private CoreRepository coreRepository;

    @Autowired
    public WandService(WandRepository wandRepository, WoodRepository woodRepository, CoreRepository coreRepository) {
        this.wandRepository = wandRepository;
        this.woodRepository = woodRepository;
        this.coreRepository = coreRepository;
    }

    public List<Cores> getCores(){
        return coreRepository.findAll();
    }

    public List<Woods> getWoods(){
        return woodRepository.findAll();
    }

    public List<Wands> getWands(){
        return wandRepository.findAll();
    }

    public Optional<Wands> getWandsByCore(String coreName){
        return this.getWands()
                .stream()
                .filter(w -> w.getCore()
                        .getName()
                        .equalsIgnoreCase(coreName))
                .findAny();
    }
    public Optional<Wands> getWandsByCoreId(int coreId){
        return this.getWands()
                .stream()
                .filter(w -> w.getCore().getId() == coreId)
                .findAny();
    }

    public Optional<Wands> getWandsByWoodName(String woodName){
        return this.getWands()
                .stream()
                .filter(w -> w.getWood()
                        .getName()
                        .equalsIgnoreCase(woodName))
                .findAny();
    }

    public Optional<Wands> getWandsByWoodId(int woodId){
        return this.getWands()
                .stream()
                .filter(w -> w.getWood().getId() == woodId)
                .findAny();
    }

}
