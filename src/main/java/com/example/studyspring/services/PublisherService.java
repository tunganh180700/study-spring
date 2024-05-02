package com.example.studyspring.services;

import com.example.studyspring.models.Publisher;
import com.example.studyspring.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

    public ResponseEntity<List<Publisher>> getAllPublishers() {
        List<Publisher> publishers = publisherRepository.getAllPublishers();
        if (publishers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(publishers, HttpStatus.OK);
    }
}
