package kz.jaguars.hackathon.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PreferenceDto {
    private Long id;
    private String title;
    private String description;
}
