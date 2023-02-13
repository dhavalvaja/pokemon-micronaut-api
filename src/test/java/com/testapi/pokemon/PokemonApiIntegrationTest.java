package com.testapi.pokemon;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.net.http.HttpResponse;

import static io.restassured.RestAssured.given;

@MicronautTest
public class PokemonApiIntegrationTest {
    @Test
    void testThatCreateWorks() {
        given()
                .param("name", "pikachu")
                .param("power", 1)
                .when()
                .get("/pokemon")
                .then()
                .body("id", Matchers.notNullValue());
    }

    @Test
    void test(){
        PokemonService pokemonService = Mockito.mock(PokemonService.class);
//        Mockito.when(pokemonService.create(new PokemonCreationForm("pikachu",1)))
//                .thenReturn(null);
//        Mockito.verify(pokemonService).create(new PokemonCreationForm("pikachu",1));
    }

}
