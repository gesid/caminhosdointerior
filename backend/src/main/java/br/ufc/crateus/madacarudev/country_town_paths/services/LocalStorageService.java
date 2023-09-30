package br.ufc.crateus.madacarudev.country_town_paths.services;

import br.ufc.crateus.madacarudev.country_town_paths.exceptions.FileProcessingException;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class LocalStorageService implements IStorageService {

  private String getFileUrl(String directory, String filename) {
    String serverUrl = this.getServerUrl();
    String standardizeDirectory = this.standardizeDirectoryPath(directory);

    return serverUrl.concat(standardizeDirectory).concat(filename);
  }

  @Override
  public String save(String directory, MultipartFile file) throws FileProcessingException {
    try (InputStream inputStream = file.getInputStream()) {
      return this.trySave(directory, file, inputStream);
    } catch (IOException exception) {
      String message = String.format("Não foi possível salvar o arquivo pelo seguinte erro: %s", exception.getMessage());
      throw new FileProcessingException(message);
    }
  }

  private String trySave(String directory, MultipartFile file, InputStream inputStream) throws FileProcessingException, IOException {
    ArrayList<String> uploadDirectoryPathParts = this.getUploadFolderPathParts(directory);
    var uploadDirectoryPathPartsArray = Arrays.copyOf(uploadDirectoryPathParts.toArray(), uploadDirectoryPathParts.size(), String[].class);
    Path uploadPath = Paths.get("src", uploadDirectoryPathPartsArray);

    this.createDirectoryIfNotExists(uploadPath);

    String trimmedOriginalFilename = Objects.requireNonNull(file.getOriginalFilename()).replaceAll(" ", "-");
    Path filePath = uploadPath.resolve(UUID.randomUUID() + "-" + trimmedOriginalFilename);
    Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);

    String filename = filePath.getFileName().toString();
    return this.getFileUrl(directory, filename);
  }

  private void createDirectoryIfNotExists(Path uploadPath) throws FileProcessingException {
    if (!Files.exists(uploadPath)) {
      try {
        Files.createDirectories(uploadPath);
      } catch (IOException exception) {
        String message = String.format("Erro ao criar local de armazenamento do arquivo: %s", exception.getMessage());
        throw new FileProcessingException(message);
      }
    }
  }

  @Override
  public void delete(String resourceUrl) throws FileProcessingException {
    ArrayList<String> uploadDirectoryPathParts = this.getUploadFolderPathParts("");

    String serverUrl = this.getServerUrl();
    String localFileLocation = resourceUrl.replace(serverUrl, "");

    String[] localFileLocationPath = localFileLocation.split("/");
    uploadDirectoryPathParts.addAll(List.of(localFileLocationPath));

    var uploadDirectoryPathPartsArray = Arrays.copyOf(uploadDirectoryPathParts.toArray(), uploadDirectoryPathParts.size(), String[].class);

    Path uploadPath = Paths.get("src", uploadDirectoryPathPartsArray);

    try {
      Files.delete(uploadPath);
    } catch (IOException exception) {
      String message = String.format("Não foi possível remover o arquivo pelo seguinte erro: %s", exception.getMessage());
      throw new FileProcessingException(message);
    }
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
    return "http://localhost:8080";
  }
}