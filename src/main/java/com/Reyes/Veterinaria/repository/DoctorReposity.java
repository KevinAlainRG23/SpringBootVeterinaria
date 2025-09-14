package com.Reyes.Veterinaria.repository;

import com.Reyes.Veterinaria.entities.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorReposity extends CrudRepository <Doctor, Long> {
}
