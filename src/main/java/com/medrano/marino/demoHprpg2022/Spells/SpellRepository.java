package com.medrano.marino.demoHprpg2022.Spells;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface SpellRepository extends JpaRepository<Spells, Integer> {
    //Read
    @Query("SELECT s from Spells s WHERE s.id = ?1")
    Spells getById(int id);

    @Query(value = "SELECT s from Spells s WHERE s.name = ?1")
    List<Spells> getByName(String name);

    @Query("SELECT s from Spells s WHERE s.spell_type = ?1")
    List<Spells> getByType(String type);

    @Query(value = "SELECT * FROM spells s WHERE MATCH(s.description) AGAINST ('*' ?1 '*' IN BOOLEAN MODE)",nativeQuery = true)
    List<Spells> getByWordsInDescription(String words);

    //Update
    @Transactional
    @Modifying
    @Query("UPDATE Spells s SET s.name = ?2,s.description = ?3,s.spell_type = ?4,s.max_progression = ?5,s.visible = ?6 WHERE s.id = ?1")
    int updateSpell(int id, String name, String description, SpellType spell_type, int max_progression, boolean is_visible);

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE spells ADD FULLTEXT(name,description)", nativeQuery = true)
    void setFullSearch();
}
