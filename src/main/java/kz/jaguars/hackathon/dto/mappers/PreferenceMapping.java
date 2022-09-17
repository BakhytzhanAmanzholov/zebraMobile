package kz.jaguars.hackathon.dto.mappers;

import kz.jaguars.hackathon.dto.response.PreferenceDto;
import kz.jaguars.hackathon.models.Preference;

public class PreferenceMapping {

    public static PreferenceDto preferenceDto(Preference preference){
        return PreferenceDto.builder()
                .id(preference.getId())
                .description(preference.getDescription())
                .title(preference.getTitle())
                .build();
    }

}
