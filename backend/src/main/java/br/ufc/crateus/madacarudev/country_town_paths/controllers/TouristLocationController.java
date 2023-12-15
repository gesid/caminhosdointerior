package br.ufc.crateus.madacarudev.country_town_paths.controllers;

import br.ufc.crateus.madacarudev.country_town_paths.controllers.openapi.TouristLocationControllerOpenApi;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.CreateTouristLocationInputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.UpdateTouristLocationImageBannerInputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.UpdateTouristLocationInputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.DetailedTouristLocationOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.BusinessException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityNotFoundException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.FileProcessingException;
import br.ufc.crateus.madacarudev.country_town_paths.models.TouristLocationModel;
import br.ufc.crateus.madacarudev.country_town_paths.services.TouristLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;


@RestController
@RequestMapping("/api/tourist-locations")
@RequiredArgsConstructor
public class TouristLocationController implements TouristLocationControllerOpenApi{
  private final TouristLocationService TouristLocationService;
  
  @GetMapping("/{id}")
  @Override
  public ResponseEntity<DetailedTouristLocationOutputDto> getById(@PathVariable Long id) throws EntityNotFoundException {
    DetailedTouristLocationOutputDto touristLocation = this.TouristLocationService.getDetailedById(id);
     return ResponseEntity.ok(touristLocation);
  }
 
  @PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
  @Override
  public ResponseEntity<?> create(
    @Valid @ModelAttribute CreateTouristLocationInputDto input
  ) throws BusinessException, EntityNotFoundException, FileProcessingException {
    this.TouristLocationService.create(input);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PutMapping("/{id}")
  @Override
  public ResponseEntity<?> update(
    @PathVariable("id") Long id,
    @Valid @RequestBody UpdateTouristLocationInputDto input
  ) throws BusinessException, EntityNotFoundException {
    this.TouristLocationService.update(input, id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @PatchMapping("/{id}/banner-image")
  @Override
  public ResponseEntity<?> updateBannerImage(
    @PathVariable("id") Long id,
    @Valid @ModelAttribute UpdateTouristLocationImageBannerInputDto input
  ) throws EntityNotFoundException, FileProcessingException {

    this.TouristLocationService.updateBannerImage(input, id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }


  @DeleteMapping("/{id}/preview-images/{imageId}")
  @Override
  public ResponseEntity<?> deletePreviewImage(
    @PathVariable("id") Long eventId,
    @PathVariable("imageId") Long previewImageId
  ) throws EntityNotFoundException, FileProcessingException, BusinessException {

    this.TouristLocationService.deletePreviewImage(eventId, previewImageId);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
