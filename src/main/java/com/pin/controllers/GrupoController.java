package com.pin.controllers;

import com.pin.entities.GrupoEntity;
import com.pin.services.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/grupo")
public class GrupoController {

    @Autowired
    private GrupoService grupoService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody GrupoEntity grupo) {
        try {
            return new ResponseEntity<>(String.valueOf(grupoService.save(grupo)), HttpStatus.CREATED);

        } catch (RuntimeException e) {
            return new ResponseEntity<>(String.valueOf(e), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findById")
    public ResponseEntity<String> findById(@RequestParam Long id) {
        try {
            return new ResponseEntity<>(String.valueOf(grupoService.findById(id)), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(String.valueOf(e), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<String> findAll() {
        try {
            return new ResponseEntity<>(String.valueOf(grupoService.findAll()), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(String.valueOf(e), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody GrupoEntity grupo) {
        try {
            return new ResponseEntity<>(String.valueOf(grupoService.update(grupo)), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(String.valueOf(e), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam Long id) {
        try {
            return new ResponseEntity<>(String.valueOf(grupoService.delete(id)), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(String.valueOf(e), HttpStatus.BAD_REQUEST);
        }
    }
}