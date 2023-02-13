package com.testapi.pokemon;

import com.testapi.exeption.EntityAlreadyExistsException;
import com.testapi.exeption.EntityNotFoundException;
import com.testapi.power.Power;
import com.testapi.power.PowerService;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.Optional;

@Singleton
public class PokemonService {

    private final PokemonRepository pokemonRepository;
    private final PowerService powerService;

    public PokemonService(PokemonRepository pokemonRepository, PowerService powerService) {
        this.pokemonRepository = pokemonRepository;
        this.powerService = powerService;
    }

    public List<Pokemon> get() {
        return pokemonRepository.findAll();
    }

    public Pokemon create(PokemonCreationForm pokemonForm) {
        Optional<Pokemon> byName = pokemonRepository.findByName(pokemonForm.getName());
        if (byName.isPresent()) {
            throw new EntityAlreadyExistsException("Pokemon already exists with Name: " + pokemonForm.getName());
        }
        Power foundPower = powerService.getByName(pokemonForm.getPower());
        Pokemon pokemon = new Pokemon();
        pokemon.setName(pokemonForm.getName());
        pokemon.setPower(foundPower);
        pokemon.setImageUrl("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/" + pokemonForm.getImageId() + ".png");
        return pokemonRepository.save(pokemon);
    }

    public Pokemon update(Integer id, PokemonCreationForm pokemon) {
        if (!pokemonRepository.existsById(id)) {
            throw new EntityNotFoundException("Pokemon not found with id " + id);
        }
        Power foundPower = powerService.getByName(pokemon.getPower());
        Pokemon p = new Pokemon();
        p.setId(id);
        p.setName(pokemon.getName());
        p.setPower(foundPower);
        p.setImageUrl("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/" + pokemon.getImageId() + ".png");
        return pokemonRepository.update(p);
    }

    public Pokemon getById(Integer id) {
        return pokemonRepository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException("Pokemon not found with id " + id);
        });
    }

    public void deleteById(Integer id) {
        if (!pokemonRepository.existsById(id)) {
            throw new EntityNotFoundException("Pokemon not found with id " + id);
        }
        pokemonRepository.deleteById(id);
    }
}
