package com.Reyes.Veterinaria.Controller.dto;

import com.Reyes.Veterinaria.entities.Mascota;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DuenioDTO {

    private long idDuenio;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String telefono;
    private String correo;
    private List<Mascota> mascotas;
}
