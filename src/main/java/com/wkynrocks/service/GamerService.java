package com.wkynrocks.service;

import com.wkynrocks.errors.ResourceNotFoundException;
import com.wkynrocks.model.*;
import com.wkynrocks.repository.GameLevelOnRepository;
import com.wkynrocks.repository.GameRepository;
import com.wkynrocks.repository.GamerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamerService {
    private final GamerRepository gamerRepository;
    private final GameRepository gameRepository;
     private final GameLevelOnRepository gameLevelOnRepository;

    public GamerService(GamerRepository gamerRepository, GameRepository gameRepository, GameLevelOnRepository gameLevelOnRepository) {
        this.gamerRepository = gamerRepository;
        this.gameRepository = gameRepository;
        this.gameLevelOnRepository = gameLevelOnRepository;
    }

    public List<Gamer> findGamers(Level level, String geography, Long gameId) {
       return gamerRepository.findByGeographyLevelAndGame(geography, level, gameId);
    }

    @Transactional
    public boolean linkToGame(long gamerId, long gameId, Level level) {
        Optional<Game> game = gameRepository.findById(gameId);
        Optional<Gamer> gamer = gamerRepository.findById(gamerId);

        if(game.isEmpty()) {
            throw new ResourceNotFoundException("Game not found");
        }
        if(gamer.isEmpty()) {
            throw new ResourceNotFoundException("Gamer not found");
        }
        gameLevelOnRepository.save(new GamerLevelOnGame(gamer.get(), game.get(), level));
        return true;
    }
}
