package com.Reyes.Veterinaria.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrementable
    @Column(name="id_mascota")
    private long idMascota;

    private String nombre;

    @NotBlank
    private String tipo;

    private String raza;

    @ManyToOne(targetEntity = Duenio.class)
    @JoinColumn(name="id_duenio")

    @JsonBackReference
//@JsonIgnore
private  Duenio duenio;

}
