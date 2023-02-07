package com.testapi.pokemon;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.netty.handler.codec.http.HttpResponseStatus;

import java.util.List;
import java.util.Objects;

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
        try {
            Pokemon savedPokemon = pokemonService.create(pokemon);
            return HttpResponse.created(savedPokemon);
        } catch (PokemonExistsException e) {
            return HttpResponse.badRequest();
        }
    }

    @Put
    public HttpResponse<Pokemon> update(@Body Pokemon pokemon) {
        try {
            Pokemon updatedPokemon = pokemonService.update(pokemon);
            return HttpResponse.created(updatedPokemon);
        } catch (PokemonNotFoundException e) {
            return HttpResponse.notFound();
        }
    }

    @Delete("/{id}")
    public HttpResponseStatus deleteById(@PathVariable Integer id) {
        try {
            pokemonService.deleteById(id);
            return HttpResponseStatus.OK;
        } catch (PokemonNotFoundException e) {
            return HttpResponseStatus.NOT_FOUND;
        }
    }
}
