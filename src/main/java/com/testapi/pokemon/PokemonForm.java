package com.testapi.pokemon;

public abstract class PokemonForm {
    private final String name;
    private final String power;
    private final Integer imageId;

    public PokemonForm(String name, String power, Integer imageId) {
        this.name = name;
        this.power = power;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public String getPower() {
        return power;
    }

    public Integer getImageId() {
        return imageId;
    }
}
