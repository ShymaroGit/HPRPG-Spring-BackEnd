package com.medrano.marino.demoHprpg2022.Users;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.medrano.marino.demoHprpg2022.UserCharacterList.UserCharacterList;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table
public class Users {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Integer id;
    private String username;
    @Column(columnDefinition = "integer default 0")
    private int privilege = 0;
    @Column(columnDefinition = "integer default false")
    private boolean use_custom_color = false;
    @Column(columnDefinition = "varchar(8) default '#000000'")
    private String custom_dark_color = "#000000";
    @Column(columnDefinition = "varchar(8) default '#FFFFFF'")
    private String custom_light_color = "#FFFFFF";
    private String uuid = UUID.randomUUID().toString();
    private String password;

    @OneToMany(mappedBy = "user")
    private List<UserCharacterList> characterList;

    public Users() {
    }

    public Users(@JsonProperty("id") Integer id, @JsonProperty("username") String username, @JsonProperty("privilege") int privilege,
                 @JsonProperty("use_custom_color") boolean use_custom_color, @JsonProperty("custom_dark_color") String custom_dark_color,
                 @JsonProperty("custom_light_color") String custom_light_color, @JsonProperty("uuid") String uuid) {
        this.id = id;
        this.username = username;
        this.privilege = privilege;
        this.use_custom_color = use_custom_color;
        this.custom_dark_color = custom_dark_color;
        this.custom_light_color = custom_light_color;
        this.uuid = uuid;
    }

    public Users(Integer id,
                 String username,
                 int privilege,
                 boolean use_custom_color,
                 String custom_dark_color,
                 String custom_light_color,
                 String uuid,
                 String password) {
        this.id = id;
        this.username = username;
        this.privilege = privilege;
        this.use_custom_color = use_custom_color;
        this.custom_dark_color = custom_dark_color;
        this.custom_light_color = custom_light_color;
        this.uuid = uuid;
        this.password = password;
    }
    public Users(
                 String username,
                 int privilege,
                 boolean use_custom_color,
                 String custom_dark_color,
                 String custom_light_color,
                 String uuid,
                 String password) {
        this.username = username;
        this.privilege = privilege;
        this.use_custom_color = use_custom_color;
        this.custom_dark_color = custom_dark_color;
        this.custom_light_color = custom_light_color;
        this.uuid = uuid;
        this.password = password;
    }

    public Users(String username, int privilege, boolean use_custom_color, String custom_dark_color, String custom_light_color) {
        this.username = username;
        this.privilege = privilege;
        this.use_custom_color = use_custom_color;
        this.custom_dark_color = custom_dark_color;
        this.custom_light_color = custom_light_color;
    }

    public Users(String username, int privilege, boolean use_custom_color, String custom_dark_color, String custom_light_color, String password) {
        this.username = username;
        this.privilege = privilege;
        this.use_custom_color = use_custom_color;
        this.custom_dark_color = custom_dark_color;
        this.custom_light_color = custom_light_color;
        this.password = password;
    }
    public Users(String username,  String password) {
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    public boolean getUse_custom_color() {
        return use_custom_color;
    }

    public void setUse_custom_color(boolean use_custom_color) {
        this.use_custom_color = use_custom_color;
    }

    public String getCustom_dark_color() {
        return custom_dark_color;
    }

    public void setCustom_dark_color(String custom_dark_color) {
        this.custom_dark_color = custom_dark_color;
    }

    public String getCustom_light_color() {
        return custom_light_color;
    }

    public void setCustom_light_color(String custom_light_color) {
        this.custom_light_color = custom_light_color;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void emptyPassword() {
        this.password = "";
    }

    @Override
    public String toString() {
        return "Users{" +
                "user_id=" + id +
                ", username='" + username + '\'' +
                ", privilege=" + privilege +
                ", use_custom_color=" + use_custom_color +
                ", custom_dark_color='" + custom_dark_color + '\'' +
                ", custom_light_color='" + custom_light_color + '\'' +
                ", uuid=" + uuid +
                ", password='" + password + '\'' +
                '}';
    }

    public static String hashPassword(String passwordToHash){
        BCryptPasswordEncoder passwordEcorder = new BCryptPasswordEncoder();
        String hashedPassword = "";

        if(!passwordToHash.isEmpty() || !passwordToHash.isBlank()){
            String strippedPasswordToHash = passwordToHash.strip();
            if(strippedPasswordToHash.length() > 6)
                hashedPassword = passwordEcorder.encode(strippedPasswordToHash);
        }

        return hashedPassword;
    }
}
