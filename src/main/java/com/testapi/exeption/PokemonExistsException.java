package com.testapi.exeption;

public class PokemonExistsException extends PokemonException {
    public PokemonExistsException() {
        super("Pokemon Already Exists!!!");
    }

    public PokemonExistsException(String propertyName, String enteredValue) {
        super("Pokemon Already Exists With Entered " + propertyName + " '" + enteredValue + "'");
    }
}
