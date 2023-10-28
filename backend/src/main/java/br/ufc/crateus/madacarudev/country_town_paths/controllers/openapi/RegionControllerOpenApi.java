package br.ufc.crateus.madacarudev.country_town_paths.controllers.openapi;

import java.util.List;

import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.CityOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.SampleRegionWithCitiesOutputDto;
import org.springframework.http.ResponseEntity;

import br.ufc.crateus.madacarudev.country_town_paths.configs.SwaggerConfig;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.CreateRegionDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.UpdateRegionDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.InformativeMessageOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.RegionOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.BadRequestException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityConflictException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = { SwaggerConfig.REGION_TAG })
public interface RegionControllerOpenApi {

  @ApiOperation(value = "Retorna todas as regiões")
  public ResponseEntity<List<RegionOutputDto>> getAllRegions();

  @ApiOperation(value = "Retorna todas as regiões com lista simplificada de cidades")
  public ResponseEntity<List<SampleRegionWithCitiesOutputDto>> getAllSampleRegionsWithCities();

  @ApiOperation(value = "Retorna todas as cidades da região")
  public ResponseEntity<List<CityOutputDto>> getAllCities(Long id) throws EntityNotFoundException;

  @ApiOperation(value = "Busca uma região por id")
  public ResponseEntity<RegionOutputDto> getRegionById(Long id) throws EntityNotFoundException, BadRequestException;

  @ApiOperation(value = "Cria uma região")
  public ResponseEntity<InformativeMessageOutputDto> create(CreateRegionDto region)  throws EntityConflictException, BadRequestException;  
  
  @ApiOperation(value = "Atualiza uma região")
  public ResponseEntity<InformativeMessageOutputDto> update(UpdateRegionDto region, Long id) throws EntityNotFoundException, BadRequestException;

  @ApiOperation(value = "Deleta uma região")
  public ResponseEntity<Void> deleteRegion(Long id) throws BadRequestException, EntityNotFoundException;
}
