package br.ufc.crateus.madacarudev.country_town_paths.controllers.openapi;

import java.util.UUID;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.ufc.crateus.madacarudev.country_town_paths.configs.SwaggerConfig;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.CreateCityInputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.UpdateCityInputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.InformativeMessageOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.CityOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.BadRequestException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityConflictException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = { SwaggerConfig.CITY_TAG })
public interface CityControllerOpenApi {

  @ApiOperation(value = "Retorna todas as cidades")
  @GetMapping("/cities")
  public ResponseEntity<List<CityOutputDto>> getAll();

  @ApiOperation(value = "Busca uma cidade por id")
  @GetMapping("/cities/{id}")
  public ResponseEntity<CityOutputDto> getById(@PathVariable UUID id) throws EntityNotFoundException, BadRequestException;

  @ApiOperation(value = "Busca cidades de uma determinada região")
  @GetMapping("/cities/{id}")
  public ResponseEntity<List<CityOutputDto>> getByRegion(@PathVariable UUID idRegion) throws EntityNotFoundException, BadRequestException;

  @ApiOperation(value = "Cria uma cidade")
  @PostMapping("/cities")
  public ResponseEntity<InformativeMessageOutputDto> create(@RequestBody CreateCityInputDto city)  throws EntityConflictException, BadRequestException, EntityNotFoundException;  
  
  @ApiOperation(value = "Atualiza uma cidade")
  @PutMapping("/cities/{id}")
  public ResponseEntity<InformativeMessageOutputDto> update(@RequestBody UpdateCityInputDto city, @PathVariable UUID id) throws EntityNotFoundException, BadRequestException;

  @ApiOperation(value = "Deleta uma cidade")
  @DeleteMapping("/cities/{id}")
  public ResponseEntity<Void> delete(@PathVariable UUID id) throws BadRequestException;
}
