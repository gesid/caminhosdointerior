package br.ufc.crateus.madacarudev.country_town_paths.configs;

import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.UpdateEventInputDto;
import br.ufc.crateus.madacarudev.country_town_paths.models.EventModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

  @Bean
  public ModelMapper modelMapper() {
    ModelMapper modelMapper = new ModelMapper();
    this.setUpdateEventInputDtoToEventModelMapping(modelMapper);

    return modelMapper;
  }

  private void setUpdateEventInputDtoToEventModelMapping(ModelMapper modelMapper){
    TypeMap<UpdateEventInputDto, EventModel> propertyMapper = modelMapper.createTypeMap(UpdateEventInputDto.class, EventModel.class);

    propertyMapper.addMappings(mapper -> {
      mapper.skip(EventModel::setId);
      mapper.skip(EventModel::setCity);
      mapper.skip(EventModel::setTouristAttractionCategory);
    });
  }
}
