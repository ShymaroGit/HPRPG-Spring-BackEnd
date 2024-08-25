package com.medrano.marino.demoHprpg2022.Inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    @Query("select" +
            " ci.id as id," +
            " ci.added_at as added_at," +
            " ci.character as character," +
            " ci.visible as visible," +
            " ci.item as item," +
            " ci.progression as progression," +
            " ci.quantity as quantity " +
            " from Inventory ci")
    public List<IInventorySimple> getInventories();
    @Query(value =
            "select" +
                    " ci.id as id," +
                    " ci.added_at as added_at," +
                    " ci.character as character," +
                    " ci.visible as visible," +
                    " ci.item as item," +
                    " ci.progression as progression," +
                    " ci.quantity as quantity" +
                    " from Inventory ci" +
                    " WHERE ci.character.id = ?1")
    public List<IInventorySimple> getInventoryByCharacterId(int id);

    @Query("SELECT ci.character.id as character_id,ci.character.first_name as character_first_name,ci.character.last_name as character_last_name, COUNT(ci) as items_count FROM Inventory ci WHERE fk_character_id = ?1 GROUP BY ci.character.id")
    public  ICharacterInventoryCount getItemsCountByCharacterId(int id);

}
