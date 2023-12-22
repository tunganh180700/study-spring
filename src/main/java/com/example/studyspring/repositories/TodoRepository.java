package com.example.studyspring.repositories;

import com.example.studyspring.models.ToDoItem;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<ToDoItem, Integer> {
    @Query("SELECT t FROM ToDoItem t")
    List<ToDoItem> getAllTodo();
}
