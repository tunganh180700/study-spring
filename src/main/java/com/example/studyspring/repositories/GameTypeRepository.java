package com.example.studyspring.repositories;

import com.example.studyspring.models.GameType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameTypeRepository extends JpaRepository<GameType, Integer> {
    @Query(value = "SELECT gt FROM GameType gt")
    List<GameType> getAllGameType();
}
