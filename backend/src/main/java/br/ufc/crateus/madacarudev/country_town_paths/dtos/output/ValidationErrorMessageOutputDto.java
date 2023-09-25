package br.ufc.crateus.madacarudev.country_town_paths.dtos.output;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ValidationErrorMessageOutputDto extends InformativeMessageOutputDto{
    private List<ValidationFieldErrorOutputDto> errors;
}
