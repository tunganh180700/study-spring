package com.example.studyspring.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameDto {
    int game_id;
    String game_name;
    String game_type;
    String publisher_name;

//    public interface InfoGameList{
//        int game_id();
//        String game_name();
//        String game_type();
//        String publisher_name();
//    }
}
