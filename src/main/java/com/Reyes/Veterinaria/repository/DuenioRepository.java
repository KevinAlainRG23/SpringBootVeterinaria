package com.Reyes.Veterinaria.repository;

import com.Reyes.Veterinaria.entities.Duenio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuenioRepository extends CrudRepository <Duenio, Long> {
}
