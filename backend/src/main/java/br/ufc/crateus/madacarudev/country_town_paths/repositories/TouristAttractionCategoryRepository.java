package br.ufc.crateus.madacarudev.country_town_paths.repositories;

import br.ufc.crateus.madacarudev.country_town_paths.models.TouristAttractionCategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TouristAttractionCategoryRepository extends JpaRepository<TouristAttractionCategoryModel, Long> {
  Optional<TouristAttractionCategoryModel> findByName(String name);
}
