package br.ufc.crateus.madacarudev.country_town_paths.dtos.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateRegionDto {
    @NotBlank
    private String name;
}
