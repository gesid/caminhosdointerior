package br.ufc.crateus.madacarudev.country_town_paths.services.interfaces;

import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

public interface IStorageService {
  String getFileUrl( String resourcePath, String name);

  String save(String resourcePath, MultipartFile file) throws IOException;

  void delete( String resourcePath, String name) throws IOException;

  String getExtension(String originalFileName);

  String generateFileName(String originalFileName);
}
