package com.testapi.pokemon;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PokemonUpdateForm extends PokemonForm {
    private final String imageUrl;

    @JsonCreator
    public PokemonUpdateForm(@JsonProperty("name") String name, @JsonProperty("powerId") Integer powerId, @JsonProperty("imageUrl") String imageUrl) {
        super(name, powerId);
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
