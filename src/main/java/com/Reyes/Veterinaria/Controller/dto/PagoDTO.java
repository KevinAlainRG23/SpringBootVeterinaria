package com.Reyes.Veterinaria.Controller.dto;

import com.Reyes.Veterinaria.entities.Cita;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PagoDTO {

    private long idPago;
    private String tipoPago;
    private LocalDateTime fechaPago;
    private BigDecimal monto;
    private Cita cita;
}
