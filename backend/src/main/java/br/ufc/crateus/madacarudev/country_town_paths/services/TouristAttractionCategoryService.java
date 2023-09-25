package br.ufc.crateus.madacarudev.country_town_paths.services;

import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityNotFoundException;
import br.ufc.crateus.madacarudev.country_town_paths.models.TouristAttractionCategoryModel;
import br.ufc.crateus.madacarudev.country_town_paths.repositories.TouristAttractionCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TouristAttractionCategoryService {
  private final TouristAttractionCategoryRepository touristAttractionCategoryRepository;

  public TouristAttractionCategoryModel getById(Long id) throws EntityNotFoundException {
    Optional<TouristAttractionCategoryModel> searchedTouristAttractionCategory = this.touristAttractionCategoryRepository.findById(id);

    if(searchedTouristAttractionCategory.isEmpty()){
      String message = String.format("Não existe uma categoria de atração turística com o id: %s", id.toString());
      throw new EntityNotFoundException(message);
    }

    return searchedTouristAttractionCategory.get();
  }


}
