package kz.jaguars.hackathon.controllers;

import kz.jaguars.hackathon.dto.mappers.PreferenceMapper;
import kz.jaguars.hackathon.dto.response.PreferenceDto;
import kz.jaguars.hackathon.models.Preference;
import kz.jaguars.hackathon.services.PreferenceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/preference")
public class PreferenceController {

    private final PreferenceService preferenceService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        List<Preference> preferences = preferenceService.findAll();
        List<PreferenceDto> dtoList = new ArrayList<>();
        for (Preference preference: preferences){
            dtoList.add(PreferenceMapper.toResponseDto(preference));
        }
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public  ResponseEntity<?> addPreference(@PathVariable("id") Long id){
        preferenceService.addPreferenceToUser(id);
        return new ResponseEntity<>("Preference added successfully", HttpStatus.OK);
    }
}
