package br.ufc.crateus.madacarudev.country_town_paths.controllers.openapi;

import br.ufc.crateus.madacarudev.country_town_paths.configs.SwaggerConfig;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.TouristAttractionsWithCategoriesOutputDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Api(tags = { SwaggerConfig.TOURIST_ATTRACTION_TAG })
public interface TouristAttractionControllerOpenApi {

  @ApiOperation(value = "Retorna todas as categorias de atrações turísticas junto com locais e eventos")
  public ResponseEntity<List<TouristAttractionsWithCategoriesOutputDto>> getAllSampleTouristAttractionCategory();

}
