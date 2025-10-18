package com.Reyes.Veterinaria.services;
import com.Reyes.Veterinaria.entities.Cita;
import com.Reyes.Veterinaria.entities.Doctor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
public interface
ICitaService
{
    List<Cita>findAll();
   Optional<Cita> findById(Long id );
    void save (Cita cita);
    void deleteById(Long id);
}
