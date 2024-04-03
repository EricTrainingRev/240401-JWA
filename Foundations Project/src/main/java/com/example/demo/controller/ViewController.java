package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class ViewController {

    @GetMapping("/page/login")
    public String login(){
        try {
            String content = Files.readString(Paths.get("src/main/resources/pages/login.html"));
            return content;
        } catch (IOException e) {
            e.printStackTrace();
            return "Error loading file content";
        }
    }

    @GetMapping("/page/home")
    public String home(){
        try {
            String content = Files.readString(Paths.get("src/main/resources/pages/home.html"));
            return content;
        } catch (IOException e) {
            e.printStackTrace();
            return "Error loading file content";
        }
    }

    @GetMapping("/page/create")
    public String create(){
        try {
            String content = Files.readString(Paths.get("src/main/resources/pages/create.html"));
            return content;
        } catch (IOException e) {
            e.printStackTrace();
            return "Error loading file content";
        }
    }
}
