package br.ufc.crateus.madacarudev.country_town_paths.services;

import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.CreateCityInputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.UpdateCityImageBannerInputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.UpdateCityInputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.CityOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.DetailedCityOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.models.CityModel;
import br.ufc.crateus.madacarudev.country_town_paths.models.RegionModel;
import br.ufc.crateus.madacarudev.country_town_paths.models.TouristLocationModel;
import br.ufc.crateus.madacarudev.country_town_paths.repositories.CityRepository;
import br.ufc.crateus.madacarudev.country_town_paths.utils.CityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import br.ufc.crateus.madacarudev.country_town_paths.exceptions.BusinessException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityConflictException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityNotFoundException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.FileProcessingException;

import org.modelmapper.ModelMapper;

import java.util.*;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CityService {
  private final ModelMapper modelMapper;
  private final CityRepository cityRepository;
  private final RegionService regionService;
  private final CityImageService cityImageService;
  private final CityMapper cityMapper;

  public List<CityOutputDto> getAll() {
    List<CityModel> citiesModel = cityRepository.findAll();
    List<CityOutputDto> citiesOutputDto = new ArrayList<CityOutputDto>();

    for (CityModel cityModel : citiesModel) {
      citiesOutputDto.add(modelMapper.map(cityModel, CityOutputDto.class));
    }

    return citiesOutputDto;
  }

  public List<CityOutputDto> getByRegion(Long regionId) throws EntityNotFoundException {
    RegionModel regionModel = this.regionService.getRegionModelById(regionId);
    List<CityModel> cities = cityRepository.getCityModelByRegion(regionModel).orElse(new ArrayList<>());

    List<CityOutputDto> citiesOutput = new ArrayList<CityOutputDto>();

    for (CityModel city : cities) {
      citiesOutput.add(modelMapper.map(city, CityOutputDto.class));
    }

    return citiesOutput;
  }

  public DetailedCityOutputDto getDetailedById(Long id) throws EntityNotFoundException{
    CityModel city = this.getById(id);
    return this.cityMapper.convertModelToDetailedOutputDto(city);
  }

  public CityModel getById(Long id) throws EntityNotFoundException {
    Optional<CityModel> cityModel = cityRepository.findById(id);

    if (cityModel.isEmpty()) {
      String errorMessage = "Não existe uma cidade com o id: " + id + ".";
      throw new EntityNotFoundException(errorMessage);
    }

    return cityModel.get();
  }

  @Transactional
  public void create(CreateCityInputDto city) throws EntityConflictException, EntityNotFoundException, FileProcessingException {
    List<TouristLocationModel> location = new ArrayList<TouristLocationModel>();

    Long regionId = city.getRegionId();
    RegionModel regionModel = regionService.getRegionModelById(regionId);

    if (Objects.isNull(regionModel)) {
      String errorMessage = "Não existe região com o id: " + regionId + ".";
      throw new EntityNotFoundException(errorMessage);
    }

    CityModel cityCreate = modelMapper.map(city, CityModel.class);
    cityCreate.setId(null);
    cityCreate.setRegion(regionModel);
    cityCreate.setLocation(location);

    String imageBannerUrl = this.cityImageService.storeImage(city.getImageBanner());
    cityCreate.setImageBannerUrl(imageBannerUrl);

    CityModel cityCreated = cityRepository.save(cityCreate);
    cityImageService.saveAll(city.getImagesCity(), cityCreated);
  }

  @Transactional
  public void update(Long id, UpdateCityInputDto city) throws EntityNotFoundException {
    CityModel cityModel = this.getById(id);

    Long regionId = city.getRegionId();
    RegionModel regionModel = regionService.getRegionModelById(regionId);

    this.modelMapper.map(city, cityModel);

    cityModel.setRegion(regionModel);
    cityRepository.save(cityModel);
  }

  @Transactional
  public void delete(Long id) throws EntityNotFoundException, FileProcessingException {
    CityModel city = this.getById(id);
    ArrayList<String> relatedFileUrls = this.getAllRelatedFileUrls(city);

    this.cityRepository.deleteById(id);
    this.cityImageService.deleteAllImageFiles(relatedFileUrls);
  }

  private ArrayList<String> getAllRelatedFileUrls(CityModel city){
    ArrayList<String> relatedFileUrls = new ArrayList<String>();

    relatedFileUrls.add(city.getImageBannerUrl());
    city.getImagesCity().forEach((cityImage) -> relatedFileUrls.add(cityImage.getUrl()));

    return relatedFileUrls;
  }

  @Transactional
  public void updateBannerImage(
    UpdateCityImageBannerInputDto imageUpdate,
    Long id
  ) throws EntityNotFoundException, FileProcessingException {
    CityModel cityModel = this.getById(id);
    String storedImageUrl = this.cityImageService.storeImage(imageUpdate.getImage());

    try {
      this.cityImageService.deleteImageFile(cityModel.getImageBannerUrl());
    } catch (FileProcessingException exception) {
      this.cityImageService.deleteImageFile(storedImageUrl);
      throw exception;
    }

    cityModel.setImageBannerUrl(storedImageUrl);
    this.cityRepository.save(cityModel);
  }

  @Transactional
  public void deleteImageCity(
    Long cityId,
    Long imageId
  ) throws EntityNotFoundException, FileProcessingException, BusinessException {
    CityModel cityModel = this.getById(cityId);
    this.cityImageService.deleteImage(imageId, cityModel);
  }
}
