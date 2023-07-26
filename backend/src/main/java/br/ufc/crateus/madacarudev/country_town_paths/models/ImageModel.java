package br.ufc.crateus.madacarudev.country_town_paths.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "images")
@Getter
@Setter
public class ImageModel {
  @Id
  @Column(unique = true, updatable = false, length = 36)
  private String id;

  @Column(nullable = false, length = 36)
  private String entityId;

  @Column(nullable = false)
  private String imageUrl;
}
