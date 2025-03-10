package com.pin.services;

import com.pin.entities.UserEntity;
import com.pin.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }

    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public UserEntity update(UserEntity user) {
        return userRepository.save(user);
    }

    public String delete(Long id) {
        userRepository.deleteById(id);
        return "User deleted";
    }
}
