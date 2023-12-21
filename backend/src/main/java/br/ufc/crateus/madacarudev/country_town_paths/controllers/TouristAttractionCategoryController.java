package br.ufc.crateus.madacarudev.country_town_paths.controllers;

import br.ufc.crateus.madacarudev.country_town_paths.controllers.openapi.TouristAttractionCategoryControllerOpenApi;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.CreateTouristAttractionCategoryInputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.InformativeMessageOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.TouristAttractionCategoryOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityConflictException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.FileProcessingException;
import br.ufc.crateus.madacarudev.country_town_paths.services.TouristAttractionCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tourist-attraction-categories")
@RequiredArgsConstructor
public class TouristAttractionCategoryController implements TouristAttractionCategoryControllerOpenApi {
  private final TouristAttractionCategoryService touristAttractionCategoryService;

  @GetMapping
  public ResponseEntity<List<TouristAttractionCategoryOutputDto>> getAll(){
    List<TouristAttractionCategoryOutputDto> touristAttractionCategoryOutputDtoList
      = this.touristAttractionCategoryService.getAll();

    return ResponseEntity.ok(touristAttractionCategoryOutputDtoList);
  }

  @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
  public ResponseEntity<InformativeMessageOutputDto> create(
    @Valid @ModelAttribute CreateTouristAttractionCategoryInputDto input
  ) throws EntityConflictException, FileProcessingException {
    this.touristAttractionCategoryService.create(input);

    InformativeMessageOutputDto messageOutputDto = new InformativeMessageOutputDto("Categoria de atração turística cadastrada com sucesso");
    return ResponseEntity.status(HttpStatus.CREATED).body(messageOutputDto);
  }
}
