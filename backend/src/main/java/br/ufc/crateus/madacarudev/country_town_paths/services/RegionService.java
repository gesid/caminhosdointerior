package br.ufc.crateus.madacarudev.country_town_paths.services;

import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.CreateRegionDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.UpdateRegionDto;
import br.ufc.crateus.madacarudev.country_town_paths.models.RegionModel;
import br.ufc.crateus.madacarudev.country_town_paths.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;

    public List<RegionModel> getAllRegions() {
        return regionRepository.findAll();
    }

    public RegionModel getRegionById(UUID id) {
        return regionRepository.findById(id).orElse(null);
    }

    public RegionModel getRegionByName(String name) {
        return regionRepository.findByName(name).orElse(null);
    }

    public RegionModel createRegion(CreateRegionDto region) {
        RegionModel existingRegion = getRegionByName(region.getName());
        if(existingRegion == null){
            return null;
        }
        else{
            RegionModel createdRegion = new RegionModel(region.getName());
            return regionRepository.save(createdRegion);
        }
    }

    public RegionModel updateRegion(UUID id, UpdateRegionDto region) {
        RegionModel existingRegion = regionRepository.findById(id).orElse(null);
        RegionModel updatedRegion = new RegionModel(region.getName());
        if (existingRegion != null) {
            existingRegion.setName(updatedRegion.getName());
            return regionRepository.save(existingRegion);
        }
        return null;
    }

    public void deleteRegion(UUID id) {
        regionRepository.deleteById(id);
    }
}
