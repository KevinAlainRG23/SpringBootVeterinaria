package com.Reyes.Veterinaria.services.Impl;

import com.Reyes.Veterinaria.entities.Cita;
import com.Reyes.Veterinaria.persistences.ICitaDAO;
import com.Reyes.Veterinaria.services.ICitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitaServiceImpl implements ICitaService {

    @Autowired
    private ICitaDAO service;

    @Override
    public List<Cita> findAll() {
        return  service.findAll();
    }

    @Override
    public Optional<Cita> findById(Long idCita) {
        return service.findById(idCita);
    }

    @Override
    public void save(Cita cita) {
        service.save(cita);
    }

    @Override
    public void deleteById(Long idCita) {
       service.deleteById(idCita);
    }

}
