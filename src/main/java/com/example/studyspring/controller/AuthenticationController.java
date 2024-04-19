package com.example.studyspring.controller;

import com.example.studyspring.dto.JwtAuthenticationResponse;
import com.example.studyspring.dto.LoginRequest;
import com.example.studyspring.dto.RegisterRequest;
import com.example.studyspring.models.User;
import com.example.studyspring.repositories.UserRepository;
import com.example.studyspring.services.AuthenticationService;
import com.example.studyspring.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserRepository userRepository;

    @GetMapping("/user")
    public ResponseEntity<?> getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Map<String, Object> response = new HashMap<>();
        Optional<User> dataUser = userRepository.findByUsername(username);
        System.out.println(authentication);
        if (dataUser.isPresent()) {
            User user = dataUser.get();
            response.put("success", true);
            response.put("data", user);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("success", false);
            response.put("message", "User not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/login")
    public JwtAuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
        return authenticationService.login(loginRequest);
    }

    @PostMapping("/register")
    public JwtAuthenticationResponse register(@RequestBody RegisterRequest registerRequest) {
        return authenticationService.register(registerRequest);
    }
}
