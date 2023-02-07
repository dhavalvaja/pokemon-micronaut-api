package com.testapi.exeption;

public class EntityNotFoundException extends PokemonException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}
