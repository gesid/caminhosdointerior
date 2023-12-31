package br.ufc.crateus.madacarudev.country_town_paths.dtos.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCityInputDto {
    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    private Long regionId;
}
