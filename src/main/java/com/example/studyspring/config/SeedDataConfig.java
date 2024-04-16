package com.example.studyspring.config;

import com.example.studyspring.models.Role;
import com.example.studyspring.models.User;
import com.example.studyspring.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class SeedDataConfig implements CommandLineRunner {
    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            User admin = User
                    .builder()
                    .first_name("admin")
                    .last_name("admin")
                    .username("admin")
                    .password("admin")
                    .gender(1)
                    .role(Role.ADMIN)
                    .build();
            userRepository.save(admin);
            log.debug("created ADMIN user - {}", admin);
        }
    }
}
