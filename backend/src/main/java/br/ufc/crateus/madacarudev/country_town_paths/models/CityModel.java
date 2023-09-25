package br.ufc.crateus.madacarudev.country_town_paths.models;

import java.util.List;
import javax.persistence.*;

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
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String imageBannerUrl;
 
  @Column(nullable = false)
  private String description; 

  @ManyToOne()
  @JoinColumn(name="region_id", nullable=false)
  private RegionModel region;  

  @OneToMany(mappedBy = "city")
  private List<TouristLocationModel> location;

}