package com.Reyes.Veterinaria.Controller;


import com.Reyes.Veterinaria.Controller.dto.DuenioDTO;
import com.Reyes.Veterinaria.entities.Duenio;
import com.Reyes.Veterinaria.services.IDoctorService;
import com.Reyes.Veterinaria.services.IDuenioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/duenio")
public class DuenioController {

    @Autowired
    private IDuenioService serviceDuenio;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<DuenioDTO> duenioList = serviceDuenio.findAll().stream()
                .map(
                        duenio -> DuenioDTO.builder()
                                .idDuenio(duenio.getIdDuenio())
                                .nombre(duenio.getNombre())
                                .apellidoPaterno(duenio.getApellidoPaterno())
                                .apellidoMaterno(duenio.getApellidoMaterno())
                                .telefono(duenio.getTelefono())
                                .correo(duenio.getCorreo())
                                .mascotas(duenio.getMascotas())
                                .build())
                .toList();

        return ResponseEntity.ok(duenioList);
    }

    @GetMapping("/find/{idDuenio}")
    public ResponseEntity<?> findById(@PathVariable Long idDuenio){
        Optional<Duenio> dueniosOptional = serviceDuenio.findById(idDuenio);

        if (dueniosOptional.isPresent()){
            Duenio duenios = dueniosOptional.get();

            DuenioDTO duenioDto = DuenioDTO.builder()
                    .idDuenio(duenios.getIdDuenio())
                    .nombre(duenios.getNombre())
                    .apellidoPaterno(duenios.getApellidoPaterno())
                    .apellidoMaterno(duenios.getApellidoMaterno())
                    .telefono(duenios.getTelefono())
                    .correo(duenios.getCorreo())
                    .mascotas(duenios.getMascotas())
                    .build();

            return ResponseEntity.ok(duenioDto);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody DuenioDTO duenioDto){
        serviceDuenio.save(Duenio.builder()
                .nombre(duenioDto.getNombre())
                .apellidoPaterno(duenioDto.getApellidoPaterno())
                .apellidoMaterno(duenioDto.getApellidoMaterno())
                .telefono(duenioDto.getTelefono())
                .correo(duenioDto.getCorreo())
                .mascotas(duenioDto.getMascotas())
                .build()
        );

        return ResponseEntity.ok("Dueño Agregado Correctamente");
    }

    @PutMapping("/update/{idDuenio}")
    public ResponseEntity<?> updateById(@RequestBody DuenioDTO duenioDto, @PathVariable Long idDuenio){
        Optional<Duenio> dueniosOptional =serviceDuenio.findById(idDuenio);

        if (dueniosOptional.isPresent()){
            Duenio duenios = dueniosOptional.get();
            duenios.setNombre(duenioDto.getNombre());
            duenios.setApellidoPaterno(duenioDto.getApellidoPaterno());
            duenios.setApellidoMaterno(duenioDto.getApellidoMaterno());
            duenios.setTelefono(duenioDto.getTelefono());
            duenios.setCorreo(duenioDto.getCorreo());
            duenios.setMascotas(duenioDto.getMascotas());

            serviceDuenio.save(duenios);
            return ResponseEntity.ok("Se actualizo el duenio correctamente");
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{idDuenio}")
    public ResponseEntity<?> deleteById(@PathVariable Long idDuenio){
        if (idDuenio != null){
            serviceDuenio.deleteById(idDuenio);
            return ResponseEntity.ok("Eliminado Correctamente");
        }
        return ResponseEntity.notFound().build();
    }


}
