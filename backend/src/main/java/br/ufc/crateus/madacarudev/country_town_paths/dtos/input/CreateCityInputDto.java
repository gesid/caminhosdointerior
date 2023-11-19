package br.ufc.crateus.madacarudev.country_town_paths.dtos.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateCityInputDto {
    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    private MultipartFile imageBanner;

    @NotNull
    private MultipartFile[] imagesCity;

    @NotNull
    private Long regionId;
}
