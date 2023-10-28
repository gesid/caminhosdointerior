package br.ufc.crateus.madacarudev.country_town_paths.models;

import java.util.List;
import javax.persistence.*;

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
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @OneToMany(mappedBy = "category")
  private List<TouristLocationModel> locations;

  @OneToMany(mappedBy = "touristAttractionCategory")
  private List<EventModel> events;
}
