package com.medrano.marino.demoHprpg2022.Houses;

import com.medrano.marino.demoHprpg2022.Character.CharacterRepository;
import com.medrano.marino.demoHprpg2022.Character.Characters;
import com.medrano.marino.demoHprpg2022.Inventory.Inventory;
import com.medrano.marino.demoHprpg2022.Inventory.InventoryRepository;
import com.medrano.marino.demoHprpg2022.Items.ItemType;
import com.medrano.marino.demoHprpg2022.Items.Items;
import com.medrano.marino.demoHprpg2022.Items.ItemRepository;
import com.medrano.marino.demoHprpg2022.Spellbook.SpellBookRepository;
import com.medrano.marino.demoHprpg2022.Spellbook.SpellBooks;
import com.medrano.marino.demoHprpg2022.Spells.Spells;
import com.medrano.marino.demoHprpg2022.Spells.SpellRepository;
import com.medrano.marino.demoHprpg2022.Spells.SpellType;
import com.medrano.marino.demoHprpg2022.UserCharacterList.UserCharacterList;
import com.medrano.marino.demoHprpg2022.UserCharacterList.UserCharacterListRepository;
import com.medrano.marino.demoHprpg2022.Users.UserRepository;
import com.medrano.marino.demoHprpg2022.Users.Users;
import com.medrano.marino.demoHprpg2022.Wand.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.List;

@Configuration
@ComponentScan("com.medrano.marino.demoHprpg2022")
public class HouseConfig {
    //Create Poudlard's 4 houses
    private Houses Gryffindor   = new Houses(1,"Gryffindor",150,"Password?","Fluffy Padfoot","#6C1A31","#D67E03");
    private Houses RavenClaw   = new Houses(2,"RavenClaw", 150,"1+10=?","11",            "#063F53","#7D9EC6");
    private Houses Hufflepuff  = new Houses(3,"Hufflepuff",150,"Whats in the Box?!","A Kitten",      "#5E3225","#BA7625");
    private Houses Slytherin   = new Houses(4,"Slytherin", 150,"Password?","Purity",        "#134731","#8B8A8F");

    //Create some test woods
    private Woods wood1 = new Woods("Bois vert", "Bonne une couleur verte à la baguette");
    private Woods wood2 = new Woods("Bois rouge", "Bonne une couleur rouge à la baguette");
    //Create 2 of the multple existing cores
    private Cores core1 = new Cores("Cheveu de Vélane","donne un mauvais caractère à la Baguette.");
    private Cores core2 = new Cores(  "Crin de Kelpy","peu puissant.");
    // Create some test wands
    private Wands wand1 = new Wands(1,15, core1,wood1);
    private Wands wand2 = new Wands(2,19, core2,wood2);
    //Create some characters
    Characters charac = new Characters();
    Characters characs = new Characters();
    Characters charac2 = new Characters("Mariano","Medrano",RavenClaw,29,wand2,1,"","",1,1,1,1,1,1,1,1,1,1,true,"");
    Characters charac3 = new Characters("Martino","Medrano",Hufflepuff,29,wand1,1,"","",1,1,1,1,1,1,1,1,1,1,false,"");
    Characters charac4 = new Characters("Marlino","Medrano",Slytherin,29,wand2,1,"","",1,1,1,1,1,1,1,1,1,1,false,"");

    //Create some Items
    private Items items1 = new Items("Pomme Verte","Petite pomme verte trouvée sur une table",ItemType.Other);
    private Items items2 = new Items("Pomme Rouge","Petite pomme rouge trouvée sur une table", ItemType.Consumable);
    //Added Items to inventories
    private Inventory inv1 = new Inventory(charac, items1,0);
    private Inventory inv2 = new Inventory(charac, items2,0);
    private Inventory inv3 = new Inventory(charac2, items1,10);
    private Inventory inv4 = new Inventory(charac2, items2,0);
    private Inventory inv5 = new Inventory(characs, items2,0,1,true);
    //Adding some Spells
    private Spells spells1 = new Spells("Aquamenti","Create some water",true,100, SpellType.Charms);
    private Spells spells2 = new Spells("Aquamenti2","Create some water",true,100, SpellType.Charms);

