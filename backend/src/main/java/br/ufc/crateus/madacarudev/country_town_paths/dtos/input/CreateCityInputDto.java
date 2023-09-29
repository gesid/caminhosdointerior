package br.ufc.crateus.madacarudev.country_town_paths.dtos.input;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCityInputDto {
    @NotBlank
    private String name;

    @NotBlank
    private String imageBannerUrl;

    @NotBlank
    private String description;

    @NotNull
    private UUID regionId;
}
