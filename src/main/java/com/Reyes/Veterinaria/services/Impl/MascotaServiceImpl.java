package com.Reyes.Veterinaria.services.Impl;

import com.Reyes.Veterinaria.entities.Mascota;
import com.Reyes.Veterinaria.persistences.IMascotaDAO;
import com.Reyes.Veterinaria.services.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MascotaServiceImpl implements IMascotaService {

    @Autowired
    private IMascotaDAO mascotadao;


    @Override
    public List<Mascota> findAll() {
        return mascotadao.findAll();
    }

    @Override
    public Optional<Mascota> findById(Long idMascota) {
        return mascotadao.findById(idMascota);
    }

    @Override
    public void save(Mascota mascota) {
mascotadao.save(mascota);
    }

    @Override
    public void deleteById(Long idMascota) {
mascotadao.deleteById(idMascota);
    }
}
