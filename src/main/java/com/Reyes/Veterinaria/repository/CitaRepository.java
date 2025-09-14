package com.Reyes.Veterinaria.repository;

import com.Reyes.Veterinaria.entities.Cita;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepository extends CrudRepository <Cita, Long> {
}
