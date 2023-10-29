package br.ufc.crateus.madacarudev.country_town_paths.services;

import br.ufc.crateus.madacarudev.country_town_paths.exceptions.BusinessException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityNotFoundException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.FileProcessingException;
import br.ufc.crateus.madacarudev.country_town_paths.models.TouristLocationImageModel;
import br.ufc.crateus.madacarudev.country_town_paths.models.TouristLocationModel;
import br.ufc.crateus.madacarudev.country_town_paths.repositories.TouristLocationImageRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TouristLocationImageService {
  private final TouristLocationImageRepository touristLocationImageRepository;
  private final LocalStorageService storageService;

  public TouristLocationImageModel getById(Long id) throws EntityNotFoundException {
    Optional<TouristLocationImageModel> searchedTouristLocationImage = this.touristLocationImageRepository.findById(id);

    if(searchedTouristLocationImage.isEmpty()){
      String message = String.format("Não existe uma imagem de local turístico com id: %d", id);
      throw new EntityNotFoundException(message);
    }

    return searchedTouristLocationImage.get();
  }

  @Transactional
  public void saveAll(MultipartFile[] images, TouristLocationModel touristLocation) throws FileProcessingException {
    List<String> previewImageUrls = this.storePreviewImages(images);
    List<TouristLocationImageModel> touristLocationImageModels = this.generatePreviewImageModels(previewImageUrls, touristLocation);

    this.touristLocationImageRepository.saveAll(touristLocationImageModels);
  }

  private List<String> storePreviewImages(MultipartFile[] previewImageFiles) throws FileProcessingException {
    List<String> previewImages = new ArrayList<String>();

    for (MultipartFile previewImage: previewImageFiles) {
      String url = this.storeImage(previewImage);
      previewImages.add(url);
    }

    return previewImages;
  }

  private List<TouristLocationImageModel> generatePreviewImageModels(List<String> previewImageUrls, TouristLocationModel touristLocation){
    List<TouristLocationImageModel> touristLocationImages = new ArrayList<TouristLocationImageModel>();

    for (String previewImageUrl: previewImageUrls) {
      TouristLocationImageModel touristLocationImage = new TouristLocationImageModel();

      touristLocationImage.setUrl(previewImageUrl);
      touristLocationImage.setTouristLocation(touristLocation);

      touristLocationImages.add(touristLocationImage);
    }

    return touristLocationImages;
  }

  public String storeImage(MultipartFile file) throws FileProcessingException {
    return this.storageService.save("tourist-location/images", file);
  }

  @Transactional
  public void deleteImage(
    Long imageId,
    TouristLocationModel touristLocation
  ) throws EntityNotFoundException, FileProcessingException, BusinessException {
    TouristLocationImageModel touristLocationImage = this.getById(imageId);
    TouristLocationImageModel previewImage = this.getById(imageId);

    if(this.previewImageDoesntBelongsToTouristLocation(previewImage, touristLocation)){
      throw new BusinessException("A imagem não pertence ao local turístico");
    }

    this.storageService.delete(touristLocationImage.getUrl());
    this.touristLocationImageRepository.delete(touristLocationImage);
  }

  private boolean previewImageDoesntBelongsToTouristLocation(TouristLocationImageModel previewImage, TouristLocationModel touristLocation){
    return !previewImage.getTouristLocation().getId().equals(touristLocation.getId());
  }

  @Transactional
  public void deleteImageFile(String resourceUrl) throws FileProcessingException {
    this.storageService.delete(resourceUrl);
  }
}
