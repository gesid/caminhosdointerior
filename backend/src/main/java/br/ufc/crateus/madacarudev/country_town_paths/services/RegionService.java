package br.ufc.crateus.madacarudev.country_town_paths.services;

import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.CreateRegionDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.UpdateRegionDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.RegionOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.models.CityModel;
import br.ufc.crateus.madacarudev.country_town_paths.models.RegionModel;
import br.ufc.crateus.madacarudev.country_town_paths.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityConflictException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityNotFoundException;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Objects;

@Service
public class RegionService {

    private final ModelMapper modelMapper;

    public RegionService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Autowired
    private RegionRepository regionRepository;

    public List<RegionOutputDto> getAllRegions() {
        List<RegionModel> regionsModel = regionRepository.findAll();
        List<RegionOutputDto> regionsOutputDto = new ArrayList<RegionOutputDto>();

        for (RegionModel regionModel : regionsModel) {
            regionsOutputDto.add(modelMapper.map(regionModel,RegionOutputDto.class));
        }

        return regionsOutputDto;
    }

    public RegionOutputDto getRegionById(UUID id) throws EntityNotFoundException {
        RegionModel regionModel = regionRepository.findById(id).orElse(null);

        if(Objects.isNull(regionModel)){
            String errorMessage = "Não existe região com o id: " + id;
            throw new EntityNotFoundException(errorMessage);
        }

        RegionOutputDto regionOutputDto = modelMapper.map(regionModel,RegionOutputDto.class);

        return regionOutputDto;
    }

    public RegionModel getRegionByName(String name) {
        return regionRepository.findByName(name).orElse(null);
    }

    public void create(CreateRegionDto region) throws EntityConflictException{
        RegionModel existingRegion = getRegionByName(region.getName());

        if(Objects.nonNull(existingRegion)){
            String errorMessage = "Já existe outra região com o nome: " + existingRegion.getName();
            throw new EntityConflictException(errorMessage);
        }
        UUID uuid = UUID.randomUUID();
        List<CityModel> cities = new ArrayList<CityModel>();
        RegionModel regionCreate = new RegionModel(uuid, region.getName(),cities);
        
        regionRepository.save(regionCreate);
    }

    public void update(UUID id, UpdateRegionDto region) throws EntityNotFoundException  {
        RegionModel existingRegion = regionRepository.findById(id).orElse(null);
        RegionModel updatedRegion = new RegionModel(region.getName());

        if (Objects.isNull(existingRegion)) {
            String errorMessage = "Não existe região com o id: " + id;
            throw new EntityNotFoundException(errorMessage);

        }
        existingRegion.setName(updatedRegion.getName());
        regionRepository.save(existingRegion);
    }

    public void deleteRegion(UUID id) {
        regionRepository.deleteById(id);
    }
}
