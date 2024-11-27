package com.dh.odontologia.model;

import java.time.LocalDate;

public class Paciente {

  private Integer id;
  private String nombre;
  private String apellido;
  private String dni;
  private LocalDate fechaAlta;
  private Domicilio domicilio; // Esto es para Java, difiere de SQL

  public Paciente() {}

  public Paciente(Integer id, String nombre, String apellido, String dni, LocalDate fechaAlta, Domicilio domicilio) {
    this.id = id;
    this.nombre = nombre;
    this.apellido = apellido;
    this.dni = dni;
    this.fechaAlta = fechaAlta;
    this.domicilio = domicilio;
  }

  public Integer getId() {
    return id;
  }
  public String getNombre() {
    return nombre;
  }
  public String getApellido() {
    return apellido;
  }
  public String getDni() {
    return dni;
  }
  public LocalDate getFechaAlta() {
    return fechaAlta;
  }
  public Domicilio getDomicilio() { return domicilio; }

  public void setId(Integer id) {
    this.id = id;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public void setApellido(String apellido) {
    this.apellido = apellido;
  }
  public void setDni(String dni) {
    this.dni = dni;
  }
  public void setFechaAlta(LocalDate fechaAlta) {
    this.fechaAlta = fechaAlta;
  }
  public void setDomicilio(Domicilio domicilio) { this.domicilio = domicilio; }

  @Override
  public String toString() {
    return "Paciente{" + "id=" + id + ", nombre='" + nombre + '\'' + ", apellido='" + apellido + '\'' + ", dni='" + dni + '\'' + ", fechaAlta=" + fechaAlta + ", domicilio=" + domicilio + '}';
  }
}