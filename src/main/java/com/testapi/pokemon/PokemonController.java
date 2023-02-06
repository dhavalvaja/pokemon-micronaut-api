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
    public Pokemon getPokemonById(@PathVariable Integer id){
        return pokemonService.getById(id);
    }

    @Post
    public List<Pokemon> create(@Body Pokemon pokemon){
        return pokemonService.create(pokemon);
    }

    @Put
    public Pokemon edit(@Body Pokemon pokemon){
        return pokemonService.edit(pokemon);
    }

}
