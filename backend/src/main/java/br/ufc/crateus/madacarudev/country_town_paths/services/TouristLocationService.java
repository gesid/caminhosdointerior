package br.ufc.crateus.madacarudev.country_town_paths.services;

import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.CreateTouristLocationInputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.UpdateTouristLocationImageBannerInputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.UpdateTouristLocationInputDto;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.BusinessException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityNotFoundException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.FileProcessingException;
import br.ufc.crateus.madacarudev.country_town_paths.models.CityModel;
import br.ufc.crateus.madacarudev.country_town_paths.models.TouristAttractionCategoryModel;
import br.ufc.crateus.madacarudev.country_town_paths.models.TouristLocationModel;
import br.ufc.crateus.madacarudev.country_town_paths.repositories.TouristLocationRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TouristLocationService {
  private final CityService cityService;
  private final TouristAttractionCategoryService touristAttractionCategoryService;
  private final TouristLocationImageService touristLocationImageService;

  private final ModelMapper modelMapper;
  private final TouristLocationRepository touristLocationRepository;

  @Transactional
  public void create(CreateTouristLocationInputDto input)
    throws EntityNotFoundException, BusinessException, FileProcessingException {

    TouristAttractionCategoryModel touristAttractionCategory = this.touristAttractionCategoryService.getById(
      input.getTouristAttractionCategoryId()
    );

    CityModel city = this.cityService.getById(input.getCityId());

    TouristLocationModel touristAttraction = this.modelMapper.map(input, TouristLocationModel.class);
    touristAttraction.setId(null);
    touristAttraction.setCity(city);
    touristAttraction.setTouristAttractionCategory(touristAttractionCategory);

    String bannerImageUrl = this.touristLocationImageService.storeImage(input.getBannerImage());
    touristAttraction.setBannerImage(bannerImageUrl);

    TouristLocationModel createdTouristAttraction = this.touristLocationRepository.save(touristAttraction);
    this.touristLocationImageService.saveAll(input.getPreviewImages(), createdTouristAttraction);
  }

  @Transactional
  public void update(UpdateTouristLocationInputDto input, Long id) throws EntityNotFoundException, BusinessException {
    TouristLocationModel touristLocationModel = this.getById(id);

    TouristAttractionCategoryModel touristAttractionCategory = this.touristAttractionCategoryService.getById(
      input.getTouristAttractionCategoryId()
    );
    CityModel city = this.cityService.getById(input.getCityId());

    touristLocationModel.setTouristAttractionCategory(touristAttractionCategory);
    touristLocationModel.setCity(city);

    this.modelMapper.map(input, touristLocationModel);
    this.touristLocationRepository.save(touristLocationModel);
  }

  @Transactional
  public void updateBannerImage(
    UpdateTouristLocationImageBannerInputDto input,
    Long id
  ) throws EntityNotFoundException, FileProcessingException {
    TouristLocationModel touristLocationModel = this.getById(id);
    String storedImageUrl = this.touristLocationImageService.storeImage(input.getImage());

    try{
      this.touristLocationImageService.deleteImageFile(touristLocationModel.getBannerImage());
    }catch (FileProcessingException exception){
      this.touristLocationImageService.deleteImageFile(storedImageUrl);
      throw exception;
    }

    touristLocationModel.setBannerImage(storedImageUrl);
    this.touristLocationRepository.save(touristLocationModel);
  }

  public TouristLocationModel getById(Long id) throws EntityNotFoundException {
    Optional<TouristLocationModel> searchedTouristLocation = this.touristLocationRepository.findById(id);

    if(searchedTouristLocation.isEmpty()){
      String message = String.format("Não existe um local turístico com ID : %d", id);
      throw new EntityNotFoundException(message);
    }

    return searchedTouristLocation.get();
  }

  @Transactional
  public void deletePreviewImage(
    Long touristLocationId,
    Long previewImageId
  ) throws EntityNotFoundException, FileProcessingException, BusinessException {
    TouristLocationModel touristLocation = this.getById(touristLocationId);
    this.touristLocationImageService.deleteImage(previewImageId, touristLocation);
  }
}
