package br.ufc.crateus.madacarudev.country_town_paths.controllers;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.CreateRegionDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.UpdateRegionDto;
import br.ufc.crateus.madacarudev.country_town_paths.models.RegionModel;
import br.ufc.crateus.madacarudev.country_town_paths.services.RegionService;

@RestController
@RequestMapping("/regions")
public class RegionController {
    @Autowired
    private RegionService regionService;

    @GetMapping
    public ResponseEntity<List<RegionModel>> getAllRegions() {
        List<RegionModel> regions = regionService.getAllRegions();
        return new ResponseEntity<>(regions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegionModel> getRegionById(@PathVariable UUID id) {
        RegionModel region = regionService.getRegionById(id);
        if (region != null) {
            return new ResponseEntity<>(region, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<RegionModel> createRegion(@RequestBody CreateRegionDto region) {
        RegionModel createdRegion = regionService.createRegion(region);
        if(createdRegion == null){
            return new ResponseEntity<>(createdRegion, HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<>(createdRegion, HttpStatus.CREATED);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegionModel> updateRegion(@PathVariable UUID id, @RequestBody UpdateRegionDto region) {
        RegionModel updatedRegion = regionService.updateRegion(id, region);
        if (updatedRegion != null) {
            return new ResponseEntity<>(updatedRegion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegion(@PathVariable UUID id) {
        regionService.deleteRegion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
