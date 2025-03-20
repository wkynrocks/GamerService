package com.wkynrocks.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "gamers")
public class Gamer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String geography;

    @OneToMany(mappedBy = "gamer")
    Set<GamerLevelOnGame> levelOn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGeography() {
        return geography;
    }

    public void setGeography(String geography) {
        this.geography = geography;
    }

    public Gamer() {
    }

    public Gamer(Long id, String name, String geography ) {
        this.geography = geography;
        this.name = name;
        this.id = id;
    }
}
