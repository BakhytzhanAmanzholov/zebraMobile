package kz.jaguars.hackathon.services;

import kz.jaguars.hackathon.models.CoffeeHouse;

import java.util.List;

public interface CoffeeService {
    List<CoffeeHouse> findAll();

    CoffeeHouse findById(Long id);
}
