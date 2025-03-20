package com.wkynrocks.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;

@Entity
@Table(name = "gamer_level_on_game")
public class GamerLevelOnGame {

    @EmbeddedId
    private  GamerLevelOnGameKey id;

    @ManyToOne
    @MapsId("gamerId")
    @JoinColumn(name = "gamer_id")
    private Gamer gamer;

    @ManyToOne
    @MapsId("gameId")
    @JoinColumn(name = "game_id")
    private Game game;

    @Enumerated(EnumType.STRING)
    @Column(name = "gaming_level")
    private Level level;

    public GamerLevelOnGame(Gamer gamer, Game game, Level level) {
        this.id = GamerLevelOnGameKey.of(gamer, game);
        this.gamer = gamer;
        this.game = game;
        this.level = level;
    }

    public GamerLevelOnGameKey getId() {
        return id;
    }

    public void setId(GamerLevelOnGameKey id) {
        this.id = id;
    }

    public Gamer getGamer() {
        return gamer;
    }

    public void setGamer(Gamer gamer) {
        this.gamer = gamer;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public GamerLevelOnGame() {
    }
}
