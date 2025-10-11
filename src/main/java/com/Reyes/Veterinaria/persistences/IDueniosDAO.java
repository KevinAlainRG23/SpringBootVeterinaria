package com.Reyes.Veterinaria.persistences;

import com.Reyes.Veterinaria.entities.Duenio;

import java.util.List;
import java.util.Optional;

public interface IDueniosDAO {

    List<Duenio> findAll();
    Optional<Duenio> findById(Long id);

    void save(Duenio duenio);

    void deleteById(Long id);

}
