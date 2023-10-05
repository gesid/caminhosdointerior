package br.ufc.crateus.madacarudev.country_town_paths.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.SampleEventOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.TouristAttractionsWithCategoriesOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.SampleTouristLocationOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.models.TouristAttractionCategoryModel;
import br.ufc.crateus.madacarudev.country_town_paths.repositories.TouristAttractionCategoryRepository;
import br.ufc.crateus.madacarudev.country_town_paths.utils.EventMapper;
import br.ufc.crateus.madacarudev.country_town_paths.utils.TouristLocationMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TouristAttractionService {
  private final TouristAttractionCategoryRepository touristAttractionCategoryRepository;
  private final ModelMapper modelMapper;
  private final TouristLocationMapper touristLocationMapper;
  private final EventMapper eventMapper;

  public List<TouristAttractionsWithCategoriesOutputDto> getAllSampleTouristAttractionCategory() {
    List<TouristAttractionCategoryModel> touristAttractionCategoryModels = 
    touristAttractionCategoryRepository.findAll();

    List<TouristAttractionsWithCategoriesOutputDto> touristAttractionCategoryOutputDtos = 
    new ArrayList<TouristAttractionsWithCategoriesOutputDto>();

    for (TouristAttractionCategoryModel touristAttractionCategoryModel : touristAttractionCategoryModels) {
      TouristAttractionsWithCategoriesOutputDto touristAttractionCategoryOutputDto = 
      modelMapper.map(touristAttractionCategoryModel, TouristAttractionsWithCategoriesOutputDto.class);

      List<SampleTouristLocationOutputDto> locations = this.touristLocationMapper.convertModelToSampleOutputDtoCollection(touristAttractionCategoryModel.getTouristLocations());
      touristAttractionCategoryOutputDto.setLocations(locations);

      List<SampleEventOutputDto> events = this.eventMapper.convertModelToSampleOutputDtoCollection(touristAttractionCategoryModel.getEvents());
      touristAttractionCategoryOutputDto.setEvents(events);

      touristAttractionCategoryOutputDtos.add(touristAttractionCategoryOutputDto);
    }

    return touristAttractionCategoryOutputDtos;
  }
}
