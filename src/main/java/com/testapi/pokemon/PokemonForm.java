package com.testapi.pokemon;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class PokemonForm {
    private final String name;
    private final Integer powerId;

    public PokemonForm(String name, Integer powerId) {
        this.name = name;
        this.powerId = powerId;
    }

    public String getName() {
        return name;
    }

    public Integer getPowerId() {
        return powerId;
    }
}
