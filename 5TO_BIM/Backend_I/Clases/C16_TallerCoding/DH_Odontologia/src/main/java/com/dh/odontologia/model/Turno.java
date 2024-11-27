package com.dh.odontologia.model;

import java.time.LocalDate;

public class Turno {
  private Integer id;
  private Odontologo odontologo;
  private Paciente paciente;
  private LocalDate fecha;

  public Integer getId() {
    return id;
  }
  public Odontologo getOdontologo() {
    return odontologo;
  }
  public Paciente getPaciente() {
    return paciente;
  }
  public LocalDate getFecha() { return fecha; }

  public void setId(Integer id) { this.id = id; }
  public void setOdontologo(Odontologo odontologo) { this.odontologo = odontologo; }
  public void setPaciente(Paciente paciente) { this.paciente = paciente; }
  public void setFecha(LocalDate fecha) { this.fecha = fecha; }

  @Override
  public String toString() {
    return "Turno{" + "id=" + id + ", odontologo=" + odontologo + ", paciente=" + paciente + ", fecha=" + fecha + '}';
  }
}
