package br.ufc.crateus.madacarudev.country_town_paths.services;

import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityNotFoundException;
import br.ufc.crateus.madacarudev.country_town_paths.models.CityModel;
import br.ufc.crateus.madacarudev.country_town_paths.repositories.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityService {
  private final CityRepository cityRepository;

  public CityModel getById(Long id) throws EntityNotFoundException {
    Optional<CityModel> searchedCity = this.cityRepository.findById(id);

    if (searchedCity.isEmpty()) {
      String message = String.format("Não existe uma cidade com ID: %s", id.toString());
      throw new EntityNotFoundException(message);
    }

    return searchedCity.get();
  }
}
