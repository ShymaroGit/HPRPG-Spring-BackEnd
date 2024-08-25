package com.medrano.marino.demoHprpg2022.Character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.medrano.marino.demoHprpg2022.Houses.Houses;
import com.medrano.marino.demoHprpg2022.Inventory.Inventory;
import com.medrano.marino.demoHprpg2022.Spellbook.SpellBooks;
import com.medrano.marino.demoHprpg2022.UserCharacterList.UserCharacterList;
import com.medrano.marino.demoHprpg2022.Wand.Wands;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Characters {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    private String last_name;
    private String first_name;
    //private int house_id;
    private int age;

    private int profil_id;
    @Column(columnDefinition = "varchar(255) default 'Inconnu'")
    private String background = "Inconnu";
    @Column(columnDefinition = "varchar(255) default 'Inconnu'")
    private String patronus = "Inconnu";
    @Column(columnDefinition = "integer default 10")
    private int inventory_size = 10;
    @Column(columnDefinition = "integer default 50")
    private int chance = 50;
    @Column(columnDefinition = "integer default 50")
    private int dex = 50;
    @Column(columnDefinition = "integer default 50")
    private int perc = 50;
    @Column(columnDefinition = "integer default 50")
    private int con = 50;
    @Column(columnDefinition = "integer default 50")
    private int intelligence = 50;
    @Column(columnDefinition = "integer default 50")
    private int magic = 50;
    @Column(columnDefinition = "integer default 160")
    private int height = 160;
    @Column(columnDefinition = "integer default 50")
    private int str = 50;
    @Column(columnDefinition = "integer default 50")
    private int cha = 50;
    @Column(columnDefinition = "boolean default true")
    private boolean npc;
    @Column(columnDefinition = "varchar(255) default 'Élève'")
    private String type = "Élève";

    @ManyToOne
    @JoinColumn(name = "fk_house_id", referencedColumnName = "id",nullable = false)
    private Houses house;

    @ManyToOne
    @JoinColumn(name = "fk_wand_id", referencedColumnName = "id",nullable = false)
    private Wands wand;

    @OneToMany(mappedBy = "character")
    private List<Inventory> inventory;

    @OneToMany(mappedBy = "character")
    private List<SpellBooks> spellbook;

    @OneToMany(mappedBy = "character")
    private List<UserCharacterList> characterList;

    public Characters() {
    }

    public Characters(@JsonProperty("id") int id,
                      @JsonProperty("last_name") String last_name,
                      @JsonProperty("first_name") String first_name,
                      @JsonProperty("fk_house_id") Houses house,
                      @JsonProperty("age") int age,
                      @JsonProperty("wand_id") Wands wand,
                      @JsonProperty("profil_id") int profil_id,
                      @JsonProperty("background") String background,
                      @JsonProperty("patronus") String patronus,
                      @JsonProperty("inventory_size") int inventory_size,
                      @JsonProperty("chance") int chance,
                      @JsonProperty("dex") int dex,
                      @JsonProperty("perc") int perc,
                      @JsonProperty("con") int con,
                      @JsonProperty("intelligence") int intelligence,
                      @JsonProperty("magic") int magic,
                      @JsonProperty("height") int height,
                      @JsonProperty("str") int str,
                      @JsonProperty("cha") int cha,
                      @JsonProperty("npc") boolean npc,
                      @JsonProperty("type") String type) {
        //                  @JsonProperty("knuts") int knuts
        this.id = id;
        this.last_name = last_name;
        this.first_name = first_name;
        this.house = house;
        this.house.setResponse("");
        this.age = age;
        this.wand = wand;
        this.profil_id = profil_id;
        this.background = background;
        this.patronus = patronus;
        this.inventory_size = inventory_size;
        this.chance = chance;
        this.dex = dex;
        this.perc = perc;
        this.con = con;
        this.intelligence = intelligence;
        this.magic = magic;
        this.height = height;
        this.str = str;
        this.cha = cha;
        this.npc = npc;
        this.type = type;
        //this.inventory = new HashSet<Inventory>();
        //this.knuts = knuts;
    }

    public Characters(
            @JsonProperty("last_name") String last_name,
            @JsonProperty("first_name") String first_name,
            @JsonProperty("fk_house_id") Houses house,
            @JsonProperty("age") int age,
            @JsonProperty("wand_id") Wands wand,
            @JsonProperty("profil_id") int profil_id,
            @JsonProperty("background") String background,
            @JsonProperty("patronus") String patronus,
            @JsonProperty("inventory_size") int inventory_size,
            @JsonProperty("chance") int chance,
            @JsonProperty("dex") int dex,
            @JsonProperty("perc") int perc,
            @JsonProperty("con") int con,
            @JsonProperty("intelligence") int intelligence,
            @JsonProperty("magic") int magic,
            @JsonProperty("height") int height,
            @JsonProperty("str") int str,
            @JsonProperty("cha") int cha,
            @JsonProperty("npc") boolean npc,
            @JsonProperty("type") String type) {
        //                  @JsonProperty("knuts") int knuts
        this.last_name = last_name;
        this.first_name = first_name;
        this.house = house;
        this.age = age;
        this.wand = wand;
        this.profil_id = profil_id;
        this.background = background;
        this.patronus = patronus;
        this.inventory_size = inventory_size;
        this.chance = chance;
        this.dex = dex;
        this.perc = perc;
        this.con = con;
        this.intelligence = intelligence;
        this.magic = magic;
        this.height = height;
        this.str = str;
        this.cha = cha;
        this.npc = npc;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public Houses getHouse() {
        return house;
    }

    public int getAge() {
        return age;
    }

    public Wands getWand() {
        return wand;
    }

    public int getProfil_id() {
        return profil_id;
    }

    public String getBackground() {
        return background;
    }

    public String getPatronus() {
        return patronus;
    }

    public int getInventory_size() {
        return inventory_size;
    }

    public int getChance() {
        return chance;
    }

    public int getDex() {
        return dex;
    }

    public int getPerc() {
        return perc;
    }

    public int getCon() {
        return con;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getMagic() {
        return magic;
    }

    public int getHeight() {
        return height;
    }

    public int getStr() {
        return str;
    }

    public int getCha() {
        return cha;
    }

    public boolean isNpc() {
        return npc;
    }

    public String getType() {
        return type;
    }

    public void setWand(Wands wand) {
        this.wand = wand;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setProfil_id(int profil_id) {
        this.profil_id = profil_id;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public void setPatronus(String patronus) {
        this.patronus = patronus;
    }

    public void setInventory_size(int inventory_size) {
        this.inventory_size = inventory_size;
    }

    public void setChance(int chance) {
        this.chance = chance;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public void setPerc(int perc) {
        this.perc = perc;
    }

    public void setCon(int con) {
        this.con = con;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public void setCha(int cha) {
        this.cha = cha;
    }

    public void setNpc(boolean npc) {
        this.npc = npc;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setHouse(Houses house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return "Characters{" +
                "character_id=" + id +
                ", last_name='" + last_name + '\'' +
                ", first_name='" + first_name + '\'' +
                ", age=" + age +
                ", profil_id=" + profil_id +
                ", background='" + background + '\'' +
                ", patronus='" + patronus + '\'' +
                ", inventory_size=" + inventory_size +
                ", chance=" + chance +
                ", dex=" + dex +
                ", perc=" + perc +
                ", con=" + con +
                ", intelligence=" + intelligence +
                ", magic=" + magic +
                ", height=" + height +
                ", str=" + str +
                ", cha=" + cha +
                ", is_npc=" + npc +
                ", type='" + type + '\'' +
                ", house=" + house +
                ", wand=" + wand +
                '}';
    }
}
