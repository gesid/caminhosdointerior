package br.ufc.crateus.madacarudev.country_town_paths.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ufc.crateus.madacarudev.country_town_paths.models.CityModel;

public interface CityRepository extends JpaRepository<CityModel, UUID> {
    Optional<CityModel> findByName(String name);
    @Query("SELECT * FROM cities as c WHERE c.region_id = ?1;")
    Optional<List<CityModel>> getByRegion(UUID idRegion);
}
