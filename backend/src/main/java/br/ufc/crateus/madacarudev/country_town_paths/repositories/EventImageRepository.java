package br.ufc.crateus.madacarudev.country_town_paths.repositories;

import br.ufc.crateus.madacarudev.country_town_paths.models.EventImageModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventImageRepository extends JpaRepository<EventImageModel, Long> {
  public Optional<?> findByUrl(String url);
}
