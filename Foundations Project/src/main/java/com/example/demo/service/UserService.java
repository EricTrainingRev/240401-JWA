package com.example.demo.service;

import java.util.Optional;

import com.example.demo.exceptions.AuthenticationFailed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.LoginInfo;
import com.example.demo.entities.User;
import com.example.demo.repository.UserDao;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public String createUser(User newUser) {
        this.userDao.createUser(newUser.getUserUsername(), newUser.getUserPassword());
        return "User registered";
    }

    public User authenticate(LoginInfo loginInfo) {
        Optional<User> possibleUser = this.userDao.findByUserUsername(loginInfo.getUsername());
        if(possibleUser.isPresent() && possibleUser.get().getUserPassword().equals(loginInfo.getPassword())){
            return possibleUser.get();
        } else {
            throw new AuthenticationFailed("login attempt failed");
        }
    }
}
