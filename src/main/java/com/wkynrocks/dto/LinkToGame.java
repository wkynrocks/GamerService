package com.wkynrocks.dto;

import com.wkynrocks.model.Level;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.io.Serializable;


public class LinkToGame implements Serializable {
    @NotNull
    private Level level;
    @NotNull
    @Positive
    private Long gameId;

    public LinkToGame(Level level, Long gameId) {
        this.level = level;
        this.gameId = gameId;
    }

    public Level getLevel() {
        return level;
    }

    public Long getGameId() {
        return gameId;
    }

    public LinkToGame() {
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }
}
