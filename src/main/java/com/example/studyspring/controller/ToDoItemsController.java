package com.example.studyspring.controller;

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

    @GetMapping("/aaa")
    public ResponseEntity<ToDoItem> searchById(){
        return ResponseEntity.ok(todoService.searchById(1).getBody());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(){
        return ResponseEntity.ok(todoService.add());
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody ToDoItem toDoItem){
//        todoService.update(toDoItem.getId());
        return ResponseEntity.ok(todoService.searchById(toDoItem.getId()));
    }
}
