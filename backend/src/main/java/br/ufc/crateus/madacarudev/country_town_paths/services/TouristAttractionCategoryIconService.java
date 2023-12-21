package br.ufc.crateus.madacarudev.country_town_paths.services;

import br.ufc.crateus.madacarudev.country_town_paths.exceptions.BusinessException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.EntityNotFoundException;
import br.ufc.crateus.madacarudev.country_town_paths.exceptions.FileProcessingException;
import br.ufc.crateus.madacarudev.country_town_paths.models.CityImageModel;
import br.ufc.crateus.madacarudev.country_town_paths.models.CityModel;
import br.ufc.crateus.madacarudev.country_town_paths.repositories.CityImageRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class TouristAttractionCategoryIconService {
  private final LocalStorageService storageService;

  public String storeImage(MultipartFile image) throws FileProcessingException {
    return this.storageService.save("tourist-attraction-categories/images", image);
  }

  @Transactional
  public void deleteImageFile(String resourceUrl) throws FileProcessingException {
    this.storageService.delete(resourceUrl);
  }
}
