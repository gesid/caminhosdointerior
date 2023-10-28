package br.ufc.crateus.madacarudev.country_town_paths.configs;

import br.ufc.crateus.madacarudev.country_town_paths.dtos.input.UpdateCityInputDto;
import br.ufc.crateus.madacarudev.country_town_paths.models.CityModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        this.setUpdateCityInputDtoToCityModelMapping(modelMapper);

        return modelMapper;
    }

    private void setUpdateCityInputDtoToCityModelMapping(ModelMapper modelMapper){
        TypeMap<UpdateCityInputDto, CityModel> propertyMapper = modelMapper.createTypeMap(
          UpdateCityInputDto.class,
          CityModel.class
        );

        propertyMapper.addMappings(mapper -> {
            mapper.skip(CityModel::setId);
            mapper.skip(CityModel::setRegion);
        });
    }
}
