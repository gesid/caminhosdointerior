package br.ufc.crateus.madacarudev.country_town_paths.repositories;

import java.util.List;
import java.util.Optional;

import br.ufc.crateus.madacarudev.country_town_paths.models.RegionModel;
import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.crateus.madacarudev.country_town_paths.models.CityModel;

public interface CityRepository extends JpaRepository<CityModel, Long> {
    Optional<CityModel> findByName(String name);
    Optional<List<CityModel>> getCityModelByRegion(RegionModel region);
}
