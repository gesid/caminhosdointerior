package br.ufc.crateus.madacarudev.country_town_paths.controllers;

import java.util.List;

import javax.validation.Valid;

import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.CityOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.SampleRegionWithCitiesOutputDto;
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
  @Override
  public ResponseEntity<List<RegionOutputDto>> getAllRegions() {
    List<RegionOutputDto> regions = regionService.getAllRegions();
    return ResponseEntity.ok(regions);
  }

  @GetMapping("/cities")
  @Override
  public ResponseEntity<List<SampleRegionWithCitiesOutputDto>> getAllSampleRegionsWithCities() {
    List<SampleRegionWithCitiesOutputDto> regionsWithCities = this.regionService.getAllRegionsWithSampleRegions();
    return ResponseEntity.ok(regionsWithCities);
  }

  @GetMapping("/{id}")
  @Override
  public ResponseEntity<RegionOutputDto> getRegionById(@PathVariable Long id) throws EntityNotFoundException {
    RegionOutputDto region = regionService.getRegionById(id);
    return ResponseEntity.ok(region);
  }

  @GetMapping("/{id}/cities")
  @Override
  public ResponseEntity<List<CityOutputDto>> getAllCities(@PathVariable Long id) throws EntityNotFoundException {
    List<CityOutputDto> cities = this.cityService.getByRegion(id);
    return ResponseEntity.ok(cities);
  }

  @PostMapping
  @Override
  public ResponseEntity<InformativeMessageOutputDto> create(
    @Valid @RequestBody CreateRegionDto region
  ) throws EntityConflictException {
    regionService.create(region);
    InformativeMessageOutputDto message = new InformativeMessageOutputDto("Região criada com sucesso.");
    return ResponseEntity.status(HttpStatus.CREATED).body(message);
  }

  @PutMapping("/{id}")
  @Override
  public ResponseEntity<InformativeMessageOutputDto> update(
    @Valid @RequestBody UpdateRegionDto region,
    @PathVariable Long id
  ) throws EntityNotFoundException {
    regionService.update(id, region);
    InformativeMessageOutputDto message = new InformativeMessageOutputDto("Região atualizada com sucesso.");
    return new ResponseEntity<>(message, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  @Override
  public ResponseEntity<Void> deleteRegion(@PathVariable Long id) throws EntityNotFoundException {
    regionService.deleteRegion(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
