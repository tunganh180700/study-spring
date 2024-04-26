package com.example.studyspring.services;

import com.example.studyspring.models.GameType;
import com.example.studyspring.repositories.GameTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameTypeService {
    @Autowired
    private GameTypeRepository gameTypeRepository;

    public ResponseEntity<List<GameType>> getAllGameType(){
        List<GameType> gameTypes = gameTypeRepository.getAllGameType();
        if (gameTypes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(gameTypes, HttpStatus.OK);
    }
}
