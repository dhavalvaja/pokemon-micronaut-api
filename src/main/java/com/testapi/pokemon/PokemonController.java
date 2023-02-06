package com.testapi.pokemon;

import io.micronaut.http.annotation.*;

import java.util.List;

@Controller("/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @Get()
    public List<Pokemon> getPokemonList(){
        return pokemonService.get();
    }

    @Get("/{id}")
    public Pokemon getById(@PathVariable Integer id){
        return pokemonService.getById(id);
    }

    @Post
    public Pokemon create(@Body Pokemon pokemon) throws Exception {
        return pokemonService.create(pokemon);
    }

    @Put
    public Pokemon update(@Body Pokemon pokemon){
        return pokemonService.update(pokemon);
    }

    @Delete("/{id}")
    public void deleteById(@PathVariable Integer id){
        pokemonService.deleteById(id);
    }
}
