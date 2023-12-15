package br.ufc.crateus.madacarudev.country_town_paths.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.DetailedTouristLocationOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.ImageOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.SampleTouristLocationOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.models.TouristLocationImageModel;
import br.ufc.crateus.madacarudev.country_town_paths.models.TouristLocationModel;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TouristLocationMapper {
  private final ModelMapper modelMapper;

  public List<SampleTouristLocationOutputDto> convertModelToSampleOutputDtoCollection(List<TouristLocationModel> locations){
    return locations.stream().map(location -> modelMapper.map(
      location,
      SampleTouristLocationOutputDto.class)
    ).collect(Collectors.toList());
  }

  public DetailedTouristLocationOutputDto convertModelToDetailedOutputDto(TouristLocationModel touristLocation){
    DetailedTouristLocationOutputDto touristLocationOutputDto = this.modelMapper.map(touristLocation, DetailedTouristLocationOutputDto.class);

    List<ImageOutputDto> images = new ArrayList<ImageOutputDto>();

    for (TouristLocationImageModel image : touristLocation.getPreviewImages()) {
      ImageOutputDto imageOutputDto = new ImageOutputDto();

      imageOutputDto.setId(image.getId());
      imageOutputDto.setUrl(image.getUrl());

      images.add(imageOutputDto);
    }

    touristLocationOutputDto.setPreviewImages(images);
    return touristLocationOutputDto;
  }
}
