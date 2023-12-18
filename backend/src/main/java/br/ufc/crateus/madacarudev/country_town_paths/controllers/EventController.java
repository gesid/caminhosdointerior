package br.ufc.crateus.madacarudev.country_town_paths.controllers;

import br.ufc.crateus.madacarudev.country_town_paths.controllers.openapi.EventControllerOpenApi;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.CreateEventInputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.UpdateEventImageBannerInputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.UpdateEventInputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.DetailedEventOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.SampleEventOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.BusinessException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityNotFoundException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.FileProcessingException;
import br.ufc.crateus.madacarudev.country_town_paths.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController implements EventControllerOpenApi{
  private final EventService eventService;

  @Override
  @GetMapping
  public ResponseEntity<List<SampleEventOutputDto>> getAll() throws EntityNotFoundException {
   var output = this.eventService.getAll();
   return ResponseEntity.ok(output);
  }

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<DetailedEventOutputDto> getById(Long id) throws EntityNotFoundException {
    var output = this.eventService.getDetailedById(id);
    return ResponseEntity.ok(output);
  }

  @PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
  @Override
  public ResponseEntity<?> create(
    @Valid @ModelAttribute CreateEventInputDto input
  ) throws BusinessException, EntityNotFoundException, FileProcessingException {
    this.eventService.create(input);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PutMapping("/{id}")
  @Override
  public ResponseEntity<?> update(
    @PathVariable("id") Long id,
    @Valid @RequestBody UpdateEventInputDto input
  ) throws BusinessException, EntityNotFoundException {
    this.eventService.update(input, id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @PatchMapping("/{id}/banner-image")
  @Override
  public ResponseEntity<?> updateBannerImage(
    @PathVariable("id") Long id,
    @Valid @ModelAttribute UpdateEventImageBannerInputDto input
  ) throws EntityNotFoundException, FileProcessingException {

    this.eventService.updateBannerImage(input, id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }


  @DeleteMapping("/{id}/preview-images/{imageId}")
  @Override
  public ResponseEntity<?> deletePreviewImage(
    @PathVariable("id") Long eventId,
    @PathVariable("imageId") Long previewImageId
  ) throws EntityNotFoundException, FileProcessingException, BusinessException {

    this.eventService.deletePreviewImage(eventId, previewImageId);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @Override
  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable  Long id) throws EntityNotFoundException {
    var output = this.eventService.getDetailedById(id);
    return ResponseEntity.ok(output);
  }
}
