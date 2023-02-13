package com.testapi.power;

import com.testapi.exeption.EntityAlreadyExistsException;
import com.testapi.exeption.EntityNotFoundException;
import com.testapi.pokemon.Pokemon;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.Optional;

@Singleton
public class PowerService {

    private final PowerRepository powerRepository;

    public PowerService(PowerRepository powerRepository) {
        this.powerRepository = powerRepository;
    }

    public Power get(Integer id) {
        return powerRepository
                .findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("Power not found with id " + id)
                );
    }

    public List<Power> getAll() {
        return powerRepository.findAll();
    }

    public Power getByName(String name){
        Optional<Power> byName = powerRepository.findByName(name);
        if (byName.isPresent()) {
            return byName.get();
        }
        throw new EntityAlreadyExistsException("power not found with Name: " + name);
    }

    public Power create(PowerForm powerForm) {
        Optional<Power> byName = powerRepository.findByName(powerForm.getName());
        if (byName.isPresent()) {
            throw new EntityAlreadyExistsException("Power already exists with Name" + powerForm.getName());
        }
        Power power = new Power();
        power.setName(powerForm.getName());
        return powerRepository.save(power);
    }
}
