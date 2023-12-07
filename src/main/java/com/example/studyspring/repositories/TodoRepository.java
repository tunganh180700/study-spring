package com.example.studyspring.repositories;

import com.example.studyspring.models.ToDoItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoRepository extends JpaRepository<ToDoItem, Integer> {
    private EntityManager entityManager;
   
    public List<ToDoItem> getAllTodo() {
        List<ToDoItem> listTodo = new ArrayList<>();
        String sql = "SELECT * FROM todo_list";
        Query query = entityManager.createQuery(sql);
        listTodo.forEach(query::setParameter);
        return query.getResultList();
    }
}
