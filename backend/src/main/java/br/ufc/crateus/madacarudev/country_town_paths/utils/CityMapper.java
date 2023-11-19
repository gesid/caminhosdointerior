package br.ufc.crateus.madacarudev.country_town_paths.utils;

import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.DetailedCityOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.ImageOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.SampleCityOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.models.CityImageModel;
import br.ufc.crateus.madacarudev.country_town_paths.models.CityModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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

  public DetailedCityOutputDto convertModelToDetailedOutputDto(CityModel city){
    DetailedCityOutputDto cityOutputDto = this.modelMapper.map(city, DetailedCityOutputDto.class);

    List<ImageOutputDto> images = new ArrayList<ImageOutputDto>();

    for (CityImageModel image : city.getImagesCity()) {
      ImageOutputDto imageOutputDto = new ImageOutputDto();

      imageOutputDto.setId(image.getId());
      imageOutputDto.setUrl(image.getUrl());

      images.add(imageOutputDto);
    }

    cityOutputDto.setPreviewImages(images);
    return cityOutputDto;
  }
}
