package com.medrano.marino.demoHprpg2022.UserCharacterList;

import com.medrano.marino.demoHprpg2022.Character.Characters;
import com.medrano.marino.demoHprpg2022.Users.Users;

import javax.persistence.*;

@Entity
@Table(name = "user_character")
public class UserCharacterList {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="fk_user_id",referencedColumnName = "id")
    private Users user;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="fk_character_id",referencedColumnName = "id")
    private Characters character;

    private boolean main;

    public UserCharacterList() {
    }

    public UserCharacterList(int id, Users user, Characters character, boolean main) {
        this.id = id;
        this.user = user;
        this.character = character;
        this.main = main;
    }

    public UserCharacterList(Users user, Characters character, boolean main) {
        this.user = user;
        this.character = character;
        this.main = main;
    }

    public int getId() {
        return id;
    }

    public Users getUser() {
        return user;
    }

    public Characters getCharacter() {
        return character;
    }

    public boolean isMain() {
        return main;
    }
}
