package com.Reyes.Veterinaria.Controller.dto;

import com.Reyes.Veterinaria.entities.Duenio;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MacotaDTO {

    private long idMascota;
    private String nombre;
    private String tipo;
    private String raza;
    private  Duenio duenio;

}
