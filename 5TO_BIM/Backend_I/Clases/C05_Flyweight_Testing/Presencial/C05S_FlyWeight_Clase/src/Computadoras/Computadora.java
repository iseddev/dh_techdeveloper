package Computadoras;

public class Computadora {

    // Atributos generales de una computadora
    private String modelo;
    private Integer ram, discoDuro;

    // Este atributo inicia en cero y se incrementará en uno cada vez que se crea una nueva computadora
    private static Integer contador = 0;

    // Constructor
    public Computadora(Integer ram, Integer discoDuro, String modelo) {
        this.ram = ram;
        this.modelo = modelo;
        this.discoDuro = discoDuro;
        // Al momento de instanciar esta clase
        contador++;
        System.out.println("Computadora creada, contador = " + contador);
    }

    // Getter
    public static Integer getContador(Integer contador) { return contador; }

    // Setters
    public void setRam(Integer ram) { this.ram = ram; }
    public void setDiscoDuro(Integer discoDuro) { this.discoDuro = discoDuro; }
}
