package com.example.studyspring.controller;

import com.example.studyspring.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/publisher")
@CrossOrigin(origins = "*")
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    @GetMapping("/")
    public ResponseEntity<?> getAllPublisher() {
        return ResponseEntity.ok(publisherService.getAllPublishers().getBody());
    }
}
