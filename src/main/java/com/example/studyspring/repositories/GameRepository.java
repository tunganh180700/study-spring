package com.example.studyspring.repositories;

import com.example.studyspring.dto.GameDto;
import com.example.studyspring.models.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<GameList, Integer> {
    @Query(value = "SELECT new com.example.studyspring.dto.GameDto(g.game_id, g.game_name, gt.game_type, p.publisher_name) " +
            "FROM GameList g " +
            "JOIN GameType gt ON g.game_type_id = gt.game_type_id " +
            "JOIN Publisher p ON g.publisher_id = p.publisher_id ")
    List<GameDto> getAllGames();

}
