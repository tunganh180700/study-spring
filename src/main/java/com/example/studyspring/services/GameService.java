package com.example.studyspring.services;

import com.example.studyspring.models.GameList;
import com.example.studyspring.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;
    public ResponseEntity<List<GameList>> getAllGames(){
        List<GameList> games = gameRepository.getAllGames();
        if(games.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(games, HttpStatus.OK);
    }

    public GameList addGame(GameList gameList){
        return gameRepository.save(gameList);
    }
}
