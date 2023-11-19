package br.ufc.crateus.madacarudev.country_town_paths.services.interfaces;

import java.util.UUID;

import br.ufc.crateus.madacarudev.country_town_paths.exceptions.FileProcessingException;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

public interface IStorageService {
  String save(String directory, MultipartFile file) throws FileProcessingException;

  void delete(String resourceUrl) throws FileProcessingException;

  default String getFileExtension(String originalFileName){
    return StringUtils.getFilenameExtension(originalFileName);
  }

  default String generateFileName(String originalFileName) {
    return UUID.randomUUID().toString() + "-" + originalFileName + "." + this.getFileExtension(originalFileName);
  }
}
