package com.example.studyspring.services;

import com.example.studyspring.models.ToDoItem;
import com.example.studyspring.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public ResponseEntity<List<ToDoItem>> getAllTodo(){
        List<ToDoItem> list = todoRepository.getAllTodo();
        if(list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    public ResponseEntity<?> add(){
        ToDoItem toDoItem = new ToDoItem();
        toDoItem.setPlan("An cut");
        toDoItem.setDescription("Nay toi an cut ngon vl");
        toDoItem.setStatusId(2);
        return new ResponseEntity<>(todoRepository.save(toDoItem), HttpStatus.OK);
    }

    public ResponseEntity<?> update(int id){
        ToDoItem toDoItem = todoRepository.findById(id).orElse(null);
        if(toDoItem != null){
            toDoItem.setStatusId(1);
            return new ResponseEntity<>(todoRepository.save(toDoItem), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
