package br.ufc.crateus.madacarudev.country_town_paths.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.StorageClient;

import br.ufc.crateus.madacarudev.country_town_paths.services.interfaces.IStorageService;
import br.ufc.crateus.madacarudev.country_town_paths.utils.FirebaseProperties;

@Service
public class FirebaseStorageService implements IStorageService {

  @Autowired
  private FirebaseProperties firebaseProperties;

  @EventListener
  public void init(ApplicationReadyEvent event) {
    try {
      ClassPathResource serviceAccount = new ClassPathResource("firebase-config.json");

      FirebaseOptions options = new FirebaseOptions.Builder()
        .setCredentials(GoogleCredentials.fromStream(serviceAccount.getInputStream()))
        .setStorageBucket(firebaseProperties.getBucketName())
        .build();

      FirebaseApp.initializeApp(options);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }


  @Override
  public String save(String resourcePath, MultipartFile file) throws IOException {
    Bucket bucket = StorageClient.getInstance().bucket();

    String newFilename = generateFileName(file.getOriginalFilename());
    String newFileResourcePath = this.getFileResource(resourcePath, newFilename);

    bucket.create(newFileResourcePath, file.getBytes(), file.getContentType());
    
    return newFilename;
  }

  @Override
  public void delete(String resourcePath, String name) throws IOException {
    Bucket bucket = StorageClient.getInstance().bucket();

    if (Objects.isNull(bucket)) {
      throw new IOException("invalid file name");
    }

    String fileResourcePath = this.getFileResource(resourcePath, name);
    Blob blob = bucket.get(fileResourcePath);

    if (Objects.isNull(blob)) {
      throw new IOException("file not found");
    }

    blob.delete();
  }

  @Override
  public String getExtension(String originalFileName) {
    return StringUtils.getFilenameExtension(originalFileName);
  }

  @Override
  public String generateFileName(String originalFileName) {
    return UUID.randomUUID().toString() + "." + getExtension(originalFileName);
  }

  @Override
  public String getFileUrl(String resourcePath, String name) {
    String storageUrl = this.firebaseProperties.getStorageUrl();
    String fileResourcePath = this.getFileResource(resourcePath, name);

    String fileUrl = String.format(storageUrl, fileResourcePath);
    return fileUrl;
  }

  private String getFileResource(String resourcePath, String filename){
    return resourcePath + filename;
  } 
}
