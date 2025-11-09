package com.Reyes.Veterinaria.persistences;

import com.Reyes.Veterinaria.entities.Mascota;
import com.Reyes.Veterinaria.entities.Pago;

import java.util.List;
import java.util.Optional;

public interface IPagoDAO {

    List<Pago> findAll();
    Optional<Pago> findById(Long idPago);

    void save(Pago pago);

    void deleteById(Long idPago);




}
