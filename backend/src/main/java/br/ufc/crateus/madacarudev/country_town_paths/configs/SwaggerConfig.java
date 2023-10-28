package br.ufc.crateus.madacarudev.country_town_paths.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
@Import(SpringDataRestConfiguration.class)
public class SwaggerConfig {
  public static final String HELLO_WORLD_TAG = "Hello World";
  public static final String REGION_TAG = "Região";
  public static final String CITY_TAG = "Cidade";
  public static final String FEEDBACK_TAG = "Feedback";
  public static final String EVENT_TAG = "Eventos";
  public static final String TOURIST_ATTRACTION_CATEGORY_TAG = "Categorias de atrações turísticas";

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .paths(PathSelectors.ant("/api/**"))
        .build().apiInfo(apiInfoMetaData())
        .tags(
          new Tag(CITY_TAG, "Endpoints de Cidade"),
          new Tag(CITY_TAG, "Endpoints de Regiões"),
          new Tag(FEEDBACK_TAG, "Endpoints de Feedback"),
          new Tag(EVENT_TAG, "Endpoints de Eventos"),
          new Tag(TOURIST_ATTRACTION_CATEGORY_TAG, "Endpoints de Categorias de Atrações Turísticas")
        );
  }

  private ApiInfo apiInfoMetaData() {

    return new ApiInfoBuilder().title("Documentação de API - Caminhos do Interior")
        .description("API desenvolvida para consumo na plataforma de turísmo caminhos do interior.")
        .contact(new Contact("Dev-Team", "https://www.payment.example.com/", "nzuwera2002@gmail.com"))
        .license("Apache 2.0")
        .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
        .version("1.0.0")
        .build();
  }
}