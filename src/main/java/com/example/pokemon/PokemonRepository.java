package com.example.pokemon;

import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class PokemonRepository {

    private final List<Pokemon> store;

    PokemonRepository(){
        store = new ArrayList<>();
        store.add(new Pokemon(
                "001",
                "pikachu",
                "thunder",
                "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/025.png"));
        store.add(new Pokemon(
                "002",
                "bulbasaur",
                "grass",
                "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/001.png"));
        store.add(new Pokemon(
                "003",
                "paras",
                "bug",
                "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/046.png"));
    }

    public List<Pokemon> get() {
        return store;
    }
}
