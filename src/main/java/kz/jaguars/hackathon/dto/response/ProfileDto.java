package kz.jaguars.hackathon.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
public class ProfileDto {
    private Long id;
    private String username;
    private String email;
    private String phoneNumber;
    private Integer discount;

    private Set<ProductDto> preferences;
}
