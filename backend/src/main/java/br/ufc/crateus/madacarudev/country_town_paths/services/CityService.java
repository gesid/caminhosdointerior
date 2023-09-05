package br.ufc.crateus.madacarudev.country_town_paths.services;

import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.CreateCityDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.UpdateCityDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.CityOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.models.CityModel;
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

    public List<CityOutputDto> getAllCities() {
        List<CityModel> citiesModel = cityRepository.findAll();
        List<CityOutputDto> citiesOutputDto = new ArrayList<CityOutputDto>();

        for (CityModel cityModel : citiesModel) {
            citiesOutputDto.add(modelMapper.map(cityModel,CityOutputDto.class));
        }

        return citiesOutputDto;
    }

    public List<CityOutputDto> getCitiesByRegion(UUID idRegion) throws EntityNotFoundException{
        List<CityModel> cities = cityRepository.getByRegion(idRegion).orElse(new ArrayList<>());
        List<CityOutputDto> citiesOutput = new ArrayList<CityOutputDto>();
        for (CityModel city : cities) {
            citiesOutput.add(modelMapper.map(city,CityOutputDto.class));
        }
        return citiesOutput;
    }
    
    public CityOutputDto getCityById(UUID id) throws EntityNotFoundException {
        CityModel cityModel = cityRepository.findById(id).orElse(null);
        checkIfNotExistisCityById(cityModel, id);

        CityOutputDto cityOutputDto = modelMapper.map(cityModel,CityOutputDto.class);

        return cityOutputDto;
    }

    public CityModel getCityByName(String name) {
        return cityRepository.findByName(name).orElse(null);
    }

    public void create(CreateCityDto city) throws EntityConflictException{

        UUID uuid = UUID.randomUUID();
        List<TouristLocationModel> location = new ArrayList<TouristLocationModel>();
        CityModel cityCreate = new CityModel(uuid, city.getName(), city.getImageBannerUrl(), city.getDescription(), city.getRegion(), location);
        
        cityRepository.save(cityCreate);
    }

    public void update(UUID id, UpdateCityDto city) throws EntityNotFoundException{
        CityModel cityModel = cityRepository.findById(id).orElse(null);
        CityModel updatedCity = new CityModel(city.getName(), city.getImageBannerUrl(), city.getDescription(), city.getRegion());

        checkIfNotExistisCityById(cityModel, id);
        
        cityModel.setName(updatedCity.getName());
        cityModel.setDescription(updatedCity.getDescription());
        cityModel.setImageBannerUrl(updatedCity.getImageBannerUrl());
        cityModel.setRegion(updatedCity.getRegion());

        cityRepository.save(cityModel);
    }

    public void deleteCity(UUID id) {
        cityRepository.deleteById(id);
    }

    private void checkIfNotExistisCityById(CityModel existingCity,UUID id) throws EntityNotFoundException{
        if (Objects.isNull(existingCity)) {
            String errorMessage = "Não existe região com o id: " + id + ".";
            throw new EntityNotFoundException(errorMessage);
        }
    }
}
