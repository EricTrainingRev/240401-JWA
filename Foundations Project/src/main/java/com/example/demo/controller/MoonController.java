package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Moon;
import com.example.demo.exceptions.AuthenticationFailed;
import com.example.demo.exceptions.EntityNotFound;
import com.example.demo.service.MoonService;

@RestController
public class MoonController {

    private static Logger moonLogger = LoggerFactory.getLogger(MoonController.class);

    @Autowired
    private MoonService moonService;

    @ExceptionHandler(EntityNotFound.class)
    public ResponseEntity<String> entityNotFound(EntityNotFound e) {
        moonLogger.error(e.getLocalizedMessage(), e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<String> notAuthorized(AuthenticationFailed e) {
        moonLogger.error(e.getLocalizedMessage(), e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/api/moon")
    public ResponseEntity<List<Moon>> findAll() {
        return new ResponseEntity<>(moonService.findAllMoons(), HttpStatus.OK);
    }

    @GetMapping("/api/moon/id/{id}")
    public ResponseEntity<Moon> findById(@PathVariable int id) {
        return new ResponseEntity<>(this.moonService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/api/moon/{name}")
    public ResponseEntity<Moon> findByName(@PathVariable String name) {
        return new ResponseEntity<>(this.moonService.findByName(name), HttpStatus.OK);
    }

    @PostMapping("/api/moon")
    public ResponseEntity<String> createMoon(@RequestBody Moon newMoon) {
        return new ResponseEntity<>(this.moonService.createMoon(newMoon), HttpStatus.CREATED);
    }

    @DeleteMapping("/api/moon/{name}")
    public ResponseEntity<String> deleteMoon(@PathVariable String name) {
        return new ResponseEntity<>(this.moonService.deleteMoon(name), HttpStatus.OK);
    }

}
