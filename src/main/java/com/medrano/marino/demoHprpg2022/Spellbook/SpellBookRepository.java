package com.medrano.marino.demoHprpg2022.Spellbook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpellBookRepository extends JpaRepository<SpellBooks, Integer> {
    @Query("SELECT sb.id as id,sb.added_at as added_at,sb.character as character,sb.visible as visible,sb.spell as spell,sb.progression as progression,sb.quantity as quantity FROM SpellBooks sb")
    List<ISpellbookSimple> getAllSpellBooks();

    @Query("SELECT sb.id as id,sb.added_at as added_at,sb.character as character,sb.visible as visible,sb.spell as spell,sb.progression as progression,sb.quantity as quantity FROM SpellBooks sb WHERE sb.character.id = ?1")
    List<ISpellbookSimple> getSpellBooksByCharacterId(int id);

    @Query("SELECT sb.character.id as character_id,sb.character.first_name as character_first_name,sb.character.last_name as character_last_name, COUNT(sb) as spells_count FROM SpellBooks sb WHERE fk_character_id = ?1 GROUP BY sb.character.id")
    public ICharacterSpellbookCount getSpellsCountByCharacterId(int id);
}
