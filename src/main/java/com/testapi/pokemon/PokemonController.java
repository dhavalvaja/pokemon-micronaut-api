package com.testapi.pokemon;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller("/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @Get()
    public List<PokemonDTO> getPokemonList() {
        return pokemonService.get().stream().map(PokemonDTO::new).collect(Collectors.toList());
    }

    @Get("/{id}")
    public PokemonDTO getById(@PathVariable Integer id) {
        return new PokemonDTO(pokemonService.getById(id));
    }

    @Post
    public HttpResponse<PokemonDTO> create(@Body PokemonCreationForm pokemon) {
        Pokemon savedPokemon = pokemonService.create(pokemon);
        return HttpResponse.created(new PokemonDTO(savedPokemon));
    }

    @Put("/{id}")
    public HttpResponse<PokemonDTO> update(@Body PokemonUpdateForm pokemon,@PathVariable Integer id) {
        Pokemon updatedPokemon = pokemonService.update(id,pokemon);
        return HttpResponse.created(new PokemonDTO(updatedPokemon));
    }

    @Delete("/{id}")
    public HttpResponse<String> deleteById(@PathVariable Integer id) {
        pokemonService.deleteById(id);
        return HttpResponse.ok();
    }
}
