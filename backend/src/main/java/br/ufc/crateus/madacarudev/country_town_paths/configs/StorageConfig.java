package br.ufc.crateus.madacarudev.country_town_paths.configs;

import br.ufc.crateus.madacarudev.country_town_paths.services.FirebaseStorageService;
import br.ufc.crateus.madacarudev.country_town_paths.services.LocalStorageService;
import br.ufc.crateus.madacarudev.country_town_paths.services.interfaces.IStorageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.Objects;

@Configuration
public class StorageConfig {
  private final Environment environment;

  public StorageConfig(Environment environment) {
    this.environment = environment;
  }

  @Bean
  public IStorageService storageService(){
    String activeProfile = this.environment.getProperty("spring.profiles.active");
    if(Objects.nonNull(activeProfile) && activeProfile.equals("prod")){
      return new FirebaseStorageService();
    }

    return new LocalStorageService();
  }
}
