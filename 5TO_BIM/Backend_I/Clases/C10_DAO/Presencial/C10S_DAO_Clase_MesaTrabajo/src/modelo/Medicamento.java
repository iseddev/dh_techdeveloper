package modelo;

public class Medicamento {
  private Integer id, codigo, cantidad;
  private String nombre, laboratorio;
  private Double precio;

  public Medicamento(Integer codigo, Integer cantidad, String nombre, String laboratorio, Double precio) {
    this.codigo = codigo;
    this.cantidad = cantidad;
    this.nombre = nombre;
    this.laboratorio = laboratorio;
    this.precio = precio;
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
}