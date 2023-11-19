package br.ufc.crateus.madacarudev.country_town_paths.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "firebase")
public class FirebaseProperties {
  private String bucketName;
  private String storageUrl;
}
