package com.testapi.pokemon;

import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class PokemonService {

    private final PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public List<Pokemon> get() {
        return pokemonRepository.get();
    }

    public List<Pokemon> create(Pokemon pokemon) {
        return pokemonRepository.create(pokemon);
    }

    public Pokemon edit(Pokemon pokemon) {
        return  pokemonRepository.edit(pokemon);
    }

    public Pokemon getById(Integer id) {
        return pokemonRepository.getById(id);
    }
}
