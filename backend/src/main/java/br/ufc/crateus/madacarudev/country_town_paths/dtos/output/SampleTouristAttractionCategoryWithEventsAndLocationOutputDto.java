package br.ufc.crateus.madacarudev.country_town_paths.dtos.output;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SampleTouristAttractionCategoryWithEventsAndLocationOutputDto extends TouristAttractionCategoryOutputDto{
    private List<TouristLocationOutputDto> locations;
    private List<EventOutputDto> events;
}
