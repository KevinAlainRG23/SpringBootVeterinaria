package com.Reyes.Veterinaria.persistences;

import com.Reyes.Veterinaria.entities.Doctor;

import java.util.List;
import java.util.Optional;

public interface IDoctorDAO {

    List<Doctor> findAll();

    Optional<Doctor> findById(Long id);
    void save (Doctor doctor);
    void deleteById(Long id);

}
