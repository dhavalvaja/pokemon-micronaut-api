package com.testapi.pokemon;

import jakarta.inject.Singleton;
import org.hibernate.DuplicateMappingException;
import org.hibernate.ObjectNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Singleton
public class PokemonService {

    private final PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public List<Pokemon> get() {
        return (List<Pokemon>) pokemonRepository.findAll();
    }

    public Pokemon create(Pokemon pokemon) throws Exception {
        List<Pokemon> pokemonList = get();
        pokemonList.forEach(p -> {
            if (Objects.equals(p.getName(), pokemon.getName())) {
                throw new RuntimeException("Pokemon already exists!!!");
            }
        });
        return pokemonRepository.save(pokemon);
    }

    public Pokemon update(Pokemon pokemon) throws ObjectNotFoundException {
        if (pokemonRepository.existsById(pokemon.getId())) {
            return pokemonRepository.update(pokemon);
        } else {
            throw new ObjectNotFoundException(Pokemon.class, "Pokemon");
        }
    }

    public Pokemon getById(Integer id) throws ObjectNotFoundException {
        return pokemonRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("No pokemon found with id: " + id);
        });
    }

    public void deleteById(Integer id) throws ObjectNotFoundException {
        if (pokemonRepository.existsById(id)) {
            pokemonRepository.deleteById(id);
        } else {
            throw new ObjectNotFoundException(Pokemon.class, "Pokemon");
        }
    }
}
