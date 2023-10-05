package br.ufc.crateus.madacarudev.country_town_paths.dtos.output;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TouristAttractionsWithCategoriesOutputDto extends TouristAttractionCategoryOutputDto{
    private List<SampleTouristLocationOutputDto> locations;
    private List<SampleEventOutputDto> events;
}
