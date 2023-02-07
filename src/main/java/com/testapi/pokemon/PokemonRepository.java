package com.testapi.pokemon;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface PokemonRepository extends CrudRepository<Pokemon, Integer> {

    Optional<Pokemon> findByName(String name);

    List<Pokemon> findAll();

    Pokemon updateById(Integer id, Pokemon pokemon);
}
