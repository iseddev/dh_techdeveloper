package com.dh.odontologia.model;

public class Odontologo {
  private Integer id;
  private String nombre;
  private String apellido;
  private String matricula;

  public Odontologo(Integer id, String nombre, String apellido, String matricula) {
    this.id = id;
    this.nombre = nombre;
    this.apellido = apellido;
    this.matricula = matricula;
  }

  public Odontologo() {}

  public Integer getId() {
    return id;
  }
  public String getNombre() {
    return nombre;
  }
  public String getApellido() {
    return apellido;
  }
  public String getMatricula() {
    return matricula;
  }

  public void setId(Integer id) {
    this.id = id;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public void setApellido(String apellido) {
    this.apellido = apellido;
  }
  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }

  @Override
  public String toString() {
    return "Odontologo{" + "id=" + id + ", nombre='" + nombre + '\'' + ", apellido='" + apellido + '\'' + ", matricula='" + matricula + '\'' + '}';
  }
}
