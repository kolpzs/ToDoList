package com.pin.services;

import com.pin.entities.UserEntity;
import com.pin.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserEntity save(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<List<UserEntity>> findAll() {
        List<UserEntity> total = userRepository.findAll();
        List<List<UserEntity>> separados = new ArrayList<>();

        for (int i = 0; i < total.size(); i += 20) {
            List<UserEntity> subLista = total.subList(i, Math.min(i + 20, total.size()));
            separados.add(new ArrayList<>(subLista));
        }

        return separados;
    }

    public UserEntity update(UserEntity user) {
        return userRepository.save(user);
    }

    public String delete(Long id) {
        userRepository.deleteById(id);
        return "User deleted";
    }
}
