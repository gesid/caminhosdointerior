package br.ufc.crateus.madacarudev.country_town_paths.models;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "feedbacks")
@AllArgsConstructor
@NoArgsConstructor
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
  public String email;

  @Column(nullable = false)
  public String message;
}
