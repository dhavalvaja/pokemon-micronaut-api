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
            throw new EntityAlreadyExistsException("Pokemon already exists with Name" + pokemonForm.getName());
        }
        Power foundPower = powerService.get(pokemonForm.getPowerId());
        Pokemon pokemon = new Pokemon();
        pokemon.setName(pokemonForm.getName());
        pokemon.setPower(foundPower);
        return pokemonRepository.save(pokemon);
    }

    public Pokemon update(Integer id, PokemonUpdateForm pokemon) {
        if (!pokemonRepository.existsById(id)) {
            throw new EntityNotFoundException("Pokemon not found with id " + id);
        }
        Power foundPower = powerService.get(pokemon.getPowerId());
        Pokemon p = new Pokemon();
        p.setName(pokemon.getName());
        p.setPower(foundPower);
        return pokemonRepository.updateById(id, p);
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
