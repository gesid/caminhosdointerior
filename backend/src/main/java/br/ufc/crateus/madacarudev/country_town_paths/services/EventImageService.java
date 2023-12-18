package br.ufc.crateus.madacarudev.country_town_paths.services;

import br.ufc.crateus.madacarudev.country_town_paths.exceptions.BusinessException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityNotFoundException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.FileProcessingException;
import br.ufc.crateus.madacarudev.country_town_paths.models.EventImageModel;
import br.ufc.crateus.madacarudev.country_town_paths.models.EventModel;
import br.ufc.crateus.madacarudev.country_town_paths.repositories.EventImageRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventImageService {
  private final EventImageRepository eventImageRepository;
  private final LocalStorageService storageService;

  public EventImageModel getById(Long id) throws EntityNotFoundException {
    Optional<EventImageModel> searchedEventImage = this.eventImageRepository.findById(id);

    if(searchedEventImage.isEmpty()){
      String message = String.format("Não existe uma imagem de evento com id: %d", id);
      throw new EntityNotFoundException(message);
    }

    return searchedEventImage.get();
  }

  @Transactional
  public void saveAll(MultipartFile[] images, EventModel event) throws FileProcessingException {
    List<String> previewImageUrls = this.storePreviewImages(images);
    List<EventImageModel> eventImageModels = this.generatePreviewImageModels(previewImageUrls, event);

    this.eventImageRepository.saveAll(eventImageModels);
  }

  private List<String> storePreviewImages(MultipartFile[] previewImageFiles) throws FileProcessingException {
    List<String> previewImages = new ArrayList<String>();

    for (MultipartFile previewImage: previewImageFiles) {
      String url = this.storeImage(previewImage);
      previewImages.add(url);
    }

    return previewImages;
  }

  private List<EventImageModel> generatePreviewImageModels(List<String> previewImageUrls, EventModel event){
    List<EventImageModel> eventImages = new ArrayList<EventImageModel>();

    for (String previewImageUrl: previewImageUrls) {
      EventImageModel eventImage = new EventImageModel();

      eventImage.setUrl(previewImageUrl);
      eventImage.setEvent(event);

      eventImages.add(eventImage);
    }

    return eventImages;
  }

  public String storeImage(MultipartFile file) throws FileProcessingException {
    return this.storageService.save("events/images", file);
  }

  @Transactional
  public void deleteImage(
    Long imageId,
    EventModel event
  ) throws EntityNotFoundException, FileProcessingException, BusinessException {
    EventImageModel eventImage = this.getById(imageId);
    EventImageModel previewImage = this.getById(imageId);

    if(this.previewImageDoesntBelongsToEvent(previewImage, event)){
      throw new BusinessException("A imagem não pertence ao evento");
    }

    this.storageService.delete(eventImage.getUrl());
    this.eventImageRepository.delete(eventImage);
  }

  private boolean previewImageDoesntBelongsToEvent(EventImageModel previewImage, EventModel event){
    return !previewImage.getEvent().getId().equals(event.getId());
  }

  @Transactional
  public void deleteAllImageFiles(
    ArrayList<String> resourceUrls
  ) throws FileProcessingException {
    for (String resourceUrl: resourceUrls) {
      this.deleteImageFile(resourceUrl);
    }
  }

  @Transactional
  public void deleteImageFile(String resourceUrl) throws FileProcessingException {
    this.storageService.delete(resourceUrl);
  }
}
