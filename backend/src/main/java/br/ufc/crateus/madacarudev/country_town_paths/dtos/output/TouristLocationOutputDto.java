package br.ufc.crateus.madacarudev.country_town_paths.dtos.output;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TouristLocationOutputDto {
  private String name;
  private String description;
  private Long touristAttractionCategoryId;
  private Long cityId;
  private MultipartFile bannerImage;
}