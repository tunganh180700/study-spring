package com.example.studyspring.services;

import com.example.studyspring.models.GameList;
import com.example.studyspring.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public ResponseEntity<List<GameList>> getAllGames() {
        List<GameList> games = gameRepository.getAllGames();
        if (games.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(games, HttpStatus.OK);
    }

    public GameList addGame(GameList gameList) {
        return gameRepository.save(gameList);
    }

    public void deleteGame(int game_id) {
        gameRepository.deleteById(game_id);
    }

    public GameList updateGame(GameList game, int game_id) {
        GameList gamedb = gameRepository.findById(game_id).get();
        if (Objects.nonNull(game.getGame_name()) && !"".equalsIgnoreCase(game.getGame_name())) {
            gamedb.setGame_name(game.getGame_name());
        }
        return gameRepository.save(gamedb);
    }
}
