package br.ufc.crateus.madacarudev.country_town_paths.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.TouristLocationOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.models.TouristLocationModel;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TouristLocationMapper {
  private final ModelMapper modelMapper;

  public List<TouristLocationOutputDto> convertModelToSampleOutputDtoCollection(List<TouristLocationModel> locations){
    return locations.stream().map(location -> modelMapper.map(
      location,
      TouristLocationOutputDto.class)
    ).collect(Collectors.toList());
  }
}
