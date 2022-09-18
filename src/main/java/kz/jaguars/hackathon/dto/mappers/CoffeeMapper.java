package kz.jaguars.hackathon.dto.mappers;

import kz.jaguars.hackathon.dto.response.CoffeeDto;
import kz.jaguars.hackathon.models.CoffeeHouse;

public class CoffeeMapper {
    public static CoffeeDto toResponseDto(CoffeeHouse coffeeHouse){
        return CoffeeDto.builder()
                .id(coffeeHouse.getId())
                .address(coffeeHouse.getAddress())
                .workingHours(coffeeHouse.getWorkingHours())
                .shortName(coffeeHouse.getShortName())
                .build();
    }
}
