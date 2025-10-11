package com.Reyes.Veterinaria.persistences.Impl;

import com.Reyes.Veterinaria.entities.Duenio;
import com.Reyes.Veterinaria.persistences.IDueniosDAO;
import com.Reyes.Veterinaria.repository.DuenioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DueniosDAOImpl implements IDueniosDAO {

    @Autowired
private DuenioRepository repository;

    @Override
    public List<Duenio> findAll() {
        return (List<Duenio>) repository.findAll();
    }

    @Override
    public Optional<Duenio> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(Duenio duenio) {
        repository.save(duenio);
    }


    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
