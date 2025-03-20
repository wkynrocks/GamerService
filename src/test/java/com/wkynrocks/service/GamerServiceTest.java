package com.wkynrocks.service;

import com.wkynrocks.errors.ResourceNotFoundException;
import com.wkynrocks.model.Game;
import com.wkynrocks.model.Gamer;
import com.wkynrocks.model.Level;
import com.wkynrocks.repository.GameLevelOnRepository;
import com.wkynrocks.repository.GameRepository;
import com.wkynrocks.repository.GamerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GamerServiceTest {

    @Mock
    private GamerRepository gamerRepository;

    @Mock
    private GameRepository gameRepository;

    @Mock
    private GameLevelOnRepository gameLevelOnRepository;

    private GamerService gamerService;

    private Gamer gamer1;
    private Gamer gamer2;
    private Game game1;
    private Game game2;

    @BeforeEach
    void setUp() {
        gamerService = new GamerService(gamerRepository, gameRepository, gameLevelOnRepository);
        gamer1 = new Gamer(1L, "Player1","USA");
        gamer2 = new Gamer(1L, "Player1","Denmark");
        game1 = new Game(1L, "Game1");
        game2 = new Game(2L, "Game2");
    }

    @Test
    void findGamers_WithAllParams_ReturnsFilteredGamers() {
        Level level = Level.PRO;
        String geography = "USA";
        Long gameId = 1L;

        when(gamerRepository.findByGeographyLevelAndGame(geography, level, gameId))
                .thenReturn(Arrays.asList(gamer1));

        List<Gamer> result = gamerService.findGamers(level, geography, gameId);

        Assertions.assertEquals(1, result.size());

        Assertions.assertEquals(1L, result.get(0).getId());
    }

    @Test
    void findGamers_WithNoParams_ReturnsAllGamers() {
        when(gamerRepository.findByGeographyLevelAndGame(null, null, null)).thenReturn(Arrays.asList(gamer1, gamer2));

        List<Gamer> result = gamerService.findGamers(null, null, null);

        Assertions.assertEquals(2, result.size());
    }

    @Test
    void linkToGame_WhenGamerExists_ReturnsTrue() {
        when(gamerRepository.findById(1L)).thenReturn(Optional.of(gamer1));
        when(gameRepository.findById(1L)).thenReturn(Optional.of(game1));
        when(gamerRepository.save(any(Gamer.class))).thenReturn(gamer1);

        boolean result = gamerService.linkToGame(1L, 1L, Level.N00B);

        Assertions.assertTrue(result);
    }

    @Test
    void linkToGame_WhenGamerNotFound_throwException() {
        when(gamerRepository.findById(1L)).thenReturn(Optional.empty());


        Assertions.assertThrows(ResourceNotFoundException.class,
                () -> gamerService.linkToGame(1L, 1L, Level.N00B) );
    }

    @Test
    void linkToGame_WhenGameNotFound_throwException() {
        when(gameRepository.findById(1L)).thenReturn(Optional.empty());

        Assertions.assertThrows(ResourceNotFoundException.class,
                () -> gamerService.linkToGame(1L, 1L, Level.N00B) );
    }
}
