package Practica_01;

public class Persona {
    private String nombre, apellido, email;
    private int edad;

    public Persona(String nombre, String apellido, String email, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.edad = edad;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String mostrarNombreCompleto() { return apellido + ", " + nombre; }

    public String esMayorDeEdad() {
        if(edad >= 18) { return nombre + " SI es mayor de edad"; }
        else { return nombre + " NO es mayor de edad"; }
    }
}
