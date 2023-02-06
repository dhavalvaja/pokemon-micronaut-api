package com.testapi.pokemon;

import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Singleton
public class PokemonRepository {

    private final List<Pokemon> store;
    private Integer nextId;

    PokemonRepository(){
        store = new ArrayList<>();
        nextId = 1;
        create(new Pokemon(
                1,
                "pikachu",
                "thunder",
                "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/025.png"));
        create(new Pokemon(
                2,
                "bulbasaur",
                "grass",
                "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/001.png"));
        create(new Pokemon(
                3,
                "paras",
                "bug",
                "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/046.png"));
    }

    public List<Pokemon> get() {
        return Collections.unmodifiableList(store);
    }

    public List<Pokemon> create(Pokemon pokemon) {
        pokemon.setId(nextId++);
        store.add(pokemon);
        return store;
    }

    public Pokemon edit(Pokemon pokemon) {
        Pokemon p = getById(pokemon.getId());
        p.setName(pokemon.getName());
        p.setPower(pokemon.getPower());
        p.setImageUrl(pokemon.getImageUrl());
        return p;
    }

    public Pokemon getById(Integer id) {
        return store
                .stream()
                .filter(p->p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
