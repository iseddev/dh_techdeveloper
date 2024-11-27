package com.banckend1.ReservaTurnos.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "odontologo")
public class Odontologo {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "id_odontologo")
    private Integer id;
    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;
    @Column(name = "apellido", length = 100, nullable = false)
    private String apellido;
    @Column(name = "matricula", length = 100, nullable = false)
    private String matricula;
    @OneToMany (mappedBy="paciente")
    @JsonIgnore
    private List<Paciente> pacientes;

    public Odontologo(Integer id, String nombre, String apellido, String matricula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }
}
