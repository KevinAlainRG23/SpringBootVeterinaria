package com.Reyes.Veterinaria.services;

import com.Reyes.Veterinaria.entities.Doctor;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IDoctorService {

    List<Doctor> findAll();
   Optional<Doctor> findById(Long id);
    void save (Doctor doctor);
    void deleteById(Long id);

}
