package com.example.studyspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<ToDoItem, Integer> {
    @Query("SELECT t FROM ToDoItem t")
    List<ToDoItem> getAllTodo();
    @Query(value = "SELECT * FROM TODOLIST t WHERE t.id = :id",nativeQuery = true)
    ToDoItem searchByID(Integer id);
}
