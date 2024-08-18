package DAO.model;

public class Estudiante {

	private Integer id;
	private String nombre, apellido;

	public String getNombre() { return nombre; }
	public String getApellido() { return apellido; }
	public Integer getId() { return id; }

	public void setNombre(String nombre) { this.nombre = nombre; }
	public void setApellido(String apellido) { this.apellido = apellido; }
	public void setId(Integer id) {	this.id = id; }

	@Override
	public String toString() {
		return "Estudiante{" + "id=" + id + ", nombre='" + nombre + '\'' + ", apellido='" + apellido + '\'' + '}';
	}
}