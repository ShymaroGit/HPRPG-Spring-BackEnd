package com.medrano.marino.demoHprpg2022.Wand;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface CoreRepository extends JpaRepository<Cores, Integer> {
    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE cores ADD FULLTEXT(name,description)", nativeQuery = true)
    void setFullSearch();
}
