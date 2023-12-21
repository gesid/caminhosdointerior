package br.ufc.crateus.madacarudev.country_town_paths.services;

import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.CreateTouristAttractionCategoryInputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.TouristAttractionCategoryOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityConflictException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityNotFoundException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.FileProcessingException;
import br.ufc.crateus.madacarudev.country_town_paths.models.TouristAttractionCategoryModel;
import br.ufc.crateus.madacarudev.country_town_paths.repositories.TouristAttractionCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TouristAttractionCategoryService {
  private final TouristAttractionCategoryRepository touristAttractionCategoryRepository;
  private final TouristAttractionCategoryIconService touristAttractionCategoryIconService;

  private final ModelMapper modelMapper;

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

  @Transactional
  public void create(CreateTouristAttractionCategoryInputDto input) throws EntityConflictException, FileProcessingException {
    Optional<TouristAttractionCategoryModel> touristAttractionCategoryWithSameName
      = this.touristAttractionCategoryRepository.findByName(input.getName());

    if(touristAttractionCategoryWithSameName.isPresent()){
      String message = String.format("Já existe uma categoria com o nome: %s", input.getName());
      throw new EntityConflictException(message);
    }

    String iconUrl = this.touristAttractionCategoryIconService.storeImage(input.getIcon());

    TouristAttractionCategoryModel touristAttractionCategory = this.modelMapper.map(input, TouristAttractionCategoryModel.class);
    touristAttractionCategory.setIconUrl(iconUrl);

    this.touristAttractionCategoryRepository.save(touristAttractionCategory);
  }
}

