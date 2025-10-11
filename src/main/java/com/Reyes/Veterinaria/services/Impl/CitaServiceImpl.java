package com.Reyes.Veterinaria.services.Impl;

import com.Reyes.Veterinaria.entities.Cita;
import com.Reyes.Veterinaria.persistences.ICitaDAO;
import com.Reyes.Veterinaria.services.ICitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class CitaServiceImpl implements ICitaService {
    @Autowired
    private ICitaDAO service;

    @Override
    public List<Cita> findAll() {
        return (List<Cita>) service.findAll();
    }

    @Override
    public ResponseEntity<?> findById(Long id) {
        return service.findById(id);
    }

    @Override
    public void save(Cita cita) {
        service.save(cita);
    }

    @Override
    public void deleteById(Long id) {
       service.deleteById(id);
    }

}
