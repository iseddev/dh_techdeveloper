package Testing;

public class Persona {
    private String nombre;
    private Integer edad;

    public Persona(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() { return nombre; }
    public Integer getEdad() { return edad; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEdad(Integer edad) { this.edad = edad; }

    // Crear métodos
    // - La persona debería ser mayor de 18 años
    public boolean esMayor() { return edad >= 18; }

    // - El nombre debería tener más de 4 letras
    public boolean letrasCheck() { return nombre.length() >= 5; }


    // boolean -> false
    // Boolean -> null
    // - El nombre debería contener solo letras de la a-z
    public boolean nombreCheck() {
        boolean nombreValido = false;
        // Creamos un array de chars
        char[] arrayNombreEnLetras = nombre.toCharArray();
        // Recorremos el array para validara que cada caracter sea de tipo char
        for (char letra: arrayNombreEnLetras) { if (!Character.isLetter(letra)) { return nombreValido; } }

        nombreValido = true;
        return nombreValido;
    }

    // - La edad debería ser un número entre 0-9 => 3 caracteres - 120 años
    public boolean edadCheck() {
        boolean edadValida = false;
        // Si la persona tiene entre 0 y 120 de edad -> se agrega al grupo
        if (edad > 0 && edad < 120) {  // => 0 > edad < 120
            // Se agrega al grupo
            edadValida = true;
            return edadValida;
        }
        return edadValida;
    }
}
