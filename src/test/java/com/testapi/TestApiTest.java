package com.testapi;

import com.testapi.pokemon.Pokemon;
import com.testapi.pokemon.PokemonCreationForm;
import com.testapi.pokemon.PokemonRepository;
import com.testapi.pokemon.PokemonService;
import com.testapi.power.Power;
import com.testapi.power.PowerService;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

class TestApiTest {

    PokemonService pokemonService;
    PowerService powerService;
    PokemonRepository pokemonRepository;
    PokemonCreationForm pokemonCreationForm;
    Power power;
    Pokemon pokemon;
    private static final String SOURCE_IMAGE_URL = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/";
    private static final String EXTENSION = ".png";

    @BeforeEach
    void setUp() {
        pokemonCreationForm = new PokemonCreationForm("test-name", "grass", 1);
        power = new Power(1, pokemonCreationForm.getPower());
        pokemon = new Pokemon(23, pokemonCreationForm.getName(), power, SOURCE_IMAGE_URL + pokemonCreationForm.getImageId() + EXTENSION);

        powerService = Mockito.mock(PowerService.class);
        pokemonRepository = Mockito.mock(PokemonRepository.class);
        pokemonService = new PokemonService(pokemonRepository, powerService);
    }

    @Test
    void shouldReturnPokemonList() {
        Mockito.when(pokemonRepository.findAll()).thenReturn(List.of(pokemon));

        List<Pokemon> pokemonList = pokemonService.get();

        Mockito.verify(pokemonRepository).findAll();
        Assertions.assertThat(pokemonList).containsExactlyElementsOf(List.of(pokemon));
    }

    @Test
    void shouldCreatePokemon() {
        Mockito.when(pokemonRepository.findByName(pokemonCreationForm.getName())).thenReturn(Optional.ofNullable(null));
        Mockito.when(powerService.getByName(pokemonCreationForm.getPower())).thenReturn(power);
        Mockito.when(pokemonRepository.save(Mockito.any())).thenReturn(pokemon);

        Pokemon createdPokemon = pokemonService.create(pokemonCreationForm);

        Mockito.verify(pokemonRepository).findByName(pokemonCreationForm.getName());
        Mockito.verify(powerService).getByName(pokemonCreationForm.getPower());
        Mockito.verify(pokemonRepository).save(Mockito.any());
        Assertions.assertThat(createdPokemon).isEqualTo(pokemon);
    }

    @Test
    void shouldUpdatePokemon() {
        int id = Mockito.anyInt();
        pokemon.setId(id);
        Mockito.when(pokemonRepository.existsById(id)).thenReturn(true);
        Mockito.when(powerService.getByName(pokemonCreationForm.getPower())).thenReturn(power);
        Mockito.when(pokemonRepository.update(Mockito.any())).thenReturn(pokemon).thenReturn(pokemon);

        Pokemon updatedPokemon = pokemonService.update(id, pokemonCreationForm);

        Mockito.verify(pokemonRepository).existsById(id);
        Mockito.verify(powerService).getByName(pokemonCreationForm.getPower());
        Mockito.verify(pokemonRepository).update(Mockito.any());
        Assertions.assertThat(updatedPokemon.getId()).isEqualTo(id);
        Assertions.assertThat(updatedPokemon.getPower().getName()).isEqualTo(pokemonCreationForm.getPower());
        Assertions.assertThat(updatedPokemon.getName()).isEqualTo(pokemonCreationForm.getName());
        Assertions.assertThat(updatedPokemon.getImageUrl()).isEqualTo(SOURCE_IMAGE_URL + pokemonCreationForm.getImageId() + EXTENSION);
    }

    @Test
    void shouldDeletePokemon() {
        int id = Mockito.anyInt();
        Mockito.when(pokemonRepository.existsById(id)).thenReturn(true);

        pokemonService.deleteById(id);

        Mockito.verify(pokemonRepository).existsById(id);
        Mockito.verify(pokemonRepository).deleteById(id);
    }
}
