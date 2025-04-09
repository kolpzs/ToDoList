package com.pin.config;

import com.pin.entities.UserEntity;
import com.pin.exception.UserNotFoundException;
import com.pin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String authenticate(String username, String password) {
        try {
            UserEntity user = userService.findByUsername(username);
            if (passwordEncoder.matches(password, user.getPassword())) {
                return JwtUtil.generateToken(username, user.getRole());
            } else {
                throw new RuntimeException("Credenciais inválidas");
            }
        } catch (UserNotFoundException e) {
            throw new RuntimeException("Credenciais inválidas");
        }
    }
}