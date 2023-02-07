package com.testapi.pokemon;

import com.testapi.power.Power;

public class PokemonDTO {
    private final Integer id;
    private final String name;
    private final Power power;
    private final String imageUrl;

    public PokemonDTO(Pokemon pokemon) {
        this.id = pokemon.getId();
        this.name = pokemon.getName();
        this.power = pokemon.getPower();
        this.imageUrl = pokemon.getImageUrl();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Power getPower() {
        return power;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
