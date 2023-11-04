package br.ufc.crateus.madacarudev.country_town_paths.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.ufc.crateus.madacarudev.country_town_paths.controllers.openapi.TouristAttractionControllerOpenApi;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.SampleTouristAttractionCategoryWithEventsAndLocationOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.services.TouristAttractionCategoryService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/tourist-attraction")
@RequiredArgsConstructor
public class TouristAttractionController implements TouristAttractionControllerOpenApi{
  private final TouristAttractionCategoryService touristAttractionCategoryService;

  @GetMapping("/tourist-attractions-with-categories")
  @Override
  public ResponseEntity<List<SampleTouristAttractionCategoryWithEventsAndLocationOutputDto>> getAllSampleTouristAttractionCategory() {
    List<SampleTouristAttractionCategoryWithEventsAndLocationOutputDto> touristAttractionWithCategory = 
    this.touristAttractionCategoryService.getAllSampleTouristAttractionCategory();

    return ResponseEntity.ok(touristAttractionWithCategory);
  }
}
