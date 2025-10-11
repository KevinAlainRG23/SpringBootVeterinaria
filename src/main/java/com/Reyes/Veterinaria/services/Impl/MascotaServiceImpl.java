package com.Reyes.Veterinaria.services.Impl;

import com.Reyes.Veterinaria.entities.Mascota;
import com.Reyes.Veterinaria.persistences.IMascotaDAO;
import com.Reyes.Veterinaria.services.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MascotaServiceImpl implements IMascotaService {

    @Autowired
    private IMascotaDAO mascotadao;


    @Override
    public List<Mascota> findAll() {
        return List.of();
    }

    @Override
    public Optional<Mascota> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Mascota mascota) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
