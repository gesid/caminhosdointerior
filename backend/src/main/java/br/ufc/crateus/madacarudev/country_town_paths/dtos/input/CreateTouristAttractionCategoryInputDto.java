package br.ufc.crateus.madacarudev.country_town_paths.dtos.input;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateTouristAttractionCategoryInputDto {
  @NotBlank
  private String name;

  @NotNull
  private MultipartFile icon;
}
