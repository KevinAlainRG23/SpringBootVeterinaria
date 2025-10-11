package com.Reyes.Veterinaria.services;

import com.Reyes.Veterinaria.entities.Doctor;
import java.util.List;
import java.util.Optional;
public interface IDoctorService {

    List<Doctor> findAll();

    Doctor findById(Long id);

    void save (Doctor doctor);
    void deleteById(Long id);

}
