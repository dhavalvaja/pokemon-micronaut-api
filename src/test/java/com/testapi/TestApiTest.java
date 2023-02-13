package com.testapi;

import com.testapi.pokemon.*;
import com.testapi.power.Power;
import com.testapi.power.PowerService;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

@MicronautTest
class TestApiTest {

    PokemonService pokemonService;
    PowerService powerService;
    PokemonRepository pokemonRepository;

    @BeforeEach
    void setUp() {
        powerService = Mockito.mock(PowerService.class);
        pokemonRepository = Mockito.mock(PokemonRepository.class);
        pokemonService = new PokemonService(pokemonRepository,powerService);
    }

    @Test
    void testGetPokemon() {
        Mockito.when(pokemonRepository.findAll()).thenReturn(List.of(new Pokemon()));
        pokemonService.get();
        Mockito.verify(pokemonRepository).findAll();
    }

    @Test
    void testPostPokemon() {
        Pokemon pokemon = new Pokemon(1, "test", new Power(1, "power"), "image url");
        PokemonCreationForm pokemonCreationForm = new PokemonCreationForm("test", "fly", 1);
        Mockito.when(pokemonRepository.findByName(pokemonCreationForm.getName())).thenReturn(Optional.of(new Pokemon()));
        Mockito.when(powerService.getByName(pokemonCreationForm.getName())).thenReturn(new Power(1,"fly"));
        Mockito.when(pokemonRepository.save(pokemon)).thenReturn(pokemon);
        pokemonService.create(pokemonCreationForm);
        Mockito.verify(pokemonRepository).save(pokemon);
    }

    @Test
    void testUpdatePokemon() {
        Pokemon pokemon = new Pokemon(1, "test", new Power(1, "power"), "image url");
        PokemonCreationForm pokemonCreationForm = new PokemonCreationForm("abc", "fly", 1);
        Mockito.when(pokemonService.update(1, pokemonCreationForm)).thenReturn(pokemon);
//        pokemonController.update(pokemonCreationForm, 1);
        Mockito.verify(pokemonService).update(1, pokemonCreationForm);
    }

    @Test
    void testDeletePokemon() {
//        pokemonController.deleteById(1);
        Mockito.verify(pokemonService).deleteById(1);
    }
}
