package br.ufc.crateus.madacarudev.country_town_paths.dtos.output;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetailedTouristLocationOutputDto extends TouristLocationOutputDto{
  private List<ImageOutputDto> previewImages;
}