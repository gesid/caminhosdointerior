package br.ufc.crateus.madacarudev.country_town_paths.controllers.openapi;

import javax.validation.Valid;

import java.util.List;

import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.DetailedCityOutputDto;
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
  public ResponseEntity<List<CityOutputDto>> getAll();

  @ApiOperation(value = "Busca uma cidade por id")
  public ResponseEntity<DetailedCityOutputDto> getById(
    Long id
  ) throws EntityNotFoundException, BadRequestException;

  @ApiOperation(value = "Cria uma cidade")
  public ResponseEntity<InformativeMessageOutputDto> create(
    CreateCityInputDto city
  )  throws EntityConflictException, EntityNotFoundException, FileProcessingException;

  @ApiOperation(value = "Atualiza uma cidade")
  public ResponseEntity<InformativeMessageOutputDto> update(
    UpdateCityInputDto city,
    Long id
  ) throws EntityNotFoundException, BadRequestException;

  @ApiOperation(value = "Deleta uma cidade")
  public ResponseEntity<Void> delete(
    Long id
  ) throws BadRequestException, EntityNotFoundException, FileProcessingException;

  @ApiOperation(value = "Atualiza o banner de uma cidade")
  public ResponseEntity<Void> updateBannerImage(
    Long id,
    @Valid @ModelAttribute UpdateCityImageBannerInputDto bannerInputDto
  ) throws EntityNotFoundException, FileProcessingException;

  @ApiOperation(value = "Deleta uma imagem da cidade")
  public ResponseEntity<Void> deleteImageCity(
    @PathVariable("id") Long cityId,
    @PathVariable("imageId") Long imageId
  ) throws EntityNotFoundException, FileProcessingException, BusinessException;

}
