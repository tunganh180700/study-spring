package com.example.studyspring.repositories;

import com.example.studyspring.models.GameList;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<GameList, Integer> {
    @Query("SELECT g FROM GameList g")
    List<GameList> getAllGames();
}
