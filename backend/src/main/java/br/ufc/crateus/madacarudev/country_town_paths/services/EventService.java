package br.ufc.crateus.madacarudev.country_town_paths.services;

import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.CreateEventInputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.UpdateEventImageBannerInputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.UpdateEventInputDto;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.BusinessException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityNotFoundException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.FileProcessingException;
import br.ufc.crateus.madacarudev.country_town_paths.models.CityModel;
import br.ufc.crateus.madacarudev.country_town_paths.models.EventModel;
import br.ufc.crateus.madacarudev.country_town_paths.models.TouristAttractionCategoryModel;
import br.ufc.crateus.madacarudev.country_town_paths.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventService {
  private final CityService cityService;
  private final TouristAttractionCategoryService touristAttractionCategoryService;
  private final EventImageService eventImageService;

  private final ModelMapper modelMapper;
  private final EventRepository eventRepository;

  @Transactional
  public void create(CreateEventInputDto input)
    throws EntityNotFoundException, BusinessException, FileProcessingException {

    TouristAttractionCategoryModel touristAttractionCategory = this.touristAttractionCategoryService.getById(
      input.getTouristAttractionCategoryId()
    );

    CityModel city = this.cityService.getById(input.getCityId());

    this.checkEventPeriodValidity(input.getStartDate(), input.getEndDate());

    EventModel event = this.modelMapper.map(input, EventModel.class);
    event.setId(null);
    event.setCity(city);
    event.setTouristAttractionCategory(touristAttractionCategory);

    String bannerImageUrl = this.eventImageService.storeImage(input.getBannerImage());
    event.setBannerImage(bannerImageUrl);

    EventModel createdEvent = this.eventRepository.save(event);
    this.eventImageService.saveAll(input.getPreviewImages(), createdEvent);
  }

  @Transactional
  public void update(UpdateEventInputDto input, Long id) throws EntityNotFoundException, BusinessException {
    EventModel event = this.getById(id);

    this.checkEventPeriodValidity(input.getStartDate(), input.getEndDate());

    TouristAttractionCategoryModel touristAttractionCategory = this.touristAttractionCategoryService.getById(
      input.getTouristAttractionCategoryId()
    );
    CityModel city = this.cityService.getById(input.getCityId());

    event.setTouristAttractionCategory(touristAttractionCategory);
    event.setCity(city);

    this.modelMapper.map(input, event);
    this.eventRepository.save(event);
  }

  @Transactional
  public void updateBannerImage(
    UpdateEventImageBannerInputDto input,
    Long id
  ) throws EntityNotFoundException, FileProcessingException {
    EventModel event = this.getById(id);
    String storedImageUrl = this.eventImageService.storeImage(input.getImage());

    try{
      this.eventImageService.deleteImageFile(event.getBannerImage());
    }catch (FileProcessingException exception){
      this.eventImageService.deleteImageFile(storedImageUrl);
      throw exception;
    }

    event.setBannerImage(storedImageUrl);
    this.eventRepository.save(event);
  }

  public EventModel getById(Long id) throws EntityNotFoundException {
    Optional<EventModel> searchedEvent = this.eventRepository.findById(id);

    if(searchedEvent.isEmpty()){
      String message = String.format("Não existe um evento com ID : %d", id);
      throw new EntityNotFoundException(message);
    }

    return searchedEvent.get();
  }

  private void checkEventPeriodValidity(
    LocalDateTime startDate,
    LocalDateTime finalDate
  ) throws BusinessException {

    if(startDate.isAfter(finalDate)){
      throw new BusinessException("A data de término do evento não pode ser anterior a data inicial");
    }

  }

  @Transactional
  public void deletePreviewImage(
    Long eventId,
    Long previewImageId
  ) throws EntityNotFoundException, FileProcessingException, BusinessException {
    EventModel event = this.getById(eventId);
    this.eventImageService.deleteImage(previewImageId, event);
  }
}
