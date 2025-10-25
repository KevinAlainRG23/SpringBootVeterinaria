package com.Reyes.Veterinaria.services.Impl;

import com.Reyes.Veterinaria.entities.Duenio;
import com.Reyes.Veterinaria.persistences.IDueniosDAO;
import com.Reyes.Veterinaria.services.IDuenioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DuenioServiceImpl implements IDuenioService {

   @Autowired
   private IDueniosDAO dueniosdao;


    @Override
    public List<Duenio> findAll() {
        return dueniosdao.findAll();
    }

    @Override
    public Optional<Duenio> findById(Long idDuenio) {
        return dueniosdao.findById(id);
    }

    @Override
    public void save(Duenio duenio) {
dueniosdao.save(duenio);
    }

    @Override
    public void deleteById(Long idDuenio) {
dueniosdao.deleteById(idDuenio);
    }
}
