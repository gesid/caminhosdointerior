package br.ufc.crateus.madacarudev.country_town_paths.dtos.input;

import javax.validation.constraints.NotBlank;

import br.ufc.crateus.madacarudev.country_town_paths.models.RegionModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCityDto {
    @NotBlank
    private String name;
    private String imageBannerUrl;
    private String description;
    private RegionModel region;
}
