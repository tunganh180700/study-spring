package com.example.studyspring.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "publisher_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private int publisher_id;

    @Column(name = "publisher_name")
    private String publisher_name;

    @Column(name = "publisher_address")
    private String publisher_address;

    @Column(name = "website")
    private String website;
}
