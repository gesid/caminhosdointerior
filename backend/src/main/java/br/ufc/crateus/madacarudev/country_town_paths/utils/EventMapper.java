package br.ufc.crateus.madacarudev.country_town_paths.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.DetailedCityOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.DetailedEventOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.ImageOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.models.CityImageModel;
import br.ufc.crateus.madacarudev.country_town_paths.models.CityModel;
import br.ufc.crateus.madacarudev.country_town_paths.models.EventImageModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.SampleEventOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.models.EventModel;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class EventMapper {
  private final ModelMapper modelMapper;

  public List<SampleEventOutputDto> convertModelToSampleOutputDtoCollection(List<EventModel> events){
    return events.stream().map(event -> modelMapper.map(
      event,
      SampleEventOutputDto.class)
    ).collect(Collectors.toList());
  }

  public DetailedEventOutputDto convertModelToDetailedOutputDto(EventModel event){
    DetailedEventOutputDto eventOutputDto = this.modelMapper.map(event, DetailedEventOutputDto.class);

    List<ImageOutputDto> images = new ArrayList<ImageOutputDto>();

    for (EventImageModel image : event.getPreviewImages()) {
      ImageOutputDto imageOutputDto = new ImageOutputDto();

      imageOutputDto.setId(image.getId());
      imageOutputDto.setUrl(image.getUrl());

      images.add(imageOutputDto);
    }

    eventOutputDto.setPreviewImages(images);
    return eventOutputDto;
  }
}
