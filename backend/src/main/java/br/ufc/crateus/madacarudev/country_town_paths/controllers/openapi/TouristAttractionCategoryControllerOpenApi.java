package br.ufc.crateus.madacarudev.country_town_paths.controllers.openapi;

import br.ufc.crateus.madacarudev.country_town_paths.configs.SwaggerConfig;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.CreateTouristAttractionCategoryInputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.InformativeMessageOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.TouristAttractionCategoryOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityConflictException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.FileProcessingException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Api(tags = { SwaggerConfig.TOURIST_ATTRACTION_CATEGORY_TAG })
public interface TouristAttractionCategoryControllerOpenApi {

  @ApiOperation(value = "Retorna todas as categorias de atrações turísticas")
  public ResponseEntity<List<TouristAttractionCategoryOutputDto>> getAll();

  @ApiOperation(value = "Cria uma categoria de atração turística")
  public ResponseEntity<InformativeMessageOutputDto> create(
    CreateTouristAttractionCategoryInputDto input
  ) throws EntityConflictException, FileProcessingException;
}
