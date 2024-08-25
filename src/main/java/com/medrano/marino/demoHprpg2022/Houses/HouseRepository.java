package com.medrano.marino.demoHprpg2022.Houses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HouseRepository extends JpaRepository<Houses, Integer> {
    @Query(value = "SELECT id,name,points,question,\" \" as response,color_dark,color_light FROM houses WHERE name = ?1;", nativeQuery=true)
    Houses getHouseByName(String houseName);

    @Query(value = "SELECT id,name,points,question,\" \" as response,color_dark,color_light FROM houses WHERE id = ?1;", nativeQuery=true)
    Houses getHouseById(int houseName);

    @Query(value = "SELECT id,name,points,question,\" \" as response,color_dark,color_light FROM houses;", nativeQuery=true)
    List<Houses> getHouses();

}
