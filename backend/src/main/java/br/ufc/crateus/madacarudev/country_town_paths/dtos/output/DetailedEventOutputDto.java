package br.ufc.crateus.madacarudev.country_town_paths.dtos.output;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class DetailedEventOutputDto {
  private Long id;

  private String name;

  private String description;

  private String bannerImage;

  private LocalDateTime startDate;

  private LocalDateTime endDate;

  private TouristAttractionCategoryOutputDto touristAttractionCategory;

  private SampleCityOutputDto city;

  private List<ImageOutputDto> previewImages;
}