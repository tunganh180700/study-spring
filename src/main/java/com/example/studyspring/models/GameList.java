package com.example.studyspring.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "game_list")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GameList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private int game_id;

    @Column(name = "game_name")
    private String game_name;

    @Column(name = "game_type_id")
    private int game_type_id;

    @Column(name = "publisher_id")
    private int publisher_id;
}
