package com.Reyes.Veterinaria.Controller;


import com.Reyes.Veterinaria.Controller.dto.CitaDTO;
import com.Reyes.Veterinaria.entities.Cita;
import com.Reyes.Veterinaria.services.ICitaService;
import com.Reyes.Veterinaria.services.Impl.CitaServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/cita")
public class CitaController extends CitaServiceImpl {

    private ICitaService citaService;

    @GetMapping("/find/{id}")

    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Cita> citaoptional = citaService.findById(id);
        if(citaoptional.isPresent()){
            Cita cita =citaoptional.get();

            CitaDTO citaDTO=  CitaDTO.builder()
                    .idCita(cita.getIdCita())
                    .fecha(cita.getFecha())
                    .hora(cita.getHora())
                    .doctor(cita.getDoctor())
                    .duenio(cita.getDuenio())
                    .mascota(cita.getMascota())
                    .build();
            return ResponseEntity.ok(citaDTO);
        }
        return ResponseEntity.notFound().build();
    }


}
