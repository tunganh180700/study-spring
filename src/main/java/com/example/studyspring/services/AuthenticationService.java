package com.example.studyspring.services;

import com.example.studyspring.dto.JwtAuthenticationResponse;
import com.example.studyspring.dto.LoginRequest;
import com.example.studyspring.dto.RegisterRequest;
import com.example.studyspring.models.Role;
import com.example.studyspring.models.User;
import com.example.studyspring.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public JwtAuthenticationResponse register(RegisterRequest registerRequest) {
        var user = User
                .builder()
                .first_name(registerRequest.getFirst_name())
                .last_name(registerRequest.getLast_name())
                .username(registerRequest.getUsername())
                .password(registerRequest.getPassword())
                .gender(registerRequest.getGender())
                .role(Role.USER)
                .build();

        user = userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).role(String.valueOf(Role.USER)).build();
    }

    public JwtAuthenticationResponse login(LoginRequest loginRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        var user = userRepository.findByUsername(loginRequest.getUsername()).orElseThrow(() -> new IllegalArgumentException("Invalid username or pass"));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).role(String.valueOf(user.getRole())).build();
    }
}
