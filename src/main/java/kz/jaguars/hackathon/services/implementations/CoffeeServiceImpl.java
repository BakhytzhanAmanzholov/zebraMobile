package kz.jaguars.hackathon.services.implementations;

import kz.jaguars.hackathon.exceptions.NotFoundException;
import kz.jaguars.hackathon.models.CoffeeHouse;
import kz.jaguars.hackathon.repositories.CoffeeRepository;
import kz.jaguars.hackathon.services.CoffeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CoffeeServiceImpl implements CoffeeService {

    private final CoffeeRepository coffeeRepository;

    @Override
    public List<CoffeeHouse> findAll() {
        return (List<CoffeeHouse>) coffeeRepository.findAll();
    }

    @Override
    public CoffeeHouse findById(Long id) {
        return coffeeRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Coffee <" + id + "> not found"));
    }
}
