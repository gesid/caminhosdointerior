package br.ufc.crateus.madacarudev.country_town_paths.controllers.openapi;

import br.ufc.crateus.madacarudev.country_town_paths.configs.SwaggerConfig;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.CreateTouristLocationInputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.UpdateTouristLocationImageBannerInputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.UpdateTouristLocationInputDto;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.BusinessException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityNotFoundException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.FileProcessingException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;


@Api(tags = {SwaggerConfig.EVENT_TAG})
public interface TouristLocationControllerOpenApi {
  @ApiOperation(value = "Cadastra um local turístico")
  public ResponseEntity<?> create(CreateTouristLocationInputDto input)
    throws BusinessException, EntityNotFoundException, FileProcessingException;

  @ApiOperation(value = "Atualiza dados básicos do local turístico")
  public ResponseEntity<?> update(Long id, UpdateTouristLocationInputDto input)
    throws BusinessException, EntityNotFoundException;

  @ApiOperation(value = "Atualiza imagem de banner do local turístico")
  public ResponseEntity<?> updateBannerImage(Long id, UpdateTouristLocationImageBannerInputDto input)
    throws EntityNotFoundException, FileProcessingException;

  @ApiOperation(value = "Exclui uma imagem de pré-visualização do local turístico")
  public ResponseEntity<?> deletePreviewImage(
    Long eventId,
    Long previewImageId
  ) throws EntityNotFoundException, FileProcessingException, BusinessException;
}
