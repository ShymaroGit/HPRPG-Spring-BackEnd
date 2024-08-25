package com.medrano.marino.demoHprpg2022.Items;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface ItemRepository extends JpaRepository<Items, Integer> {
    //Read
    @Query("SELECT i from Items i WHERE i.id = ?1")
    Items getById(int id);

    @Query(value = "SELECT i from Items i WHERE i.name = ?1")
    List<Items> getByName(String name);

    @Query("SELECT i from Items i WHERE i.item_type = ?1")
    List<Items> getByType(String type);

    @Query(value = "SELECT * FROM items i WHERE MATCH(i.description) AGAINST ('*' ?1 '*' IN BOOLEAN MODE)",nativeQuery = true)
    List<Items> getByWordsInDescription(String words);

    //Update
    @Transactional
    @Modifying
    @Query("UPDATE Items i SET i.name = ?2,i.description = ?3,i.item_type = ?4,i.max_progression = ?5,i.visible = ?6 WHERE i.id = ?1")
    int updateItem(int id,String name, String description, ItemType item_type, int max_progression, boolean is_visible);

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE items ADD FULLTEXT(name,description)", nativeQuery = true)
    void setFullSearch();

}
