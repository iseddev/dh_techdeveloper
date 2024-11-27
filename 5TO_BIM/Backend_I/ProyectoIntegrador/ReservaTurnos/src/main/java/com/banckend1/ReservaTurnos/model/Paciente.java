package com.banckend1.ReservaTurnos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "paciente")
public class Paciente {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "id_paciente")
    private Integer id;
    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;
    @Column(name = "apellido", length = 100, nullable = false)
    private String apellido;
    @Column(name = "dni", length = 100, nullable = false)
    private String dni;
    @Column(name = "domicilio", length = 100, nullable = false)
    private String domicilio;
    @Column(name = "fecha_alta", nullable = false)
    private LocalDate fechaAlta;
    @ManyToOne(targetEntity = Odontologo.class, optional = false, cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn (name="id_odontologo")
    private Odontologo odontologo;

}
