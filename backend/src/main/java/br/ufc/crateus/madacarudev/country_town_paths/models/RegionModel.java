package br.ufc.crateus.madacarudev.country_town_paths.models;

import java.util.UUID;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "regions")
@AllArgsConstructor
@NoArgsConstructor
public class RegionModel {
    @Id
    @Column(unique = true, updatable = false, columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(nullable = false)
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