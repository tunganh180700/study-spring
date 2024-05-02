package com.example.studyspring.repositories;

import com.example.studyspring.models.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
    @Query(value = "SELECT p FROM Publisher p")
    List<Publisher> getAllPublishers();
}
