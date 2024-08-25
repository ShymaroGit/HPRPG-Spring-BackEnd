package com.medrano.marino.demoHprpg2022.UserCharacterList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCharacterListRepository extends JpaRepository<UserCharacterList, Integer> {
    @Query("SELECT cl.user as user, cl.character as character, cl.main as main FROM UserCharacterList cl WHERE cl.user.uuid = ?1")
    List<IUserCharacterListSimple> getCharacterListbyUserUUId(String uuid);
}
