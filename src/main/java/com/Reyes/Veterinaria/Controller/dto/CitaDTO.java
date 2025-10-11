package com.Reyes.Veterinaria.Controller.dto;

import com.Reyes.Veterinaria.entities.Doctor;
import com.Reyes.Veterinaria.entities.Duenio;
import com.Reyes.Veterinaria.entities.Mascota;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CitaDTO {

    private long idCita;
    private LocalDate fecha;
    private LocalTime hora;
    private Doctor doctor;
    private Duenio duenio;
    private Mascota mascota;

}
