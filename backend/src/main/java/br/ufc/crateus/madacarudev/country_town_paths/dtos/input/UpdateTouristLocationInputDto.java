package br.ufc.crateus.madacarudev.country_town_paths.dtos.input;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateTouristLocationInputDto {
  @NotBlank
  private String name;

  @NotBlank
  private String description;

  @NotNull
  private Long touristAttractionCategoryId;

  @NotNull
  private Long cityId;
}
