package com.Reyes.Veterinaria.services.Impl;

import com.Reyes.Veterinaria.entities.Doctor;
import com.Reyes.Veterinaria.persistences.IDoctorDAO;
import com.Reyes.Veterinaria.services.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DoctorServiceImpl implements IDoctorService {

    @Autowired
    private IDoctorDAO doctordao;


    @Override
    public List<Doctor> findAll() {

        return doctordao.findAll();
    }

    @Override
    public Optional<Doctor> findById(Long id) {
        return  doctordao.findById(id);
    }


    @Override
    public void save(Doctor doctor) {
doctordao.save(doctor);
    }

    @Override
    public void deleteById(Long id) {
doctordao.deleteById(id);
    }
}
