package br.ufc.crateus.madacarudev.country_town_paths.models;

import javax.persistence.*;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@Setter
@Entity
@Table(name = "feedbacks")
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  public String name;

  @Column(nullable = false)
  public String surname;

  @Column(nullable = false)
  public String email;

  @Column(nullable = false)
  public String message;
}
