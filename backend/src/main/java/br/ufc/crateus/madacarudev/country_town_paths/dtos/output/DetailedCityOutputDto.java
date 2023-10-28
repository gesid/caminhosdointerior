package br.ufc.crateus.madacarudev.country_town_paths.dtos.output;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DetailedCityOutputDto extends CityOutputDto {
  private List<ImageOutputDto> previewImages;
}
