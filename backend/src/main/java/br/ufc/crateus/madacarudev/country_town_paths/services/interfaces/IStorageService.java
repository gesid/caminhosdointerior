package br.ufc.crateus.madacarudev.country_town_paths.services.interfaces;

import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

public interface IStorageService {
  String save(String directory, MultipartFile file) throws Exception;

  void delete(String resourceUrl) throws Exception;

  default String getFileExtension(String originalFileName){
    return StringUtils.getFilenameExtension(originalFileName);
  }

  default String generateFileName(String originalFileName) {
    return UUID.randomUUID().toString() + "-" + originalFileName + "." + this.getFileExtension(originalFileName);
  }
}
