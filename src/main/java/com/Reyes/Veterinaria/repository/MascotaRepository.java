package com.Reyes.Veterinaria.repository;

import com.Reyes.Veterinaria.entities.Mascota;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotaRepository extends CrudRepository <Mascota ,Long> {
}
