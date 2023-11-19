package br.ufc.crateus.madacarudev.country_town_paths.repositories;

import br.ufc.crateus.madacarudev.country_town_paths.models.TouristLocationImageModel;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TouristLocationImageRepository extends JpaRepository<TouristLocationImageModel, Long> {
  public Optional<?> findByUrl(String url);
}
