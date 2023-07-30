package br.ufc.crateus.madacarudev.country_town_paths.models;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;

import lombok.Getter;
import lombok.Setter;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "cities")
@Getter
@Setter
@NoArgsConstructor
public class CityModel {
  @Id
  @GeneratedValue
  @Column(unique = true, updatable = false, columnDefinition = "BINARY(16)")
  private UUID id;

  @Column(nullable = false)
  private String name;

  @ManyToOne()
  @JoinColumn(name="region_id", nullable=false)
  private RegionModel region;  

  @Column(nullable = false)
  private String imageBannerUrl;
 
  @Column(nullable = false)
  private String description; 
}