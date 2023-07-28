package br.ufc.crateus.madacarudev.country_town_paths.models;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;

import lombok.Getter;
import lombok.Setter;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "city")
@Getter
@Setter
@NoArgsConstructor
public class CityModel {
  @Id
  @GeneratedValue
  @Column(unique = true, updatable = false, length = 36)
  private UUID id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false, columnDefinition = "BINARY(36)")
  private UUID regionId;  

  @Column(nullable = false)
  private String imageBannerUrl;
 
  @Column(nullable = false)
  private String description; 
}