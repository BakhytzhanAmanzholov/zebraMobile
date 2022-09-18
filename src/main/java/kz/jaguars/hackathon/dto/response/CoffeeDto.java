package kz.jaguars.hackathon.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CoffeeDto {
    private Long id;
    private String shortName;
    private String address;
    private String workingHours;
}
