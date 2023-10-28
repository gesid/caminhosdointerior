package br.ufc.crateus.madacarudev.country_town_paths.controllers;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.CityOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.services.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.ufc.crateus.madacarudev.country_town_paths.controllers.openapi.RegionControllerOpenApi;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.CreateRegionDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.UpdateRegionDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.InformativeMessageOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.RegionOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityConflictException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityNotFoundException;
import br.ufc.crateus.madacarudev.country_town_paths.services.RegionService;

@RestController
@RequestMapping("api/regions")
@RequiredArgsConstructor
public class RegionController implements RegionControllerOpenApi {
  private final RegionService regionService;
  private final CityService cityService;

  @GetMapping
  public ResponseEntity<List<RegionOutputDto>> getAllRegions() {
    List<RegionOutputDto> regions = regionService.getAllRegions();
    return new ResponseEntity<>(regions, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<RegionOutputDto> getRegionById(@PathVariable UUID id) throws EntityNotFoundException {
    RegionOutputDto region = regionService.getRegionById(id);
    return ResponseEntity.ok(region);
  }

  @GetMapping("/{id}/cities")
  @Override
  public ResponseEntity<List<CityOutputDto>> getAllCities(@PathVariable UUID id) throws EntityNotFoundException {
    List<CityOutputDto> cities = this.cityService.getByRegion(id);
    return ResponseEntity.ok(cities);
  }

  @PostMapping
  public ResponseEntity<InformativeMessageOutputDto> create(@Valid @RequestBody CreateRegionDto region) throws EntityConflictException {
    regionService.create(region);
    InformativeMessageOutputDto message = new InformativeMessageOutputDto("Região criada com sucesso.");
    return ResponseEntity.status(HttpStatus.CREATED).body(message);
  }

  @PutMapping("/{id}")
  public ResponseEntity<InformativeMessageOutputDto> update(@Valid @RequestBody UpdateRegionDto region, @PathVariable UUID id) throws EntityNotFoundException {
    regionService.update(id, region);
    InformativeMessageOutputDto message = new InformativeMessageOutputDto("Região atualizada com sucesso.");
    return new ResponseEntity<>(message, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteRegion(@PathVariable UUID id) {
    regionService.deleteRegion(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
