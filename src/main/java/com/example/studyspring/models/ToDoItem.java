package com.example.studyspring.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TODO_LIST")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ToDoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "plan")
    private String plan;

    @Column(name = "description")
    private String description;

    @Column(name = "status_id")
    private int statusId;
}
