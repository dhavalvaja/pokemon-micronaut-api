package com.testapi.pokemon;

public class PokemonNotFoundException extends RuntimeException {
    public PokemonNotFoundException() {
        super("Pokemon Not Found!!!");
    }
}
