package com.example.studyspring.controller;

import com.example.studyspring.models.ToDoItem;
import com.example.studyspring.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/todos")
public class ToDoItemsController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/")
    public ResponseEntity<List<ToDoItem>> getAllTodos(){
        return ResponseEntity.ok(todoService.getAllTodo().getBody());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(){
        return ResponseEntity.ok(todoService.add());
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody ToDoItem toDoItem){
//        todoService.update(toDoItem.getId());
        return ResponseEntity.ok(todoService.update(toDoItem.getStatusId()));
    }
}
