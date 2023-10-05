package br.ufc.crateus.madacarudev.country_town_paths.utils;

import java.util.List;
import java.util.stream.Collectors;

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
}
