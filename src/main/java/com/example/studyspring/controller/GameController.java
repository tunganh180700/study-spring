package com.example.studyspring.controller;

import com.example.studyspring.models.GameList;
import com.example.studyspring.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/game")
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping("/")
    public ResponseEntity<List<GameList>> getAllGames(){
        return ResponseEntity.ok(gameService.getAllGames().getBody());
    }

    @PostMapping("/add")
    public GameList addGame(@RequestBody GameList gameList){
        return gameService.addGame(gameList);
    }
}
