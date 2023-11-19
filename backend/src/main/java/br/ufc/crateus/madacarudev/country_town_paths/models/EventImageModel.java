package br.ufc.crateus.madacarudev.country_town_paths.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "event_images")
@Getter
@Setter
public class EventImageModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String url;

  @ManyToOne
  private EventModel event;
}
