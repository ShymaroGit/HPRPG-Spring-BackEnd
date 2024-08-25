package com.medrano.marino.demoHprpg2022.Houses;

import com.medrano.marino.demoHprpg2022.Character.Characters;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "houses")
public class Houses {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private int id;
    private String name;
    @Column(columnDefinition = "integer default 150")
    private int points;
    private String question;
    private String response;
    @Column(columnDefinition = "varchar(8) default '#000000'")
    private String color_dark;
    @Column(columnDefinition = "varchar(8) default '#FFFFFF'")
    private String color_light;

    @OneToMany(mappedBy="house")
    private Set<Characters> members;

    public Houses() {
    }

    public Houses(int id, String name, int points, String question, String response, String color_dark, String color_light) {
        this.id = id;
        this.name = name;
        this.points = points;
        this.question = question;
        this.response = response;
        this.color_dark = color_dark;
        this.color_light = color_light;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getColor_dark() {
        return color_dark;
    }

    public void setColor_dark(String color_dark) {
        this.color_dark = color_dark;
    }

    public String getColor_light() {
        return color_light;
    }

    public void setColor_light(String color_light) {
        this.color_light = color_light;
    }
}
