package com.medrano.marino.demoHprpg2022.Wand;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface WoodRepository extends JpaRepository<Woods, Integer> {
    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE woods ADD FULLTEXT(name,description)", nativeQuery = true)
    void setFullSearch();
}
