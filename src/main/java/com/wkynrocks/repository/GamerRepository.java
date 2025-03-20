package com.wkynrocks.repository;

import com.wkynrocks.model.Gamer;
import com.wkynrocks.model.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GamerRepository extends JpaRepository<Gamer, Long> {

    @Query("SELECT DISTINCT g FROM Gamer g " +
            "JOIN GamerLevelOnGame glg ON g = glg.gamer " +
            "WHERE (g.geography = :geography OR :geography IS NULL)" +
            "AND (glg.level = :level OR :level IS NULL) " +
            "AND (glg.game.id = :gameId OR :gameId IS NULL)")
    List<Gamer> findByGeographyLevelAndGame(String geography, Level level, Long gameId);

}
