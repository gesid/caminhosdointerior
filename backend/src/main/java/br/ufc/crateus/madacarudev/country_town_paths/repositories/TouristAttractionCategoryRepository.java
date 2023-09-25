package br.ufc.crateus.madacarudev.country_town_paths.repositories;

import br.ufc.crateus.madacarudev.country_town_paths.models.TouristAttractionCategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TouristAttractionCategoryRepository extends JpaRepository<TouristAttractionCategoryModel, Long> {
}
