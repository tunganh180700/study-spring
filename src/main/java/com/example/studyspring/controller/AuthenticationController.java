package com.example.studyspring.controller;

import com.example.studyspring.dto.JwtAuthenticationResponse;
import com.example.studyspring.dto.LoginRequest;
import com.example.studyspring.dto.RegisterRequest;
import com.example.studyspring.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public JwtAuthenticationResponse login(@RequestBody LoginRequest loginRequest){
        return authenticationService.login(loginRequest);
    }

    @PostMapping("/register")
    public JwtAuthenticationResponse register(@RequestBody RegisterRequest registerRequest){
        return authenticationService.register(registerRequest);
    }
}
