package com.Reyes.Veterinaria.services;
import com.Reyes.Veterinaria.entities.Duenio;
import com.Reyes.Veterinaria.entities.Mascota;

import java.util.List;
import java.util.Optional;
public interface IDuenioService {
    List<Duenio>findAll();
    Optional<Duenio> findById(Long idDuenio);
    void save(Duenio duenio);
    void deleteById(Long idDuenio);
}

