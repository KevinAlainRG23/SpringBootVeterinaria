package com.Reyes.Veterinaria.services;
import com.Reyes.Veterinaria.entities.Pago;

import java.util.List;
import java.util.Optional;
public interface IPagoService {
    List<Pago> findAll();
    Optional<Pago>findById(Long id);
    void save(Pago pago);
    void deleteById(Long id);

}
