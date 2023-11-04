package br.ufc.crateus.madacarudev.country_town_paths.services;

import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.CreateTouristAttractionCategoryInputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.EventOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.SampleTouristAttractionCategoryWithEventsAndLocationOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.TouristAttractionCategoryOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.TouristLocationOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityConflictException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityNotFoundException;
import br.ufc.crateus.madacarudev.country_town_paths.models.TouristAttractionCategoryModel;
import br.ufc.crateus.madacarudev.country_town_paths.repositories.TouristAttractionCategoryRepository;
import br.ufc.crateus.madacarudev.country_town_paths.utils.EventMapper;
import br.ufc.crateus.madacarudev.country_town_paths.utils.TouristLocationMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TouristAttractionCategoryService {
  private final TouristAttractionCategoryRepository touristAttractionCategoryRepository;
  private final ModelMapper modelMapper;
  private final TouristLocationMapper touristLocationMapper;
  private final EventMapper eventMapper;

  public TouristAttractionCategoryModel getById(Long id) throws EntityNotFoundException {
    Optional<TouristAttractionCategoryModel> searchedTouristAttractionCategory
      = this.touristAttractionCategoryRepository.findById(id);

    if(searchedTouristAttractionCategory.isEmpty()){
      String message = String.format("Não existe uma categoria de atração turística com o id: %s", id.toString());
      throw new EntityNotFoundException(message);
    }

    return searchedTouristAttractionCategory.get();
  }

  public List<TouristAttractionCategoryOutputDto> getAll(){
    List<TouristAttractionCategoryModel> touristAttractionCategoryModelList
      = this.touristAttractionCategoryRepository.findAll();

    return touristAttractionCategoryModelList.stream().map(touristAttractionCategoryModel -> this.modelMapper.map(
        touristAttractionCategoryModel,
        TouristAttractionCategoryOutputDto.class)
      ).collect(Collectors.toList());
  }

  public List<SampleTouristAttractionCategoryWithEventsAndLocationOutputDto> getAllSampleTouristAttractionCategory() {
    List<TouristAttractionCategoryModel> touristAttractionCategoryModels = 
    touristAttractionCategoryRepository.findAll();

    List<SampleTouristAttractionCategoryWithEventsAndLocationOutputDto> touristAttractionCategoryOutputDtos = 
    new ArrayList<SampleTouristAttractionCategoryWithEventsAndLocationOutputDto>();

    for (TouristAttractionCategoryModel touristAttractionCategoryModel : touristAttractionCategoryModels) {
      SampleTouristAttractionCategoryWithEventsAndLocationOutputDto touristAttractionCategoryOutputDto = 
      modelMapper.map(touristAttractionCategoryModel, SampleTouristAttractionCategoryWithEventsAndLocationOutputDto.class);

      List<TouristLocationOutputDto> locations = this.touristLocationMapper.convertModelToSampleOutputDtoCollection(touristAttractionCategoryModel.getTouristLocations());
      touristAttractionCategoryOutputDto.setLocations(locations);

      List<EventOutputDto> events = this.eventMapper.convertModelToSampleOutputDtoCollection(touristAttractionCategoryModel.getEvents());
      touristAttractionCategoryOutputDto.setEvents(events);

      touristAttractionCategoryOutputDtos.add(touristAttractionCategoryOutputDto);
    }

    return touristAttractionCategoryOutputDtos;
  }

  public void create(CreateTouristAttractionCategoryInputDto input) throws EntityConflictException {
    Optional<TouristAttractionCategoryModel> touristAttractionCategoryWithSameName
      = this.touristAttractionCategoryRepository.findByName(input.getName());

    if(touristAttractionCategoryWithSameName.isPresent()){
      String message = String.format("Já existe uma categoria com o nome: %s", input.getName());
      throw new EntityConflictException(message);
    }

    TouristAttractionCategoryModel touristAttractionCategory = this.modelMapper.map(input, TouristAttractionCategoryModel.class);
    this.touristAttractionCategoryRepository.save(touristAttractionCategory);
  }
}

