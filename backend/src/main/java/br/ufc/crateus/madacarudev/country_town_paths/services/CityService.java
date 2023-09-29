package br.ufc.crateus.madacarudev.country_town_paths.services;

import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.CreateCityDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.UpdateCityDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.CityOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.models.CityModel;
import br.ufc.crateus.madacarudev.country_town_paths.models.RegionModel;
import br.ufc.crateus.madacarudev.country_town_paths.models.TouristLocationModel;
import br.ufc.crateus.madacarudev.country_town_paths.repositories.CityRepository;
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
public class CityService {

    private final ModelMapper modelMapper;

    public CityService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private RegionService regionService;

    public List<CityOutputDto> getAll() {
        List<CityModel> citiesModel = cityRepository.findAll();
        List<CityOutputDto> citiesOutputDto = new ArrayList<CityOutputDto>();

        for (CityModel cityModel : citiesModel) {
            citiesOutputDto.add(modelMapper.map(cityModel,CityOutputDto.class));
        }

        return citiesOutputDto;
    }

    public List<CityOutputDto> getByRegion(UUID regionId) throws EntityNotFoundException{
        List<CityModel> cities = cityRepository.getByRegion(regionId).orElse(new ArrayList<>());
        List<CityOutputDto> citiesOutput = new ArrayList<CityOutputDto>();
        for (CityModel city : cities) {
            citiesOutput.add(modelMapper.map(city,CityOutputDto.class));
        }
        return citiesOutput;
    }
    
    public CityOutputDto getById(UUID id) throws EntityNotFoundException {
        CityModel cityModel = cityRepository.findById(id).orElse(null);
        checkIfNotExistisCityById(cityModel, id);

        CityOutputDto cityOutputDto = modelMapper.map(cityModel,CityOutputDto.class);

        return cityOutputDto;
    }

    public CityModel getByName(String name) {
        return cityRepository.findByName(name).orElse(null);
    }

    public void create(CreateCityDto city) throws EntityConflictException, EntityNotFoundException{
        UUID uuid = UUID.randomUUID();
        List<TouristLocationModel> location = new ArrayList<TouristLocationModel>();

        UUID regionId = city.getRegionId();

        RegionModel regionModel = regionService.getRegionModelById(regionId);

        if (Objects.isNull(regionModel)) {
            String errorMessage = "Não existe região com o id: " + regionId + ".";
            throw new EntityNotFoundException(errorMessage);
        }

        CityModel cityCreate = new CityModel(uuid, city.getName(), city.getImageBannerUrl(), city.getDescription(), regionModel, location);
        
        cityRepository.save(cityCreate);
    }

    public void update(UUID id, UpdateCityDto city) throws EntityNotFoundException{
        CityModel cityModel = cityRepository.findById(id).orElse(null);

        checkIfNotExistisCityById(cityModel, id);

        UUID regionId = city.getRegionId();

        RegionModel regionModel = regionService.getRegionModelById(regionId);

        if (Objects.isNull(regionModel)) {
            String errorMessage = "Não existe região com o id: " + regionId + ".";
            throw new EntityNotFoundException(errorMessage);
        }

        cityModel = modelMapper.map(city, CityModel.class);
        cityModel.setRegion(regionModel);

        cityRepository.save(cityModel);
    }

    public void delete(UUID id) {
        cityRepository.deleteById(id);
    }

    private void checkIfNotExistisCityById(CityModel existingCity,UUID id) throws EntityNotFoundException{
        if (Objects.isNull(existingCity)) {
            String errorMessage = "Não existe cidade com o id: " + id + ".";
            throw new EntityNotFoundException(errorMessage);
        }
    }
}
