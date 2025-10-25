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

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<MacotaDTO> mascotaList=serviceMascota.findAll().stream()
                .map(mascota -> MacotaDTO.builder()
                        .idMascota(mascota.getIdMascota())
                        .nombre(mascota.getNombre())
                        .tipo(mascota.getTipo())
                        .duenio(mascota.getDuenio())
                        .build())
        .toList();

        return ResponseEntity.ok(mascotaList);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long idMascota) {
        Optional<Mascota> mascotaOptional = serviceMascota.findById(idMascota);

if(mascotaOptional.isPresent()){
     Mascota mascota = mascotaOptional.get();

     MacotaDTO mascotaDTO =MacotaDTO.builder();

}


return ResponseEntity.ok(mascotaDTO);
    }


@PutMapping("/update/{id}")
   public ResponseEntity <?> updateById(@RequestBody MacotaDTO macotaDTO, @PathVariable Long idMascota){
        Optional<Mascota> optionalMascota=serviceMascota.findById(idMascota);

        if(optionalMascota.isPresent()){
            Mascota mascota = optionalMascota.get();
            mascota.setNombre(MacotaDTO);
            return ResponseEntity.ok("Datos de la mascota actualizados");
        }
        return  ResponseEntity.badRequest().build();
   }

@DeleteMapping("/delete/{idMascota}")
   public String deleteById(@PathVariable Long idMascota){
        if(idMascota != null){
            serviceMascota.deleteById(idMascota);
            return "se elimino la mascota";
        }
return "No se pudo eliminar la mascota";
   }



}
