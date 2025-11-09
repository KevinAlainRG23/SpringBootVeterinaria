package com.Reyes.Veterinaria.Controller;


import com.Reyes.Veterinaria.Controller.dto.MacotaDTO;
import com.Reyes.Veterinaria.entities.Mascota;
import com.Reyes.Veterinaria.services.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Mascota")
public class MascotaController {
    @Autowired
    private IMascotaService serviceMascota;

    @GetMapping("/finAll")
    public ResponseEntity<?> finAll(){
        List<MacotaDTO> mascotaList = serviceMascota.findAll().stream()
                .map(mascota -> MacotaDTO.builder()
                        .idMascota(mascota.getIdMascota())
                        .nombre(mascota.getNombre())
                        .tipo(mascota.getTipo())
                        .raza(mascota.getRaza())
                        .duenio(mascota.getDuenio())
                        .build())
                .toList();

        return ResponseEntity.ok(mascotaList);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long idMascota){
        Optional<Mascota> mascotaOptional =  serviceMascota.findById(idMascota);

        if (mascotaOptional.isPresent()){
            Mascota mascota = mascotaOptional.get();

            MacotaDTO mascotaDto = MacotaDTO.builder()
                    .idMascota(mascota.getIdMascota())
                    .nombre(mascota.getNombre())
                    .tipo(mascota.getTipo())
                    .raza(mascota.getRaza())
                    .duenio(mascota.getDuenio())
                    .build();

            return ResponseEntity.ok(mascotaDto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/save")
    public ResponseEntity<?> save (@RequestBody MacotaDTO mascotaDto){
        serviceMascota.save(Mascota.builder()
                .nombre(mascotaDto.getNombre())
                .tipo(mascotaDto.getTipo())
                .raza(mascotaDto.getRaza())
                .duenio(mascotaDto.getDuenio())
                .build());

        return ResponseEntity.ok("Mascota registrada");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateById(@RequestBody MacotaDTO mascotaDto, @PathVariable Long idMascota){
        Optional<Mascota> optionalMascota = serviceMascota.findById(idMascota);

        if (optionalMascota.isPresent()){
            Mascota mascota = optionalMascota.get();
            mascota.setNombre(mascotaDto.getNombre());
            mascota.setTipo(mascotaDto.getTipo());
            mascota.setRaza(mascotaDto.getRaza());
            mascota.setDuenio(mascotaDto.getDuenio());

            serviceMascota.save(mascota);

            return ResponseEntity.ok("Datos de la mascota actualizados");
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{idMascota}")
    public String deleteById(@PathVariable Long idMascota){
        if (idMascota != null){
            serviceMascota.deleteById(idMascota);
            return "Se elimino la mascota";
        }
        return "No se pudo eliminar la mascota";
    }


}
