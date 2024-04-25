package com.example.studyspring.services;

import com.example.studyspring.dto.GameDto;
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

    public ResponseEntity<List<GameDto>> getAllGames() {
        List<GameDto> games = gameRepository.getAllGames();
        System.out.println(games);
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
        if (game.getGame_type_id() != 0) {
            gamedb.setGame_type_id(game.getGame_type_id());
        }
        if (game.getPublisher_id() != 0) {
            gamedb.setPublisher_id(game.getPublisher_id());
        }
        return gameRepository.save(gamedb);
    }
}
