package br.ufc.crateus.madacarudev.country_town_paths.dtos.output;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegionOutputDto {

    private UUID id;
    @NotBlank
    public String name;
}
