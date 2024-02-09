package presencial;

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        /* Ingresa tu nombre y tu apellido por separado, a partir de estas variables obtener en una tercera tus iniciales y tu fecha de nacimiento, para la fecha ingresa, 3 valores que representan día, mes y año. */
        System.out.println("Ingresa tu nombre:");
        String userName = scanner.nextLine();
        System.out.println("Ingresa tu apellido:");
        String userLastName = scanner.nextLine();
        System.out.println("Ingresa tu día de nacimiento (0 - 31)");
        int birthDay = scanner.nextInt();
        System.out.println("Ingresa tu mes de nacimiento (1 - 12)");
        int birthMonth = scanner.nextInt();
        System.out.println("Ingresa tu año de nacimiento (1900 - actual)");
        int birthYear = scanner.nextInt();

        /* Luego muestra un mensaje, como si fuera una ficha, con tu nombre completo. Las iniciales de tu nombre y apellido y tu fecha de nacimiento con el formato “dd/mm/aaaa” */
        System.out.println("****** Datos ingresados *****");
        System.out.println("Nombre completo: " + userName + " " + userLastName);
        System.out.println("Inicial nombre: " + firstCharacter(userName));
        System.out.println("Inicial apellido: " + firstCharacter(userLastName));
        /* Nota: Utilizar alguna función para resolver, por ejemplo una que dados los 3 valores devuelve la fecha como un string. */
        System.out.println("Fecha de nacimiento: " + stringBirthDate(birthDay, birthMonth, birthYear));
    }

    public static String stringBirthDate(int day, int month, int year) {
        String dayText = null;
        String monthText = null;
        String yearText = null;
        if(day > 0 && day <= 31 && month > 0 && month <= 12 && year > 1900 && year < 2024) {
            if(day < 10) { dayText = "0" + day;}
            else { dayText = Integer.toString(day); }

            if(month < 10) { monthText = "0" + month; }
            else { monthText = Integer.toString(month); }

            yearText = Integer.toString(year);
        }
        else { System.out.println("Error en los datos ingresados de la fecha de nacimiento..."); }
        return dayText + "/" + monthText + "/" + yearText;
    }

    public static char firstCharacter(String text) {
        return text.charAt(0);
    }
}
