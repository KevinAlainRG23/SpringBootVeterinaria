package com.Reyes.Veterinaria.Controller;

import com.Reyes.Veterinaria.Controller.dto.DuenioDTO;
import com.Reyes.Veterinaria.Controller.dto.PagoDTO;
import com.Reyes.Veterinaria.entities.Duenio;
import com.Reyes.Veterinaria.entities.Pago;
import com.Reyes.Veterinaria.services.IDuenioService;
import com.Reyes.Veterinaria.services.IPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/pago")

public class PagoController {
    @Autowired
    private IPagoService pagoService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<PagoDTO> pagos = pagoService.findAll().stream()
                .map(pago -> PagoDTO.builder()
                        .idPago(pago.getIdPago())
                        .tipoPago(pago.getTipoPago())
                        .fechaPago(pago.getFechaPago())
                        .monto(pago.getMonto())
                        .cita(pago.getCita())
                        .build())
                .toList();
        return ResponseEntity.ok(pagos);

    }

    @GetMapping("/find/{idPago}")
    public ResponseEntity<?> findById(@PathVariable Long idPago) {
        Optional<Pago> pagoOptional = pagoService.findById(idPago);
        if (pagoOptional.isPresent()) {
            Pago pago = pagoOptional.get();
            PagoDTO pagoDTO = PagoDTO.builder()
                    .idPago(pago.getIdPago())
                    .tipoPago(pago.getTipoPago())
                    .fechaPago(pago.getFechaPago())
                    .monto(pago.getMonto())
                    .cita(pago.getCita())
                    .build();
            return ResponseEntity.ok(pagoDTO);
        }
        return ResponseEntity.notFound().build();

    }


    public ResponseEntity<?> save(@RequestBody PagoDTO pagoDto) {
        pagoService.save(Pago.builder()
                .tipoPago(pagoDto.getTipoPago())
                .fechaPago(pagoDto.getFechaPago())
                .monto(pagoDto.getMonto())
                .cita(pagoDto.getCita())
                .build()
        );
        return ResponseEntity.ok("Pago guardado");
    }

    @PutMapping("/update/{idPago}")
    public ResponseEntity<?> update(@RequestBody PagoDTO pagoDto, @PathVariable Long idPago) {
        Optional<Pago> pagoOptional = pagoService.findById(idPago);
        if (pagoOptional.isPresent()) {
            Pago pago = pagoOptional.get();
            pago.setTipoPago(pagoDto.getTipoPago());
            pago.setFechaPago(pagoDto.getFechaPago());
            pago.setMonto(pagoDto.getMonto());
            pago.setCita(pagoDto.getCita());
            pagoService.save(pago);
            return ResponseEntity.ok("pago actualizado");

        }
        return ResponseEntity.badRequest().build();

    }

    @DeleteMapping("/delete/{idPago}")
    public String deleteById(@PathVariable Long idPago) {
        if (idPago != null) {
            pagoService.deleteById(idPago);
            return "pago eliminado";
        }
        return "error al eliminar el pago";
    }
}