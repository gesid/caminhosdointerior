package br.ufc.crateus.madacarudev.country_town_paths.controllers.openapi;

import java.util.UUID;

import javax.validation.Valid;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.ufc.crateus.madacarudev.country_town_paths.configs.SwaggerConfig;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.CreateCityInputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.UpdateCityImageBannerInputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.UpdateCityInputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.InformativeMessageOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.CityOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.BadRequestException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.BusinessException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityConflictException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityNotFoundException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.FileProcessingException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = { SwaggerConfig.CITY_TAG })
public interface CityControllerOpenApi {

  @ApiOperation(value = "Retorna todas as cidades")
  @GetMapping("/cities")
  public ResponseEntity<List<CityOutputDto>> getAll();

  @ApiOperation(value = "Busca uma cidade por id")
  @GetMapping("/cities/{id}")
  public ResponseEntity<CityOutputDto> getById(@PathVariable UUID id) throws EntityNotFoundException, BadRequestException;

  @ApiOperation(value = "Cria uma cidade")
  public ResponseEntity<InformativeMessageOutputDto> create(
    CreateCityInputDto city
  )  throws EntityConflictException, EntityNotFoundException, FileProcessingException;

  @ApiOperation(value = "Atualiza uma cidade")
  public ResponseEntity<InformativeMessageOutputDto> update(
    UpdateCityInputDto city,
    @PathVariable UUID id
  ) throws EntityNotFoundException, BadRequestException;

  @ApiOperation(value = "Deleta uma cidade")
  @DeleteMapping("/cities/{id}")
  public ResponseEntity<Void> delete(@PathVariable UUID id) throws BadRequestException, EntityNotFoundException, FileProcessingException;

  @ApiOperation(value = "Atualiza o banner de uma cidade")
  @PatchMapping("cities/{id}/banner-image")
  public ResponseEntity<Void> updateBannerImage(@PathVariable("id") UUID id, @Valid @ModelAttribute UpdateCityImageBannerInputDto bannerInputDto) throws EntityNotFoundException, FileProcessingException;

  @ApiOperation(value = "Deleta uma imagem da cidade")
  @DeleteMapping("/{id}/preview-images/{imageId}")
  public ResponseEntity<Void> deleteImageCity(
    @PathVariable("id") UUID cityId,
    @PathVariable("imageId") Long imageId
  ) throws EntityNotFoundException, FileProcessingException, BusinessException;

}
