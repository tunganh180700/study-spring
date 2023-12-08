package com.example.studyspring.controller;

import com.example.studyspring.models.ToDoItem;
import com.example.studyspring.repositories.TodoRepository;
import com.example.studyspring.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/todos")
public class ToDoItemsController {
    private TodoService todoService;
    @Autowired
    TodoRepository todoRepository;
    @GetMapping("/")
    public ResponseEntity<List<ToDoItem>> getAllTodos(){
        return ResponseEntity.ok(todoService.getAllTodo().getBody());
    }
}
