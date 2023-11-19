package br.ufc.crateus.madacarudev.country_town_paths.models;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "images")
@Getter
@Setter
public class ImageModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 36)
  private String entityId;

  @Column(nullable = false)
  private String imageUrl;
}
