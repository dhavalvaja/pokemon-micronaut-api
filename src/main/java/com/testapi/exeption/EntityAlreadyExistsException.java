package com.testapi.exeption;

public class EntityAlreadyExistsException extends PokemonException {
    public EntityAlreadyExistsException(String message) {
        super(message);
    }
}
