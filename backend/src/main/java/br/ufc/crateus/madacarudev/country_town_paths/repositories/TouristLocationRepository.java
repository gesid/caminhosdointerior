package br.ufc.crateus.madacarudev.country_town_paths.repositories;

import br.ufc.crateus.madacarudev.country_town_paths.models.TouristLocationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TouristLocationRepository extends JpaRepository<TouristLocationModel, Long> {
}
