package com.testapi.pokemon;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PokemonCreationForm extends PokemonForm {
    @JsonCreator
    public PokemonCreationForm(
            @JsonProperty("name") String name,
            @JsonProperty("powerId") String power,
            @JsonProperty("imageId") Integer imageId
    ) {
        super(name, power, imageId);
    }
}
