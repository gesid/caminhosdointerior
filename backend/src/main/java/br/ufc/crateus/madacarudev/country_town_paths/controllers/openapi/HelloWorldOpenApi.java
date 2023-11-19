package br.ufc.crateus.madacarudev.country_town_paths.controllers.openapi;

import br.ufc.crateus.madacarudev.country_town_paths.configs.SwaggerConfig;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.CreateHelloWorldInputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.UpdateHelloWorldInputDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = { SwaggerConfig.HELLO_WORLD_TAG })
public interface HelloWorldOpenApi {

  @ApiOperation(value = "Retorna mensagem de hello world")
  public String getHelloWorldMessage();

  @ApiOperation(value = "Cria mensagem de hello world")
  public void createHelloWorldMessage(CreateHelloWorldInputDto body);

  @ApiOperation(value = "Atualiza mensagem de hello world")
  public void updateHelloWorldMessage(Long id, UpdateHelloWorldInputDto body);  
  
  @ApiOperation(value = "Remove mensagem de hello world")
  public void deleteHelloWorldMessage(Long id);
}
