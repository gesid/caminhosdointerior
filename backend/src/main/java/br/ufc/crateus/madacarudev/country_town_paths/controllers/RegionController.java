package br.ufc.crateus.madacarudev.country_town_paths.controllers;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.ufc.crateus.madacarudev.country_town_paths.controllers.openapi.RegionControllerOpenApi;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.CreateRegionDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.UpdateRegionDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.InformativeMessageOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.RegionOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.BadRequestException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityConflictException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityNotFoundException;
import br.ufc.crateus.madacarudev.country_town_paths.services.RegionService;

@RestController
@RequestMapping("api/regions")
public class RegionController implements RegionControllerOpenApi {
    @Autowired
    private RegionService regionService;

    @GetMapping
    public ResponseEntity<List<RegionOutputDto>> getAllRegions() {
        List<RegionOutputDto> regions = regionService.getAllRegions();
        return new ResponseEntity<>(regions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegionOutputDto> getRegionById(@PathVariable UUID id) throws EntityNotFoundException, BadRequestException{
        RegionOutputDto region = regionService.getRegionById(id);
        return ResponseEntity.ok(region);
    }

    @PostMapping
    public ResponseEntity<InformativeMessageOutputDto> create(@RequestBody CreateRegionDto region) throws EntityConflictException, BadRequestException{
        regionService.create(region);
        InformativeMessageOutputDto message = new InformativeMessageOutputDto("Região criada com sucesso.");
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InformativeMessageOutputDto> update(@PathVariable UUID id, @RequestBody UpdateRegionDto region) throws EntityNotFoundException, BadRequestException{
        regionService.update(id, region);
        InformativeMessageOutputDto message = new InformativeMessageOutputDto("Região atualizada com sucesso.");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegion(@PathVariable UUID id) throws BadRequestException {
        regionService.deleteRegion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
