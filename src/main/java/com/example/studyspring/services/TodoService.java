package com.example.studyspring.services;

import com.example.studyspring.models.ToDoItem;
import com.example.studyspring.repositories.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<ToDoItem> getAllTodo(){
        List<ToDoItem> list = todoRepository.getAllTodo();
        if(list.isEmpty()){
            return HttpStatus.NO_CONTENT;
        }
        return list;
    }
}
