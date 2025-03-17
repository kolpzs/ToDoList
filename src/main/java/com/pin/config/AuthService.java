package com.pin.config;

import com.pin.entities.UserEntity;
import com.pin.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String authenticate(String username, String password) {
        UserEntity user = userRepository.findByUsername(username);

        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return JwtUtil.generateToken(username, user.getRole());
        }

        throw new RuntimeException("Credenciais inválidas");
    }
}
