package com.Reyes.Veterinaria.services.Impl;

import com.Reyes.Veterinaria.entities.Pago;
import com.Reyes.Veterinaria.persistences.IPagoDAO;
import com.Reyes.Veterinaria.services.IPagoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PagoServiceImpl implements IPagoService {

    @Autowired
    private IPagoDAO pagodao;


    @Override
    public List<Pago> findAll() {
        return pagodao.findAll();
    }

    @Override
    public Optional<Pago> findById(Long id) {
        return pagodao.findById(id);
    }

    @Override
    public void save(Pago pago) {
pagodao.save(pago);
    }

    @Override
    public void deleteById(Long id) {
pagodao.deleteById(id);
    }
}
