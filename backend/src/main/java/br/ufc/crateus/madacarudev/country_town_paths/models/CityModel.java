package br.ufc.crateus.madacarudev.country_town_paths.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "cities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

  @OneToMany(mappedBy = "city", cascade = CascadeType.REMOVE)
  private List<CityImageModel> imagesCity;

  public CityModel(String name, String imageBannerUrl, String description, RegionModel region){
    this.name = name;
    this.description = description;
    this.imageBannerUrl = imageBannerUrl;
    this.region = region;
  }
}