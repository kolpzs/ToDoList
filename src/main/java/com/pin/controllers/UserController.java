package com.pin.controllers;

import com.pin.entities.UserEntity;
import com.pin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody UserEntity user) {
        try {
            return new ResponseEntity<>(String.valueOf(userService.save(user)), HttpStatus.CREATED);

        } catch (RuntimeException e) {
            return new ResponseEntity<>(String.valueOf(e), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById")
    public ResponseEntity<String> findById(@RequestParam Long id) {
        try {
            return new ResponseEntity<>(String.valueOf(userService.findById(id)), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(String.valueOf(e), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<String> findAll() {
        try {
            return new ResponseEntity<>(String.valueOf(userService.findAll()), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(String.valueOf(e), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody UserEntity user) {
        try {
            return new ResponseEntity<>(String.valueOf(userService.update(user)), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(String.valueOf(e), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam Long id) {
        try {
            return new ResponseEntity<>(String.valueOf(userService.delete(id)), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(String.valueOf(e), HttpStatus.BAD_REQUEST);
        }
    }
}