package com.example.studyspring.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "game_type_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GameType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_type_id")
    private int game_type_id;

    @Column(name = "game_type")
    private String game_type;
}
