package com.testapi.pokemon;

public class PokemonExistsException extends RuntimeException {
    public PokemonExistsException() {
        super("Pokemon Already Exists!!!");
    }

    public PokemonExistsException(String propertyName, String enteredValue) {
        super("Pokemon Already Exists With Entered " + propertyName + " '" + enteredValue + "'");
    }
}
