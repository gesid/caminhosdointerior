package br.ufc.crateus.madacarudev.country_town_paths.dtos.input;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class CreateTouristLocationInputDto {
  @NotBlank
  private String name;

  @NotBlank
  private String description;

  @NotNull
  private Long touristAttractionCategoryId;

  @NotNull
  private Long cityId;

  @NotNull
  private MultipartFile bannerImage;

  @NotNull
  private MultipartFile[] previewImages;
}
