package br.ufc.crateus.madacarudev.country_town_paths.models;

import java.util.List;
import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "regions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    public String name;

    @OneToMany(mappedBy="region")
    public List<CityModel> cities;
}
