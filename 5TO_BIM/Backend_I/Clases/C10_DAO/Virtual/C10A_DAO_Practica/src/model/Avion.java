package model;

import java.time.LocalDate;
import java.util.Date;

public class Avion {

	private Integer id;
	private String marca, modelo, matricula;
	private LocalDate ingresoServicio;

	public Avion(Integer id, String marca, String modelo, String matricula, LocalDate ingresoServicio) {
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.matricula = matricula;
		this.ingresoServicio = ingresoServicio;
	}

	public Integer getId() { return id; }
	public String getMarca() { return marca; }
	public String getModelo() { return modelo; }
	public String getMatricula() { return matricula; }
	public LocalDate getIngresoServicio() { return ingresoServicio; }

	public void setId(Integer id) { this.id = id; }
	public void setMarca(String marca) {this.marca = marca; }
	public void setModelo(String modelo) { this.modelo = modelo; }
	public void setMatricula(String matricula) { this.matricula = matricula; }
	public void setIngresoServicio(LocalDate ingresoServicio) {  this.ingresoServicio = ingresoServicio; }

	@Override
	public String toString() {
		return "\nAvion{" + "id=" + id + ", marca='" + marca + '\'' + ", modelo='" + modelo + '\'' + ", matricula='" + matricula + '\'' + ", ingresoServicio=" + ingresoServicio + "}";
	}
}
