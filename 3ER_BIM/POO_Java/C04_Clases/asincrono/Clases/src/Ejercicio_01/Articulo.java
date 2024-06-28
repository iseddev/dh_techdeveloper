package Ejercicio_01;

public class Articulo {
    private String descripcion;
    private double precioVenta;
    private  int stock;

    public Articulo(String descripcion, double precioVenta, int stock) {
        this.descripcion = descripcion;
        this.precioVenta = precioVenta;
        this.stock = stock;
    }

    public String getDescripcion() { return descripcion; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getPrecioVenta() { return precioVenta; }

    public void setPrecioVenta(double precioVenta) { this.precioVenta = precioVenta; }

    public int getStock() { return stock; }

    public void setStock(int stock) { this.stock = stock; }

    public  boolean hayStock() { return stock > 0; }

}
