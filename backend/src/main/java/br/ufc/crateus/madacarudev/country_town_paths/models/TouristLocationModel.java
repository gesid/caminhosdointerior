package br.ufc.crateus.madacarudev.country_town_paths.models;

import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tourist_locations")
public class TouristLocationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String bannerImage;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private TouristAttractionCategoryModel touristAttractionCategory;
    
    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private CityModel city;

    @OneToMany(mappedBy = "touristLocation", cascade = CascadeType.REMOVE)
    private List<TouristLocationImageModel> previewImages;
}
