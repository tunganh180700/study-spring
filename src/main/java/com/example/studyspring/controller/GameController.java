package com.example.studyspring.controller;

import com.example.studyspring.models.GameList;
import com.example.studyspring.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game")
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping("/")
    public ResponseEntity<List<GameList>> getAllGames() {
        return ResponseEntity.ok(gameService.getAllGames().getBody());
    }

    @PostMapping("/add")
    public GameList addGame(@RequestBody GameList gameList) {
        return gameService.addGame(gameList);
    }

    @DeleteMapping("/delete/{game_id}")
    public String deleteGame(@PathVariable("game_id") int game_id) {
        gameService.deleteGame(game_id);
        return "Delete Successfully";
    }

    @PutMapping("update/{game_id}")
    public GameList updateGame(@RequestBody GameList game, @PathVariable("game_id") int game_id) {
        return gameService.updateGame(game, game_id);
    }
}
