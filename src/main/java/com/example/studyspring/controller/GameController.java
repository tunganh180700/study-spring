package com.example.studyspring.controller;

import com.example.studyspring.dto.GameDto;
import com.example.studyspring.models.GameList;
import com.example.studyspring.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/game")
@CrossOrigin(origins = "*")
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping("/")
    public ResponseEntity<List<GameDto>> getAllGames() {
        return ResponseEntity.ok(gameService.getAllGames().getBody());
    }

    @PostMapping("/add")
    public GameList addGame(@RequestBody GameList gameList) {
        return gameService.addGame(gameList);
    }

    @GetMapping("/{game_id}")
    public ResponseEntity<?> getGameById(@PathVariable("game_id") int game_id) {
        Map<String, Object> response = new HashMap<>();
        Optional<GameList> dataGame = gameService.findByGameId(game_id);
        GameList game = dataGame.get();
        if (dataGame.isPresent()) {
            response.put("success", true);
            response.put("data", game);
        } else {
            response.put("success", false);
            response.put("data", null);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{game_id}")
    public String deleteGame(@PathVariable("game_id") int game_id) {
        gameService.deleteGame(game_id);
        return "Delete Successfully";
    }

    @PutMapping("/update/{game_id}")
    public GameList updateGame(@RequestBody GameList game, @PathVariable("game_id") int game_id) {
        return gameService.updateGame(game, game_id);
    }
}
