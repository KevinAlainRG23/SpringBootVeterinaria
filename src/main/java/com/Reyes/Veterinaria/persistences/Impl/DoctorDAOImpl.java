package com.Reyes.Veterinaria.persistences.Impl;

import com.Reyes.Veterinaria.entities.Doctor;
import com.Reyes.Veterinaria.persistences.IDoctorDAO;
import com.Reyes.Veterinaria.repository.DoctorReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DoctorDAOImpl implements IDoctorDAO {

 @Autowired
private DoctorReposity repository;
    @Override
    public List<Doctor> findAll() {
        return (List<Doctor>) repository.findAll();
    }

    @Override
    public Optional<Doctor> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(Doctor doctor) {
        repository.save(doctor);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
