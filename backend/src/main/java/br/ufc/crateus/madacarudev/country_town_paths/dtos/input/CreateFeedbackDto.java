package br.ufc.crateus.madacarudev.country_town_paths.dtos.input;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateFeedbackDto {
    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private String email;

    @NotBlank
    private String message;
}
