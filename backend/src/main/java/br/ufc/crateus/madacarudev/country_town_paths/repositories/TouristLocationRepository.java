package br.ufc.crateus.madacarudev.country_town_paths.repositories;

import br.ufc.crateus.madacarudev.country_town_paths.models.EventModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TouristLocationRepository extends JpaRepository<EventModel, Long> {
}
