package br.ufc.crateus.madacarudev.country_town_paths.models;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
    @Column(unique = true,updatable = false, columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(name="date_initial", nullable = false)
    private Date dateInitial;

    @Column(name="date_final", nullable = false)
    private Date dateFinal;

    @ManyToOne()
    @JoinColumn(name="category_id", nullable=false)
    private TouristAttractionCategoryModel touristAttractionCategory;

    @ManyToOne()
    @JoinColumn(name="city_id", nullable=false)
    private CityModel city;

    @Column(name="image_banner", nullable = false)
    private String imageBanner;

    @Column(nullable = false)
    private String description;
}

