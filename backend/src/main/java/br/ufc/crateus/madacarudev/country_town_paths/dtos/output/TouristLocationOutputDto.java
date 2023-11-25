package br.ufc.crateus.madacarudev.country_town_paths.dtos.output;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TouristLocationOutputDto {
    private Long id;
    public String name;
    public String bannerImage;
}