    private SpellBooks sb1 = new SpellBooks(charac,spells1,10,true);
    private SpellBooks sb2 = new SpellBooks(charac,spells2,11,true);

    private Users user1 = new Users("marino",Users.hashPassword("S091011"));

    private UserCharacterList ucl1 = new UserCharacterList(user1,charac,false);

    @Bean("housesConfig")
    CommandLineRunner commandLineRunnerHouses(HouseRepository repository){
        return args -> {
            repository.saveAll(
                    List.of(Gryffindor,RavenClaw,Hufflepuff,Slytherin)
            );
        };
    }

    @Bean("woodConfig")
    CommandLineRunner commandLineRunnerWoods(WoodRepository woodRepository){
        return  args -> {
            woodRepository.setFullSearch();
            woodRepository.saveAll(
                    List.of(wood1,wood2)
            );
        };
    }
    @Bean("coreConfig")
    CommandLineRunner commandLineRunnerCores(CoreRepository coreRepository){
        return  args -> {
            coreRepository.setFullSearch();
            coreRepository.saveAll(
                    List.of(core1,core2)
            );
        };
    }
    @Bean("wandConfig")
    @DependsOn({"coreConfig","woodConfig"})
    CommandLineRunner commandLineRunnerWands(WandRepository wandRepository){
        return  args -> {
            wandRepository.saveAll(
                    List.of(wand1,wand2)
            );
        };
    }

    @Bean("spellsConfig")
    CommandLineRunner commandLineRunerSpells(SpellRepository spellRepository){
        return args -> {
            spellRepository.saveAll(
                    List.of(spells1)
            );
        };
    }


    @Bean("itemsConfig")
    @DependsOn({"housesConfig","wandConfig"})
    CommandLineRunner commandLineRunnerItems(ItemRepository repository){
        return  args -> {
            repository.setFullSearch();
            repository.saveAll(
                    List.of(items1,items2)
            );
        };
    }

    @Bean("characterConfig")
    @DependsOn({"housesConfig","wandConfig","itemsConfig"})
    CommandLineRunner commandLineRunnerCharacters(CharacterRepository repository){
        charac.setFirst_name("Mariano");
        charac.setLast_name("Medrano");
        charac.setAge(18);
        charac.setHouse(Gryffindor);
        charac.setWand(wand1);

        characs.setFirst_name("Jo");
        characs.setLast_name("Medrano");
        characs.setAge(19);
        characs.setHouse(RavenClaw);
        characs.setWand(wand2);

        return  args -> {
            repository.saveAll(
                    List.of(charac,charac2,charac3,charac4,characs)
            );
        };
    }

    @Bean("InventoryConfig")
    @DependsOn({"characterConfig", "itemsConfig"})
    CommandLineRunner commandLineRunnerInventory(InventoryRepository repository){
        return  args -> {
            repository.saveAll(
                    List.of(inv1,inv2,inv3,inv4,inv5)
            );
        };
    }
    @Bean("SpellBoolConfig")
    @DependsOn({"characterConfig", "spellsConfig"})
    CommandLineRunner commandLineRunnerSpellbook(SpellBookRepository repository){
        return  args -> {
            repository.saveAll(
                    List.of(sb1)
            );
        };
    }
    @Bean("usersConfig")
    CommandLineRunner commandLineRunnerUser(UserRepository repository){
        return args -> {
            repository.saveAll(
                    List.of(user1)
            );
        };
    }

    @Bean("userCharacterList")
    @DependsOn({"usersConfig","characterConfig"})
    CommandLineRunner commandLineRunnerUserCharacterList(UserCharacterListRepository repository){
        return args -> {
            repository.saveAll(
                    List.of(ucl1)
            );
        };
    }
}
