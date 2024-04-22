package com.example.studyspring.controller;

import com.example.studyspring.dto.JwtAuthenticationResponse;
import com.example.studyspring.dto.LoginRequest;
import com.example.studyspring.dto.RegisterRequest;
import com.example.studyspring.models.User;
import com.example.studyspring.repositories.UserRepository;
import com.example.studyspring.services.AuthenticationService;
import com.example.studyspring.services.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private final JwtService jwtService;

    @GetMapping("/users")
    public ResponseEntity<?> getUser(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String authHeader) {
        String token = jwtService.extractTokenFromAuthorizationHeader(authHeader);
        Map<String, Object> response = new HashMap<>();
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (token != null) {
            String username = jwtService.extractUserName(token);
            Optional<User> user = userRepository.findByUsername(username);
            if (user.isPresent()) {
                response.put("data", user);
                response.put("success", true);
                response.put("message", "Ok");
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.put("success", false);
                response.put("message", "User not found");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
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
