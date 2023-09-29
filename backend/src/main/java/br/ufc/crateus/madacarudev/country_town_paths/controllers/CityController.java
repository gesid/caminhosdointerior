package br.ufc.crateus.madacarudev.country_town_paths.controllers;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.ufc.crateus.madacarudev.country_town_paths.controllers.openapi.CityControllerOpenApi;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.CreateCityDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.UpdateCityDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.InformativeMessageOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.CityOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityConflictException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityNotFoundException;
import br.ufc.crateus.madacarudev.country_town_paths.services.CityService;

@RestController
@RequestMapping("api/cities")
public class CityController implements CityControllerOpenApi {
    @Autowired
    private CityService cityService;

    @GetMapping
    public ResponseEntity<List<CityOutputDto>> getAll() {
        List<CityOutputDto> cities = cityService.getAll();
        return ResponseEntity.ok(cities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityOutputDto> getById(@PathVariable UUID id) throws EntityNotFoundException{
        CityOutputDto city = cityService.getById(id);
        return ResponseEntity.ok(city);
    }

    @GetMapping("/{regionId}")
    public ResponseEntity<List<CityOutputDto>> getByRegion(@PathVariable UUID regionId) throws EntityNotFoundException{
        List<CityOutputDto> cities = cityService.getByRegion(regionId);
        return ResponseEntity.ok(cities);
    }

    @PostMapping
    public ResponseEntity<InformativeMessageOutputDto> create(@Valid @RequestBody CreateCityDto city) throws EntityConflictException, EntityNotFoundException{
        cityService.create(city);
        InformativeMessageOutputDto message = new InformativeMessageOutputDto("Cidade criada com sucesso.");
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InformativeMessageOutputDto> update(@Valid @RequestBody UpdateCityDto city, @PathVariable UUID id) throws EntityNotFoundException{
        cityService.update(id, city);
        InformativeMessageOutputDto message = new InformativeMessageOutputDto("Cidade atualizada com sucesso.");
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        cityService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
