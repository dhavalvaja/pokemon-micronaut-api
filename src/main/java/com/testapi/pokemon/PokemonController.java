package com.testapi.pokemon;

import com.testapi.exeption.PokemonExistsException;
import com.testapi.exeption.PokemonNotFoundException;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

import java.util.List;

@Controller("/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @Get()
    public List<Pokemon> getPokemonList() {
        return pokemonService.get();
    }

    @Get("/{id}")
    public Pokemon getById(@PathVariable Integer id) {
        return pokemonService.getById(id);
    }

    @Post
    public HttpResponse<Pokemon> create(@Body Pokemon pokemon) {
        Pokemon savedPokemon = pokemonService.create(pokemon);
        return HttpResponse.created(savedPokemon);
    }

    @Put
    public HttpResponse<Pokemon> update(@Body Pokemon pokemon) {
        Pokemon updatedPokemon = pokemonService.update(pokemon);
        return HttpResponse.created(updatedPokemon);
    }

    @Delete("/{id}")
    public HttpResponse<String> deleteById(@PathVariable Integer id) {
        pokemonService.deleteById(id);
        return HttpResponse.ok();
    }
}
