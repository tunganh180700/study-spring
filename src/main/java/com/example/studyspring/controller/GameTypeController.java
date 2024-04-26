package com.example.studyspring.controller;

import com.example.studyspring.models.GameType;
import com.example.studyspring.services.GameTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/game-type")
@CrossOrigin(origins = "*")
public class GameTypeController {
    @Autowired
    private GameTypeService gameTypeService;

    @GetMapping("/")
    public ResponseEntity<List<GameType>> getAllGameType(){
        return ResponseEntity.ok(gameTypeService.getAllGameType().getBody());
    }
}
