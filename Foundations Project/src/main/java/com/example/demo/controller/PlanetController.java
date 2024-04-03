package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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

import com.example.demo.entities.Planet;
import com.example.demo.exceptions.AuthenticationFailed;
import com.example.demo.exceptions.EntityNotFound;
import com.example.demo.service.PlanetService;

@RestController
public class PlanetController {

    private static Logger planetLogger = LoggerFactory.getLogger(PlanetController.class);

    @Autowired
    private PlanetService planetService;

    @ExceptionHandler(EntityNotFound.class)
    public ResponseEntity<String> entityNotFound(EntityNotFound e) {
        planetLogger.error(e.getLocalizedMessage(), e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<String> notAuthorized(AuthenticationFailed e) {
        planetLogger.error(e.getLocalizedMessage(), e);
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/api/planet")
    public ResponseEntity<List<Planet>> findAll() {
        return new ResponseEntity<>(planetService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/api/planet/id/{id}")
    public ResponseEntity<Planet> findById(@PathVariable int id) {
        return new ResponseEntity<>(this.planetService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/api/planet/{name}")
    public ResponseEntity<Planet> findByName(@PathVariable String name) {
        return new ResponseEntity<>(this.planetService.findByName(name), HttpStatus.OK);
    }

    @PostMapping("/api/planet")
    public ResponseEntity<String> createPlanet(@RequestBody Planet newPlanet) {
        return new ResponseEntity<>(this.planetService.createPlanet(newPlanet), HttpStatus.CREATED);
    }

    @DeleteMapping("/api/planet/{name}")
    public ResponseEntity<String> deletePlanet(@PathVariable String name) {
        return new ResponseEntity<>(this.planetService.deletePlanet(name), HttpStatus.OK);
    }
}
