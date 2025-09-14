package com.Reyes.Veterinaria.repository;

import com.Reyes.Veterinaria.entities.Pago;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepository  extends CrudRepository <Pago, Long> {

}
