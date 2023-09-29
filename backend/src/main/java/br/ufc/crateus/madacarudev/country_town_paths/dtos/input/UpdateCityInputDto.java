package br.ufc.crateus.madacarudev.country_town_paths.dtos.input;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCityInputDto {
    @NotBlank
    private String name;
    private String imageBannerUrl;
    private String description;
    private UUID regionId;
}
