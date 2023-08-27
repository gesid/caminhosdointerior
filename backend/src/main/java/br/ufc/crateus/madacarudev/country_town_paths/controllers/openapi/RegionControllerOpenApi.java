package br.ufc.crateus.madacarudev.country_town_paths.controllers.openapi;

import java.util.UUID;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
  @GetMapping("/regions")
  public ResponseEntity<List<RegionOutputDto>> getAllRegions();

  @ApiOperation(value = "Busca uma região por id")
  @GetMapping("/regions/{id}")
  public ResponseEntity<RegionOutputDto> getRegionById(@PathVariable UUID id) throws EntityNotFoundException, BadRequestException;

  @ApiOperation(value = "Cria uma região")
  @PostMapping("/regions")
  public ResponseEntity<InformativeMessageOutputDto> create(@RequestBody CreateRegionDto region)  throws EntityConflictException, BadRequestException;  
  
  @ApiOperation(value = "Atualiza uma região")
  @PutMapping("/regions/{id}")
  public ResponseEntity<InformativeMessageOutputDto> update(@RequestBody UpdateRegionDto region, @PathVariable UUID id) throws EntityNotFoundException, BadRequestException;

  @ApiOperation(value = "Deleta uma região")
  @DeleteMapping("/regions/{id}")
  public ResponseEntity<Void> deleteRegion(@PathVariable UUID id) throws BadRequestException;
}
