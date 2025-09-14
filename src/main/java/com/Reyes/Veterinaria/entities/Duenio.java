package com.Reyes.Veterinaria.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jdk.jfr.Enabled;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class Duenio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_duenio")
private long idDueño;

    @NotBlank
private String nombre;

    @NotBlank
    @Column(name="apellido_paterno")
private String apellidoPaterno;

    @NotBlank
    @Column(name="apellido_materno")
private String apellidoMaterno;

    @NotBlank
    @Min(value=10)
private String telefono;

private String Correo;


@OneToMany(targetEntity = Mascota.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "duenio")

private List<Mascota> mascotas;



}
