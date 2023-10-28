package br.ufc.crateus.madacarudev.country_town_paths.repositories;

import br.ufc.crateus.madacarudev.country_town_paths.models.CityImageModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityImageRepository extends JpaRepository<CityImageModel, Long> {
  public Optional<?> findByUrl(String url);
}
