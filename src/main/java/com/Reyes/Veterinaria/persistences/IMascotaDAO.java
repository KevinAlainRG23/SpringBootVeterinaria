package com.Reyes.Veterinaria.persistences;

import com.Reyes.Veterinaria.entities.Duenio;
import com.Reyes.Veterinaria.entities.Mascota;

import java.util.List;
import java.util.Optional;

public interface IMascotaDAO {
    List<Mascota> findAll();
    Optional<Mascota> findById(Long idMascota);

    void save(Mascota mascota);

    void deleteById(Long idMascota);

}
