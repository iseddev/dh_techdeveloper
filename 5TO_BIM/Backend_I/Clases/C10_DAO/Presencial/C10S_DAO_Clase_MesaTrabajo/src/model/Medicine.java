package model;

public class Medicine {

  private Integer id; // Para este ejercicio, se asignará el id de forma manual
  private String nombre;
  private String laboratorio;
  private Integer cantidad;
  private Double precio;
  private Integer codigo;

  public Medicine(String nombre, String laboratorio, Integer cantidad, Double precio, Integer codigo) {
    this.nombre = nombre;
    this.laboratorio = laboratorio;
    this.cantidad = cantidad;
    this.precio = precio;
    this.codigo = codigo;
  }

  public Integer getId() { return id; }
  public Integer getCodigo() { return codigo; }
  public Integer getCantidad() { return cantidad; }
  public String getNombre() { return nombre; }
  public String getLaboratorio() { return laboratorio; }
  public Double getPrecio() { return precio; }

  public void setId(Integer id) { this.id = id; }
  public void setCodigo(Integer codigo) { this.codigo = codigo; }
  public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
  public void setNombre(String nombre) { this.nombre = nombre; }
  public void setLaboratorio(String laboratorio) { this.laboratorio = laboratorio; }
  public void setPrecio(Double precio) { this.precio = precio; }

  @Override
  public String toString() {
    return "Medicamento{" + "id=" + id + ", nombre='" + nombre + '\'' + ", laboratorio='" + laboratorio + '\'' + ", cantidad=" + cantidad + ", precio=" + precio + ", codigo=" + codigo + '}';
  }
}