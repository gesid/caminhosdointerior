package br.ufc.crateus.madacarudev.country_town_paths.dtos.input;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CreateEventInputDto {
  @NotBlank
  private String name;

  @NotBlank
  private String description;

  @NotNull
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime startDate;

  @NotNull
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime endDate;

  @NotNull
  private Long touristAttractionCategoryId;

  @NotNull
  private Long cityId;

  @NotNull
  private MultipartFile bannerImage;

  @NotNull
  private MultipartFile[] previewImages;
}
