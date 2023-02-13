package com.testapi.power;

import com.testapi.pokemon.Pokemon;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PowerRepository extends CrudRepository<Power, Integer> {

    Optional<Power> findByName(String name);

    List<Power> findAll();
}
