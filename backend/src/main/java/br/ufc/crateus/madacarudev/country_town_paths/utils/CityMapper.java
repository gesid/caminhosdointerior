package br.ufc.crateus.madacarudev.country_town_paths.utils;

import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.SampleCityOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.models.CityModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CityMapper {
  private final ModelMapper modelMapper;

  public List<SampleCityOutputDto> convertModelToSampleOutputDtoCollection(List<CityModel> cities){
    return cities.stream().map(cityModel -> modelMapper.map(
      cityModel,
      SampleCityOutputDto.class)
    ).collect(Collectors.toList());
  }
}
