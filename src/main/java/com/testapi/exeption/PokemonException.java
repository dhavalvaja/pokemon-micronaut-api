package com.testapi.exeption;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(
        getterVisibility = JsonAutoDetect.Visibility.NONE
)

public class PokemonException extends RuntimeException {

    @JsonProperty
    private final String message;

    public PokemonException(String message) {
        this.message = message;

    }

    public String getMessage() {
        return message;
    }
}
