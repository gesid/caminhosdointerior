package br.ufc.crateus.madacarudev.country_town_paths.services;

import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.CreateRegionDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.UpdateRegionDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.RegionOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.models.CityModel;
import br.ufc.crateus.madacarudev.country_town_paths.models.RegionModel;
import br.ufc.crateus.madacarudev.country_town_paths.repositories.RegionRepository;
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


  public List<RegionOutputDto> getAllRegions() {
    List<RegionModel> regionsModel = regionRepository.findAll();
    List<RegionOutputDto> regionsOutputDto = new ArrayList<RegionOutputDto>();

    for (RegionModel regionModel : regionsModel) {
      regionsOutputDto.add(modelMapper.map(regionModel, RegionOutputDto.class));
    }

    return regionsOutputDto;
  }

  public RegionOutputDto getRegionById(Long id) throws EntityNotFoundException {
    Optional<RegionModel> region = regionRepository.findById(id);

    if(region.isEmpty()){
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

    if(possibleExistingRegion.isEmpty()){
      String errorMessage = "Não existe região com o id: " + id + ".";
      throw new EntityNotFoundException(errorMessage);
    }

    RegionModel region = possibleExistingRegion.get();
    region.setName(input.getName());

    regionRepository.save(region);
  }

  public void deleteRegion(Long id) {
    regionRepository.deleteById(id);
  }

  private void checkIfExistsOtherRegionSameName(RegionModel existingRegion) throws EntityConflictException {
    if (Objects.nonNull(existingRegion)) {
      String errorMessage = "Já existe outra região com o nome: " + existingRegion.getName() + ".";
      throw new EntityConflictException(errorMessage);
    }
  }
}
