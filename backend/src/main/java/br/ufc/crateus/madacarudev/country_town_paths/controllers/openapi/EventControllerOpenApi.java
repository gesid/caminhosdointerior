package br.ufc.crateus.madacarudev.country_town_paths.controllers.openapi;

import br.ufc.crateus.madacarudev.country_town_paths.configs.SwaggerConfig;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.CreateEventInputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.UpdateEventImageBannerInputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.UpdateEventInputDto;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.BusinessException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityNotFoundException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.FileProcessingException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;


@Api(tags = {SwaggerConfig.EVENT_TAG})
public interface EventControllerOpenApi {
  @ApiOperation(value = "Cadastra um evento")
  public ResponseEntity<?> create(CreateEventInputDto input)
    throws BusinessException, EntityNotFoundException, FileProcessingException;

  @ApiOperation(value = "Atualiza dados básicos do evento")
  public ResponseEntity<?> update(Long id, UpdateEventInputDto input)
    throws BusinessException, EntityNotFoundException;

  @ApiOperation(value = "Atualiza imagem de banner do evento")
  public ResponseEntity<?> updateBannerImage(Long id, UpdateEventImageBannerInputDto input)
    throws EntityNotFoundException, FileProcessingException;

  @ApiOperation(value = "Exclui uma imagem de pré-visualização do evento")
  public ResponseEntity<?> deletePreviewImage(
    Long eventId,
    Long previewImageId
  ) throws EntityNotFoundException, FileProcessingException, BusinessException;
}
