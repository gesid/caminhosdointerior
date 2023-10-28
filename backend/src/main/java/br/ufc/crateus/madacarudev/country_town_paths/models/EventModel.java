package br.ufc.crateus.madacarudev.country_town_paths.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "events")
@Getter
@Setter
@NoArgsConstructor
public class EventModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String description;

  @Column(name = "banner_image", nullable = false)
  private String bannerImage;

  @Column(name = "start_date", nullable = false)
  private LocalDateTime startDate;

  @Column(name = "end_date", nullable = false)
  private LocalDateTime endDate;

  @ManyToOne()
  @JoinColumn(name = "category_id", nullable = false)
  private TouristAttractionCategoryModel touristAttractionCategory;

  @ManyToOne()
  @JoinColumn(name = "city_id", nullable = false)
  private CityModel city;

  @OneToMany(mappedBy = "event", cascade = CascadeType.REMOVE)
  private List<EventImageModel> previewImages;
}

