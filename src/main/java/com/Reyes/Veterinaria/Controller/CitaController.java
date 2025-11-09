package com.Reyes.Veterinaria.Controller;


import com.Reyes.Veterinaria.Controller.dto.CitaDTO;
import com.Reyes.Veterinaria.entities.Cita;
import com.Reyes.Veterinaria.entities.Pago;
import com.Reyes.Veterinaria.services.ICitaService;
import com.Reyes.Veterinaria.services.Impl.CitaServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cita")
public class CitaController {

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

@GetMapping("/findAll")
public ResponseEntity<?>findAll(){
      List<CitaDTO> citas = citaService.findAll().stream()
              .map(cita-> CitaDTO.builder()
                      .idCita(cita.getIdCita())
                      .fecha(cita.getFecha())
                      .hora(cita.getHora())
                      .doctor(cita.getDoctor())
                      .duenio(cita.getDuenio())
                      .mascota(cita.getMascota())
                      .build())
                      .toList();
              return ResponseEntity.ok(citas);

}
@PostMapping("/save")
    public String save(@RequestBody CitaDTO citadto){
        citaService.save(Cita.builder()
                .fecha(citadto.getFecha())
                .hora(citadto.getHora())
                .doctor(citadto.getDoctor())
                .duenio(citadto.getDuenio())
                .mascota(citadto.getMascota())
                .build());
        return "cita guardada correctamente";

    }
    @PutMapping("/update/{idCita}")
  public String update (@RequestBody CitaDTO citaDto , @PathVariable Long idCita){
        Optional<Cita> citaOptional = citaService.findById(idCita);
        if(citaOptional.isPresent()){
            Cita cita= citaOptional.get();
            cita.setFecha(citaDto.getFecha());
            cita.setHora(citaDto.getHora());
            cita.setDoctor(citaDto.getDoctor());
            cita.setDuenio(citaDto.getDuenio());
            cita.setMascota(citaDto.getMascota());
            return "Cita actualizada correctamente";
        }
        return "La cita no se encontro";
  }

    @DeleteMapping("/delete/{idCita}")
    public String deleteById(@PathVariable Long idCita) {
        if (idCita != null) {
            citaService.deleteById(idCita);
            return "cita eliminada correctamente";
        }
        return "cita no encontrada";
    }

}
