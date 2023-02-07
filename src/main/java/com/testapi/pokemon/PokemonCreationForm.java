package com.testapi.pokemon;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PokemonCreationForm extends PokemonForm {
    @JsonCreator
    public PokemonCreationForm(@JsonProperty("name") String name, @JsonProperty("powerId") Integer powerId) {
        super(name, powerId);
    }
}
