package br.ufc.crateus.madacarudev.country_town_paths.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

  @GetMapping("/")
  public String getHelloWorld(){
    return "Hello World";
  }
}
