package com.Reyes.Veterinaria.Controller;

import com.Reyes.Veterinaria.Controller.dto.CitaDTO;
import com.Reyes.Veterinaria.Controller.dto.DoctorDTO;
import com.Reyes.Veterinaria.entities.Doctor;
import com.Reyes.Veterinaria.services.IDoctorService;
import com.Reyes.Veterinaria.services.Impl.DoctorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("api/doctor")
public class DoctorController  {

    @Autowired
   private IDoctorService serviceDoctor;

@GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
    Optional <Doctor> doctorOptional = serviceDoctor.findById(id);

        if(doctorOptional.isPresent()){
            Doctor doctor = doctorOptional.get();

            DoctorDTO doctorDTO=  DoctorDTO.builder()
                    .idDoctor(doctor.getIdDoctor())
                    .nombre(doctor.getNombre())
                    .apellidoPaterno(doctor.getApellidoPaterno())
                    .apellidoMaterno(doctor.getApellidoMaterno())
                    .cedula(doctor.getCedula())
                    .telefono(doctor.getTelefono())
                    .domicilio(doctor.getDomicilio())
                    .build();
            return ResponseEntity.ok(doctorDTO);
        }
    return ResponseEntity.notFound().build();
    }
@GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<DoctorDTO> doctorList = serviceDoctor.findAll().stream()
                .map( doctor -> DoctorDTO.builder()
                        .idDoctor(doctor.getIdDoctor())
                        .nombre(doctor.getNombre())
                        .apellidoPaterno(doctor.getApellidoPaterno())
                        .apellidoMaterno(doctor.getApellidoMaterno())
                        .cedula(doctor.getCedula())
                        .telefono(doctor.getTelefono())
                        .domicilio(doctor.getDomicilio())
                        .build())
                .toList();

        return ResponseEntity.ok(doctorList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save (@RequestBody   DoctorDTO doctordto){
    if(doctordto.getNombre().isBlank() && doctordto.getApellidoPaterno().isBlank() && doctordto.getCedula().isBlank()){
            return ResponseEntity.badRequest().build();
        }
serviceDoctor.save(Doctor.builder()
        .nombre(doctordto.getNombre())
        .apellidoPaterno(doctordto.getApellidoPaterno())
        .apellidoMaterno(doctordto.getApellidoMaterno())
        .cedula(doctordto.getCedula())
        .telefono(doctordto.getTelefono())
        .domicilio(doctordto.getDomicilio())
        .build());
    return ResponseEntity.ok("Doctor agregado ");
    }
   @PutMapping("/update/{idDoctor}")
    public ResponseEntity<?> updateDoctor( @PathVariable Long idDoctor, @RequestBody DoctorDTO doctordto){

  Optional<Doctor> optionalDoctor=serviceDoctor.findById(idDoctor);
  if(optionalDoctor.isPresent()){
      Doctor doctor= optionalDoctor.get();
doctor.setNombre(doctordto.getNombre());
doctor.setApellidoPaterno(doctordto.getApellidoPaterno());
doctor.setApellidoMaterno(doctordto.getApellidoMaterno());
doctor.setCedula(doctordto.getCedula());
doctor.setTelefono(doctordto.getTelefono());
doctor.setDomicilio(doctordto.getDomicilio());

serviceDoctor.save(doctor);
return ResponseEntity.ok("registro actualizado");

  }
return ResponseEntity.badRequest().build();
    }

@DeleteMapping("/delete/{idDoctor}")
public ResponseEntity<?>deleteById(@PathVariable Long idDoctor){

    if(idDoctor != null){
        serviceDoctor.deleteById(idDoctor);
        return ResponseEntity.ok("registro eliminado");
    }
return ResponseEntity.notFound().build();
}
    
    
}




