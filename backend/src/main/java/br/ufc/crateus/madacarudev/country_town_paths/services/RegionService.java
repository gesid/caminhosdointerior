package br.ufc.crateus.madacarudev.country_town_paths.services;

import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.CreateRegionDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.UpdateRegionDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.RegionOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.SampleCityOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.SampleRegionWithCitiesOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.models.CityModel;
import br.ufc.crateus.madacarudev.country_town_paths.models.RegionModel;
import br.ufc.crateus.madacarudev.country_town_paths.repositories.RegionRepository;
import br.ufc.crateus.madacarudev.country_town_paths.utils.CityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityConflictException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityNotFoundException;
import org.modelmapper.ModelMapper;

import java.util.*;

@Service
@RequiredArgsConstructor
public class RegionService {

  private final ModelMapper modelMapper;
  private final RegionRepository regionRepository;
  private final CityMapper cityMapper;

  public List<RegionOutputDto> getAllRegions() {
    List<RegionModel> regionModels = regionRepository.findAll();
    List<RegionOutputDto> regionOutputDtos = new ArrayList<RegionOutputDto>();

    for (RegionModel regionModel : regionModels) {
      RegionOutputDto regionOutputDto = modelMapper.map(regionModel, RegionOutputDto.class);
      regionOutputDtos.add(regionOutputDto);
    }

    return regionOutputDtos;
  }

  public List<SampleRegionWithCitiesOutputDto> getAllRegionsWithSampleRegions() {
    List<RegionModel> regionModels = regionRepository.findAll();
    List<SampleRegionWithCitiesOutputDto> regionOutputDtos = new ArrayList<SampleRegionWithCitiesOutputDto>();

    for (RegionModel regionModel : regionModels) {
      SampleRegionWithCitiesOutputDto regionOutputDto = modelMapper.map(regionModel, SampleRegionWithCitiesOutputDto.class);

      List<SampleCityOutputDto> cities = this.cityMapper.convertModelToSampleOutputDtoCollection(regionModel.getCities());
      regionOutputDto.setCities(cities);

      regionOutputDtos.add(regionOutputDto);
    }

    return regionOutputDtos;
  }


  public RegionOutputDto getRegionById(Long id) throws EntityNotFoundException {
    Optional<RegionModel> region = regionRepository.findById(id);

    if (region.isEmpty()) {
      String errorMessage = "Não existe região com o id: " + id + ".";
      throw new EntityNotFoundException(errorMessage);
    }

    return modelMapper.map(region, RegionOutputDto.class);
  }

  public RegionModel getRegionByName(String name) {
    return regionRepository.findByName(name).orElse(null);
  }

  public void create(CreateRegionDto input) throws EntityConflictException {
    RegionModel existingRegion = getRegionByName(input.getName());
    checkIfExistsOtherRegionSameName(existingRegion);

    RegionModel region = this.modelMapper.map(input, RegionModel.class);

    List<CityModel> cities = new ArrayList<CityModel>();
    region.setCities(cities);

    regionRepository.save(region);
  }

  public void update(Long id, UpdateRegionDto input) throws EntityNotFoundException {
    Optional<RegionModel> possibleExistingRegion = regionRepository.findById(id);

    if (possibleExistingRegion.isEmpty()) {
      String errorMessage = "Não existe região com o id: " + id + ".";
      throw new EntityNotFoundException(errorMessage);
    }

    RegionModel region = possibleExistingRegion.get();
    region.setName(input.getName());
  }


  public RegionModel getRegionModelById (Long id) throws EntityNotFoundException {
    Optional<RegionModel> regionModel = regionRepository.findById(id);

    if(regionModel.isEmpty()){
      String message = String.format("Não existe uma região cadastrada com id: %d", id);
      throw new EntityNotFoundException(message);
    }

    return regionModel.get();
  }

  public void deleteRegion(Long id) throws EntityNotFoundException {
    RegionModel region = this.getRegionModelById(id);
    regionRepository.delete(region);
  }

  private void checkIfExistsOtherRegionSameName (RegionModel existingRegion) throws EntityConflictException {
    if (Objects.nonNull(existingRegion)) {
      String errorMessage = "Já existe outra região com o nome: " + existingRegion.getName() + ".";
      throw new EntityConflictException(errorMessage);
    }
  }
}
