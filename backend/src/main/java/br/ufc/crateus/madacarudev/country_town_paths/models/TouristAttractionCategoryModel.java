package br.ufc.crateus.madacarudev.country_town_paths.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tourist_attraction_categories")
@NoArgsConstructor
@Getter
@Setter
public class TouristAttractionCategoryModel {
  @Id
  @Column(unique = true, updatable = false, columnDefinition = "BINARY(16)")
  private UUID id;

  @Column(nullable = false)
  private String name;
}
