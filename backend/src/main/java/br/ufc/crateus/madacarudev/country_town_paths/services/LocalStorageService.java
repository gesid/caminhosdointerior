package br.ufc.crateus.madacarudev.country_town_paths.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.stereotype.Service;
import br.ufc.crateus.madacarudev.country_town_paths.services.interfaces.IStorageService;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

@Service
public class LocalStorageService implements IStorageService {
  @Autowired
  private ServletWebServerApplicationContext webServerAppContext;

  private String getFileUrl(String directory, String filename) {
    String serverUrl = this.getServerUrl();
    String standardizeDirectory = this.standardizeDirectoryPath(directory);

    return serverUrl.concat(standardizeDirectory).concat(filename);
  }

  @Override
  public String save(String directory, MultipartFile file) throws IOException {
    ArrayList<String> uploadDirectoryPathParts = this.getUploadFolderPathParts(directory);
    var uploadDirectoryPathPartsArray = Arrays.copyOf(uploadDirectoryPathParts.toArray(), uploadDirectoryPathParts.size(), String[].class);

    Path uploadPath = Paths.get("src", uploadDirectoryPathPartsArray);

    if (!Files.exists(uploadPath)) {
      Files.createDirectories(uploadPath);
    }

    try (InputStream inputStream = file.getInputStream()) {
      String trimmedOriginalFilename = Objects.requireNonNull(file.getOriginalFilename()).replaceAll(" ", "-");
      Path filePath = uploadPath.resolve(UUID.randomUUID() + "-" + trimmedOriginalFilename);
      Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);

      String filename = filePath.getFileName().toString();
      return this.getFileUrl(directory, filename);
    } catch (IOException ioe) {
      throw new IOException("Could not save file: " + file.getOriginalFilename(), ioe);
    }
  }

  @Override
  public void delete(String resourceUrl) throws IOException {
    ArrayList<String> uploadDirectoryPathParts = this.getUploadFolderPathParts("");

    String serverUrl = this.getServerUrl();
    String localFileLocation = resourceUrl.replace(serverUrl, "");

    String[] localFileLocationPath = localFileLocation.split("/");
    uploadDirectoryPathParts.addAll(List.of(localFileLocationPath));

    var uploadDirectoryPathPartsArray = Arrays.copyOf(uploadDirectoryPathParts.toArray(), uploadDirectoryPathParts.size(), String[].class);

    Path uploadPath = Paths.get("src", uploadDirectoryPathPartsArray);
    Files.delete(uploadPath);
  }

  private ArrayList<String> getUploadFolderPathParts(String directory){
    String standardizedDirectory = this.standardizeDirectoryPath(directory);
    String[] directoryPathParts = standardizedDirectory.split("/");
    ArrayList<String> uploadFolderPathParts = new ArrayList<String>();

    uploadFolderPathParts.add("main");
    uploadFolderPathParts.add("resources");
    uploadFolderPathParts.add("static");

    Collections.addAll(uploadFolderPathParts, directoryPathParts);
    return uploadFolderPathParts;
  }

  private String standardizeDirectoryPath(String directory){
    String standardizedDirectoryPath = directory;

    if(Objects.isNull(directory) || directory.isEmpty()){
      return directory;
    }

    if(directory.charAt(0) != '/'){
      standardizedDirectoryPath = "/".concat(directory);
    }

    int lastStringCharacterIndex = directory.length() - 1;

    if(directory.charAt(lastStringCharacterIndex) != '/'){
      standardizedDirectoryPath = standardizedDirectoryPath.concat("/");
    }

    return standardizedDirectoryPath;
  }

  private String getServerUrl(){
    final int SERVER_PORT = this.webServerAppContext.getWebServer().getPort();
    String serverUrl = "http://localhost:".concat(String.valueOf(SERVER_PORT));

    return serverUrl;
  }
}
