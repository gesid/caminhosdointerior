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
    public ResponseEntity<List<CityOutputDto>> getAllCities() {
        List<CityOutputDto> cities = cityService.getAllCities();
        return ResponseEntity.ok(cities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityOutputDto> getCityById(@PathVariable UUID id) throws EntityNotFoundException{
        CityOutputDto city = cityService.getCityById(id);
        return ResponseEntity.ok(city);
    }
    @GetMapping("/{idRegion}")
    public ResponseEntity<List<CityOutputDto>> getCitiesByRegion(@PathVariable UUID idRegion) throws EntityNotFoundException{
        List<CityOutputDto> cities = cityService.getCitiesByRegion(idRegion);
        return ResponseEntity.ok(cities);
    }

    @PostMapping
    public ResponseEntity<InformativeMessageOutputDto> create(@Valid @RequestBody CreateCityDto city) throws EntityConflictException{
        cityService.create(city);
        InformativeMessageOutputDto message = new InformativeMessageOutputDto("Região criada com sucesso.");
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InformativeMessageOutputDto> update(@Valid @RequestBody UpdateCityDto city, @PathVariable UUID id) throws EntityNotFoundException{
        cityService.update(id, city);
        InformativeMessageOutputDto message = new InformativeMessageOutputDto("Região atualizada com sucesso.");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable UUID id) {
        cityService.deleteCity(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
