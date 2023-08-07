package br.ufc.crateus.madacarudev.country_town_paths.repositories;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import br.ufc.crateus.madacarudev.country_town_paths.models.RegionModel;

public interface RegionRepository extends JpaRepository<RegionModel, UUID> {
    Optional<RegionModel> findByName(String name);
}
