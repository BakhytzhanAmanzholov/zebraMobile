package kz.jaguars.hackathon.controllers;

import kz.jaguars.hackathon.dto.mappers.CoffeeMapper;
import kz.jaguars.hackathon.dto.response.CoffeeDto;
import kz.jaguars.hackathon.models.CoffeeHouse;
import kz.jaguars.hackathon.services.CoffeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/cafe")
public class CoffeeController {
    private final CoffeeService coffeeService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        List<CoffeeHouse> coffeeHouseList = coffeeService.findAll();
        List<CoffeeDto> dtoList = new ArrayList<>();

        for (CoffeeHouse coffeeHouse: coffeeHouseList){
            dtoList.add(CoffeeMapper.toResponseDto(coffeeHouse));
        }

        return new ResponseEntity<>(dtoList,HttpStatus.OK);
    }


}
