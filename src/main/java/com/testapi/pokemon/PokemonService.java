package com.testapi.pokemon;

import jakarta.inject.Singleton;
import org.hibernate.ObjectNotFoundException;

import java.util.List;
import java.util.Optional;

@Singleton
public class PokemonService {

    private final PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public List<Pokemon> get() {
        return pokemonRepository.findAll();
    }

    public Pokemon create(Pokemon pokemon) {
        Optional<Pokemon> byName = pokemonRepository.findByName(pokemon.getName());
        if (byName.isPresent()) {
            throw new PokemonExistsException("Name",pokemon.getName());
        }
        return pokemonRepository.save(pokemon);
    }

    public Pokemon update(Pokemon pokemon) {
        if (!pokemonRepository.existsById(pokemon.getId())) {
            throw new PokemonNotFoundException();
        }
        return pokemonRepository.update(pokemon);
    }

    public Pokemon getById(Integer id) {
        return pokemonRepository.findById(id).orElseThrow(() -> {
            throw new PokemonNotFoundException();
        });
    }

    public void deleteById(Integer id) {
        if (!pokemonRepository.existsById(id)) {
            throw new PokemonNotFoundException();
        }
        pokemonRepository.deleteById(id);
    }
}
