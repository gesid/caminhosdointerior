package br.ufc.crateus.madacarudev.country_town_paths.models;

import java.util.UUID;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "regions")
@NoArgsConstructor
public class RegionModel {
    @Id
    @GeneratedValue
    @Column(unique = true, updatable = false, columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(length = 100, nullable = false)
    public String name;

    @OneToMany(mappedBy="region")
    public List<CityModel> cities;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RegionModel(String name) {
        this.name = name;
    }
}
