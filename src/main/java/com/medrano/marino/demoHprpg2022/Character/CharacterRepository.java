package com.medrano.marino.demoHprpg2022.Character;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CharacterRepository extends JpaRepository<Characters,Integer> {

    @Query("SELECT ca FROM Characters ca WHERE ca.id = ?1")
    public List<Characters> getCharacterById(int id);

    @Query("SELECT ca.id as id, ca.first_name as first_name, ca.last_name as last_name, ca.age as age, ca.npc as npc, ca.type as type, ca.house as house FROM Characters ca")
    public List<ICharacterSimple> getAllCharactersSimple();
}
