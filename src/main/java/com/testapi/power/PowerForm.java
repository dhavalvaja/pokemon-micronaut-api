package com.testapi.power;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PowerForm {
    private final String name;

    @JsonCreator
    public PowerForm(@JsonProperty("name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
