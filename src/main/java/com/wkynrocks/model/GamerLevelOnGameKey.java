package com.wkynrocks.model;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class GamerLevelOnGameKey {

    @Column(name = "game_id")
    private  Long gameId;

    @Column(name = "gamer_id")
    private  Long gamerId;

    public GamerLevelOnGameKey(Long gamerId, Long gameId) {
        this.gameId = gameId;
        this.gamerId = gamerId;
    }

    public Long getGameId() {
        return gameId;
    }

    public Long getGamerId() {
        return gamerId;
    }

    public GamerLevelOnGameKey() {
    }

    public static GamerLevelOnGameKey of(Gamer gamer, Game game) {
        return new GamerLevelOnGameKey(gamer.getId(), game.getId());
    }
}
