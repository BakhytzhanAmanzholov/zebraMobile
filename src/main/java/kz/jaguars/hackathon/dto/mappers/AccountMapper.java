package kz.jaguars.hackathon.dto.mappers;

import kz.jaguars.hackathon.dto.request.RegistrationDto;
import kz.jaguars.hackathon.dto.response.ProfileDto;
import kz.jaguars.hackathon.models.Account;
import kz.jaguars.hackathon.models.Product;

import java.util.HashSet;

public class AccountMapper {
    public static Account fromRequestDto(RegistrationDto registrationDto){
        return Account.builder()
                .email(registrationDto.getEmail())
                .username(registrationDto.getUsername())
                .password(registrationDto.getPassword())
                .phoneNumber(registrationDto.getPhoneNumber())
                .banned(true)
                .confirmed(false)
                .build();
    }

    public static ProfileDto toResponseDto(Account account){
        ProfileDto profile =  ProfileDto.builder()
                .id(account.getId())
                .email(account.getEmail())
                .phoneNumber(account.getPhoneNumber())
                .username(account.getUsername())
                .preferences(new HashSet<>())
                .discount(account.getDiscount())
                .build();
        for (Product product: account.getPreferences()){
            profile.getPreferences().add(ProductMapper.toResponseDto(product));
        }
        return profile;
    }
}
