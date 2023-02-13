package com.testapi.pokemon;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PokemonUpdateForm extends PokemonForm {
    @JsonCreator
    public PokemonUpdateForm(
            @JsonProperty("name") String name,
            @JsonProperty("powerId") String power,
            @JsonProperty("imageUrl") Integer imageId
    ) {
        super(name, power, imageId);
    }
}
