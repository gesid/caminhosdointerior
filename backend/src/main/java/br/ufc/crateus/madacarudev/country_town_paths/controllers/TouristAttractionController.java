package br.ufc.crateus.madacarudev.country_town_paths.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.ufc.crateus.madacarudev.country_town_paths.controllers.openapi.TouristAttractionControllerOpenApi;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.TouristAttractionsWithCategoriesOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.services.TouristAttractionService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/tourist-attraction")
@RequiredArgsConstructor
public class TouristAttractionController implements TouristAttractionControllerOpenApi{
  private final TouristAttractionService touristAttractionService;

  @GetMapping("/tourist-attractions-with-categories")
  @Override
  public ResponseEntity<List<TouristAttractionsWithCategoriesOutputDto>> getAllSampleTouristAttractionCategory() {
    List<TouristAttractionsWithCategoriesOutputDto> touristAttractionWithCategory = 
    this.touristAttractionService.getAllSampleTouristAttractionCategory();

    return ResponseEntity.ok(touristAttractionWithCategory);
  }
}
