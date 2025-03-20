package com.wkynrocks.repository;

import com.wkynrocks.model.GamerLevelOnGame;
import com.wkynrocks.model.Level;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameLevelOnRepository extends JpaRepository<GamerLevelOnGame, Long> {
    List<GamerLevelOnGame> findByLevel(Level level);
}
