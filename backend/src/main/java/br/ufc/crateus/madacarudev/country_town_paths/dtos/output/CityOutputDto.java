package br.ufc.crateus.madacarudev.country_town_paths.dtos.output;

import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotBlank;

import br.ufc.crateus.madacarudev.country_town_paths.models.RegionModel;
import br.ufc.crateus.madacarudev.country_town_paths.models.TouristLocationModel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CityOutputDto {

    private UUID id;
    @NotBlank
    public String name;
    public String imageBannerUrl;
    public String description;
    public RegionModel region;
    
}
