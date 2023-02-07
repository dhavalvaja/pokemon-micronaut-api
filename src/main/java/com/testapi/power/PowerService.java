package com.testapi.power;

import com.testapi.exeption.EntityNotFoundException;
import jakarta.inject.Singleton;

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
}
