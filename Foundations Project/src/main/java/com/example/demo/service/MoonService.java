package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Moon;
import com.example.demo.exceptions.EntityNotFound;
import com.example.demo.repository.MoonDao;

import java.util.List;
import java.util.Optional;

@Service
public class MoonService {
    
    @Autowired
    private MoonDao moonDao;

    public List<Moon> findAllMoons() {
        List<Moon> moons = this.moonDao.findAll();
        if (moons.size() == 0) {
            throw new EntityNotFound("No moons found");
        }
        return moons;
    }

    public Moon findByName(String name) {
        Optional<Moon> possibleMoon = this.moonDao.findByMoonName(name);
        if (possibleMoon.isPresent()) {
            return possibleMoon.get();
        }
        throw new EntityNotFound("No moon found");
    }

    public Moon findById(int id) {
        Optional<Moon> possibleMoon = this.moonDao.findById(id);
        if (possibleMoon.isPresent()) {
            return possibleMoon.get();
        }
        throw new EntityNotFound("No moon found");
    }

    public String createMoon(Moon moon) {
        this.moonDao.createMoon(moon.getMoonName(), moon.getOwnerId());
        return "Moon created";
    }

    public String deleteMoon(String name) {
        this.moonDao.deleteMoon(name);
        return "Moon deleted";
    }

}
