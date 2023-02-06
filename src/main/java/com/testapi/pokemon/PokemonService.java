package com.testapi.pokemon;

import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class PokemonService {

    private final PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public List<Pokemon> get() {
        List<Pokemon> result = new ArrayList<>();
        pokemonRepository.findAll().forEach(result::add);
        return result;
    }

    public Pokemon create(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    public Pokemon update(Pokemon pokemon) {
        return  pokemonRepository.update(pokemon);
    }

    public Pokemon getById(Integer id) {
        return pokemonRepository.findById(id).orElseThrow();
    }

    public void deleteById(Integer id) {
        pokemonRepository.deleteById(id);
    }
}
