package com.testapi.exeption;

public class PokemonNotFoundException extends PokemonException {
    public PokemonNotFoundException() {
        super("Pokemon Not Found!!!");
    }
}
