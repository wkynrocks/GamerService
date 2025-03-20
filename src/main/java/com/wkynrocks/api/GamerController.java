package com.wkynrocks.api;

import com.wkynrocks.dto.LinkToGame;
import com.wkynrocks.model.Gamer;
import com.wkynrocks.model.Level;
import com.wkynrocks.service.GamerService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController()
@RequestMapping("/gamers")
public class GamerController {
     @Autowired
     private GamerService gamerService;

     @GetMapping()
     public HttpEntity<List<Gamer>> findGamers(@RequestParam(required = false) @Valid Level level,
                                              @RequestParam(required = false) String geography,
                                              @RequestParam(required = false) @Min(1) Long gameId) {
         List<Gamer> foundGames = gamerService.findGamers(level, geography, gameId);
         return ResponseEntity.of(Optional.ofNullable(foundGames));

     }

     @PostMapping("/{id}/games")
     public ResponseEntity<Map<String,String>> linkToGame(@PathVariable Long id, @RequestBody @Valid LinkToGame link) {
         boolean success = gamerService.linkToGame(id, link.getGameId(), link.getLevel());
         if (success) {
             return ResponseEntity.ok(Map.of("message", "Successfully linked to game"));
         }
         return ResponseEntity.status(HttpStatus.CONFLICT)
                 .body(Map.of("message", "Failed to link to game"));
     }
}
