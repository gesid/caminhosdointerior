package br.ufc.crateus.madacarudev.country_town_paths.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.ufc.crateus.madacarudev.country_town_paths.exceptions.BusinessException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityNotFoundException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.FileProcessingException;
import br.ufc.crateus.madacarudev.country_town_paths.models.CityImageModel;
import br.ufc.crateus.madacarudev.country_town_paths.models.CityModel;
import br.ufc.crateus.madacarudev.country_town_paths.repositories.CityImageRepository;


@Service
public class CityImageService {
  @Autowired
  private CityImageRepository cityImageRepository;

  @Autowired
  private LocalStorageService storageService;

  public String storeImage(MultipartFile image) throws FileProcessingException {
    return this.storageService.save("cities/images", image);
  }

  public CityImageModel getById(Long id) throws EntityNotFoundException {
    Optional<CityImageModel> searchedCityImage = this.cityImageRepository.findById(id);

    if (searchedCityImage.isEmpty()) {
      String message = String.format("Não existe uma imagem de cidade com id: %d", id);
      throw new EntityNotFoundException(message);
    }

    return searchedCityImage.get();
  }

  @Transactional
  public void saveAll(MultipartFile[] images, CityModel city) throws FileProcessingException {
    List<String> previewImageUrls = this.storePreviewImages(images);
    List<CityImageModel> cityImageModels = this.generatePreviewImageModels(previewImageUrls, city);

    this.cityImageRepository.saveAll(cityImageModels);
  }

  private List<String> storePreviewImages(MultipartFile[] previewImageFiles) throws FileProcessingException {
    List<String> previewImages = new ArrayList<String>();

    for (MultipartFile previewImage : previewImageFiles) {
      String url = this.storeImage(previewImage);
      previewImages.add(url);
    }

    return previewImages;
  }

  private List<CityImageModel> generatePreviewImageModels(List<String> previewImageUrls, CityModel city) {
    List<CityImageModel> cityImages = new ArrayList<CityImageModel>();

    for (String previewImageUrl : previewImageUrls) {
      CityImageModel cityImage = new CityImageModel();

      cityImage.setUrl(previewImageUrl);
      cityImage.setCity(city);

      cityImages.add(cityImage);
    }

    return cityImages;
  }

  @Transactional
  public void deleteImage(Long imageId, CityModel cityModel)
    throws EntityNotFoundException, FileProcessingException, BusinessException {
    CityImageModel cityImage = this.getById(imageId);
    CityImageModel previewImage = this.getById(imageId);

    if (this.previewImageDoesntBelongsToCity(previewImage, cityModel)) {
      throw new BusinessException("A imagem não pertence a cidade");
    }

    this.storageService.delete(cityImage.getUrl());
    this.cityImageRepository.delete(cityImage);
  }

  private boolean previewImageDoesntBelongsToCity(CityImageModel previewImage, CityModel city) {
    return !previewImage.getCity().getId().equals(city.getId());
  }

  @Transactional
  public void deleteImageFile(String resourceUrl) throws FileProcessingException {
    this.storageService.delete(resourceUrl);
  }

  @Transactional
  public void deleteAllImageFiles(
    ArrayList<String> resourceUrls
  ) throws FileProcessingException {
    for (String resourceUrl: resourceUrls) {
      this.deleteImageFile(resourceUrl);
    }
  }
}
