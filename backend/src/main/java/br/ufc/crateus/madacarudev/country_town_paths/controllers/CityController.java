package br.ufc.crateus.madacarudev.country_town_paths.controllers;

import java.util.List;

import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.ufc.crateus.madacarudev.country_town_paths.controllers.openapi.CityControllerOpenApi;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.CreateCityInputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.UpdateCityImageBannerInputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.UpdateCityInputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.InformativeMessageOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.CityOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.BusinessException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityConflictException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityNotFoundException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.FileProcessingException;
import br.ufc.crateus.madacarudev.country_town_paths.services.CityService;

@RestController
@RequestMapping("api/cities")
@RequiredArgsConstructor
public class CityController implements CityControllerOpenApi {
  private final CityService cityService;

  @GetMapping
  public ResponseEntity<List<CityOutputDto>> getAll() {
    List<CityOutputDto> cities = cityService.getAll();
    return ResponseEntity.ok(cities);
  }

  @GetMapping("/{id}")
  public ResponseEntity<CityOutputDto> getById(@PathVariable Long id) throws EntityNotFoundException {
    CityOutputDto city = cityService.getOutputDtoById(id);
    return ResponseEntity.ok(city);
  }

  @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
  public ResponseEntity<InformativeMessageOutputDto> create(
    @Valid @ModelAttribute CreateCityInputDto city
  ) throws EntityConflictException, EntityNotFoundException, FileProcessingException {
    cityService.create(city);

    InformativeMessageOutputDto message = new InformativeMessageOutputDto("Cidade criada com sucesso.");
    return ResponseEntity.status(HttpStatus.CREATED).body(message);
  }

  @PutMapping("/{id}")
  public ResponseEntity<InformativeMessageOutputDto> update(
    @Valid @RequestBody UpdateCityInputDto city,
    @PathVariable Long id
  ) throws EntityNotFoundException {
    cityService.update(id, city);

    InformativeMessageOutputDto message = new InformativeMessageOutputDto("Cidade atualizada com sucesso.");
    return ResponseEntity.status(HttpStatus.OK).body(message);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(
    @PathVariable Long id
  ) throws EntityNotFoundException, FileProcessingException {
    cityService.delete(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @PatchMapping("/{id}/banner-image")
  @Override
  public ResponseEntity<Void> updateBannerImage(
    @PathVariable("id") Long id,
    @Valid @ModelAttribute UpdateCityImageBannerInputDto bannerInputDto
  ) throws EntityNotFoundException, FileProcessingException {
    this.cityService.updateBannerImage(bannerInputDto, id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }


  @DeleteMapping("/{id}/preview-images/{imageId}")
  @Override
  public ResponseEntity<Void> deleteImageCity(
    @PathVariable("id") Long cityId,
    @PathVariable("imageId") Long imageId
  ) throws EntityNotFoundException, FileProcessingException, BusinessException {

    this.cityService.deleteImageCity(cityId, imageId);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
