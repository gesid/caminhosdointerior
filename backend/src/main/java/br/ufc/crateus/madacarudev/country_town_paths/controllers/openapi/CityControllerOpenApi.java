package br.ufc.crateus.madacarudev.country_town_paths.controllers.openapi;

import java.util.UUID;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.ufc.crateus.madacarudev.country_town_paths.configs.SwaggerConfig;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.CreateCityDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.UpdateCityDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.InformativeMessageOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.CityOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.BadRequestException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityConflictException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = { SwaggerConfig.REGION_TAG })
public interface CityControllerOpenApi {

  @ApiOperation(value = "Retorna todas as cidades")
  @GetMapping("/cities")
  public ResponseEntity<List<CityOutputDto>> getAllCities();

  @ApiOperation(value = "Busca uma cidade por id")
  @GetMapping("/cities/{id}")
  public ResponseEntity<CityOutputDto> getCityById(@PathVariable UUID id) throws EntityNotFoundException, BadRequestException;

  @ApiOperation(value = "Busca cidades de uma determinada região")
  @GetMapping("/cities/{id}")
  public ResponseEntity<List<CityOutputDto>> getCitiesByRegion(@PathVariable UUID idRegion) throws EntityNotFoundException, BadRequestException;

  @ApiOperation(value = "Cria uma cidade")
  @PostMapping("/cities")
  public ResponseEntity<InformativeMessageOutputDto> create(@RequestBody CreateCityDto city)  throws EntityConflictException, BadRequestException;  
  
  @ApiOperation(value = "Atualiza uma cidade")
  @PutMapping("/cities/{id}")
  public ResponseEntity<InformativeMessageOutputDto> update(@RequestBody UpdateCityDto city, @PathVariable UUID id) throws EntityNotFoundException, BadRequestException;

  @ApiOperation(value = "Deleta uma cidade")
  @DeleteMapping("/cities/{id}")
  public ResponseEntity<Void> deleteCity(@PathVariable UUID id) throws BadRequestException;
}
