package virtual;

public class NumeroMayor {
    public static void main(String[] args) {
        // Definir dos Integer y determinar cuál es mayor, cuál es menor o si son iguales. Informar el resultado obtenido.
        Integer num1 = 21;
        Integer num2 = 98;
        if (num1 > num2) {
            System.out.println(num1 + " es mayor que " + num2);
        } else if (num1 < num2) {
            System.out.println(num2 + " es mayor que " + num1);
        } else {
            System.out.println(num1 + " es igual a " + num2);
        }
    }
}
