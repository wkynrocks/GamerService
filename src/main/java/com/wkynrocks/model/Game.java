package com.wkynrocks.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "game")
    Set<GamerLevelOnGame> levelOn;


    public Game(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Game() {
    }

    public Game(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
