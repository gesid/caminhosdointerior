package br.ufc.crateus.madacarudev.country_town_paths.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.crateus.madacarudev.country_town_paths.controllers.openapi.HelloWorldOpenApi;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.CreateHelloWorldInputDto;
import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.UpdateHelloWorldInputDto;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController implements HelloWorldOpenApi{

  @GetMapping
  public String getHelloWorldMessage(){
    return "Hello World";
  }

  @PostMapping
  public void createHelloWorldMessage(@RequestBody CreateHelloWorldInputDto body) {
    System.out.printf("createHelloWorldMessage: %s", body.toString());
  }

  @PutMapping("/{id}")
  public void updateHelloWorldMessage(@PathVariable("id") Long id, @RequestBody UpdateHelloWorldInputDto body) {
    System.out.printf("updateHelloWorldMessage: %s", body.toString());
  }

  @DeleteMapping("/{id}")
  public void deleteHelloWorldMessage(Long id) {
    System.out.printf("deleteHelloWorldMessage: %s" + id.toString());
  }
}
