package kz.jaguars.hackathon.controllers;

import kz.jaguars.hackathon.dto.mappers.AccountMapper;
import kz.jaguars.hackathon.models.Account;
import kz.jaguars.hackathon.services.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/profile")
public class ProfileController {

    private final AccountService accountService;

    @GetMapping
    public ResponseEntity<?> profile(){
        Account account = accountService.findByEmail(accountService.isLogged());
        return new ResponseEntity<>(AccountMapper.toResponseDto(account), HttpStatus.OK);
    }
}
