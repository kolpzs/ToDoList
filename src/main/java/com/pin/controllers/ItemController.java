package com.pin.controllers;

import com.pin.entities.ItemEntity;
import com.pin.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody ItemEntity item) {
        try {
            return new ResponseEntity<>(String.valueOf(itemService.save(item)), HttpStatus.CREATED);

        } catch (RuntimeException e) {
            return new ResponseEntity<>(String.valueOf(e), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById")
    public ResponseEntity<String> findById(@RequestParam Long id) {
        try {
            return new ResponseEntity<>(String.valueOf(itemService.findById(id)), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(String.valueOf(e), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<String> findAll() {
        try {
            return new ResponseEntity<>(String.valueOf(itemService.findAll()), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(String.valueOf(e), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody ItemEntity item) {
        try {
            return new ResponseEntity<>(String.valueOf(itemService.update(item)), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(String.valueOf(e), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam Long id) {
        try {
            return new ResponseEntity<>(String.valueOf(itemService.delete(id)), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(String.valueOf(e), HttpStatus.BAD_REQUEST);
        }
    }
}