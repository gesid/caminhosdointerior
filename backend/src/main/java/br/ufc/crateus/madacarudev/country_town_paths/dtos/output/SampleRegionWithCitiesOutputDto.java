package br.ufc.crateus.madacarudev.country_town_paths.dtos.output;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SampleRegionWithCitiesOutputDto extends RegionOutputDto {
  private List<SampleCityOutputDto> cities;
}
