package br.ufc.crateus.madacarudev.country_town_paths.controllers.openapi;

import java.util.UUID;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.ufc.crateus.madacarudev.country_town_paths.configs.SwaggerConfig;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.CreateFeedbackDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.FeedbackOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.output.InformativeMessageOutputDto;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.BadRequestException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = { SwaggerConfig.FEEDBACK_TAG })
public interface FeedbackControllerOpenApi {

  @ApiOperation(value = "Retorna todas os feedbacks")
  @GetMapping("/feedbacks")
  public ResponseEntity<List<FeedbackOutputDto>> getAll();

  @ApiOperation(value = "Busca um feedback por id")
  @GetMapping("/feedbacks/{id}")
  public ResponseEntity<FeedbackOutputDto> getFeedbackById(@PathVariable UUID id) throws EntityNotFoundException, BadRequestException;

  @ApiOperation(value = "Cria um feedback")
  @PostMapping("/feedbacks")
  public ResponseEntity<InformativeMessageOutputDto> create(@RequestBody CreateFeedbackDto feedback)  throws BadRequestException;  

}
