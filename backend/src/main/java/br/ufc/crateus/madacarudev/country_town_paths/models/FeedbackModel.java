package br.ufc.crateus.madacarudev.country_town_paths.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class FeedbackModel {
  @Id
  @GeneratedValue
  @Column(unique = true, updatable = false, columnDefinition = "BINARY(16)")
  private UUID id;

  @Column(nullable = false)
  public String name;

  @Column(nullable = false)
  public String surname;

  @Column(nullable = false)
  public String message;
}
