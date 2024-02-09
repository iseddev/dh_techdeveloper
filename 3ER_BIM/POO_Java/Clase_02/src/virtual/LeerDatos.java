package virtual;

import java.util.Scanner;

public class LeerDatos {
    public static void main(String[] args) {
        // Ingresa tu nombre y tu apellido por separado, a partir de estas variables debés obtener en una tercera tus iniciales.
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresar nombre:");
        String name = scanner.nextLine();

        System.out.println("Ingresar apellido:");
        String lastName = scanner.nextLine();

        String initials = Character.toString(name.charAt(0)) + Character.toString(lastName.charAt(0));

        System.out.println("Nombre completo: " + name + " " + lastName);
        System.out.println("Inicales de nombre y apellido: " + initials);
    }
}
