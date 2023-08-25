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
  public String save(String filePath, MultipartFile file) throws Exception {
    throw new Exception("Method not implemented");
  }

  @Override
  public void delete(String resourceUrl) throws Exception {
      throw new Exception("Method not implemented");
  }

  private String getFileResource(String filePath, String filename){
    return filePath + filename;
  } 
}
