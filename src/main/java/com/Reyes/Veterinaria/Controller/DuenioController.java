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
    public ResponseEntity<?>findAll(){
        List<DuenioDTO> dueniolist = serviceDuenio.findAll().stream()
                .map(
                        duenio->DuenioDTO.builder()
                                .idDuenio(duenio.getIdDueño())
                                .nombre(duenio.getNombre())
                                .apellidoPaterno(duenio.getApellidoPaterno())
                                .apellidoMaterno(duenio.getApellidoMaterno())
                                .telefono(duenio.getTelefono())
                                .correo(duenio.getCorreo())
                                .mascotas(duenio.getMascotas())
                                .build())
                                .toList();
       return ResponseEntity.ok(dueniolist);
    }

@GetMapping("/find/{idDuenio}")
    public ResponseEntity findById (@PathVariable Long idDuenio){
Optional<Duenio> duenioOptional=serviceDuenio.findById(idDuenio);

        if(duenioOptional.isPresent()){
            Duenio duenio = duenioOptional.get();



            DuenioDTO duenioDTO= DuenioDTO.builder()
                    .idDuenio(duenio.getIdDueño())
                    .nombre(duenio.getNombre())
                    .apellidoPaterno(duenio.getApellidoPaterno())
                    .apellidoMaterno(duenio.getApellidoMaterno())
                    .telefono(duenio.getTelefono())
                    .correo(duenio.getCorreo())
                    .mascota(duenio.getMascotas())
                    .build();

            return  ResponseEntity.ok(duenioDTO);
        }
return ResponseEntity.notFound().build();


    }

    @PostMapping("/save")
public ResponseEntity <?> save(@RequestBody DuenioDTO duenioDTO){

        serviceDuenio.save(Duenio.builder()
                .nombre(duenioDTO.getNombre())
                .apellidoPaterno(duenioDTO.getApellidoPaterno())
                .apellidoMaterno(duenioDTO.getApellidoMaterno())
                .telefono(duenioDTO.getTelefono())
                .correo(duenioDTO.getCorreo())
                .mascota(duenioDTO.getMascotas())
                .build()
        );

        return ResponseEntity.ok("DUeño agregao");
}

@PutMapping("/update/{idDuenio}")
public ResponseEntity<?> updateById(@RequestBody DuenioDTO duenioDTO, @PathVariable Long idDuenio){

        Optional<Duenio> duenioOptional = serviceDuenio.findById(idDuenio);

        if(duenioOptional.isPresent()){
            Duenio duenio = duenioOptional.get();

            duenio.setNombre(duenioDTO.getNombre());
            duenio.setApellidoPaterno(duenioDTO.getApellidoPaterno());
            duenio.setApellidoMaterno(duenioDTO.getApellidoMaterno());
            duenio.setTelefono(duenioDTO.getTelefono());
            duenio.setCorreo(duenioDTO.getCorreo());
            duenio.setMascotas(duenioDTO.getMascotas());

            return ResponseEntity.ok("se actualizao dueño");
        }
return ResponseEntity.badRequest().build();

        @DeleteMapping("/delete/{idDuenio}")
        public ResponseEntity <?> deleteById(@PathVariable Long idDuenio){
            if(idDuenio =! null){
                serviceDuenio.deleteById(idDuenio);
                return ResponseEntity.ok("eliminado");
            }
            return ResponseEntity.notFound().build();
    }
}


}
