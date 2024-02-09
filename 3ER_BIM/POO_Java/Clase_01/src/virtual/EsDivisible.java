// Definir dos números enteros. Asignarles un valor a cada uno. Comprobar si un número es divisible por el segundo e indicar mediante mensaje el resultado obtenido.
// Nota: Que sea divisibles quiere decir que al dividir da un valor exacto, es decir, sin decimales.


package virtual;

public class EsDivisible {
    public static void main(String[] args) {
        int num1 = 24;
        int num2 = 8;

        if(num1 % num2 == 0) {
            System.out.println(num1 + " es divisible exactamente entre el número " + num2);
        } else { System.out.println(num1 + " NO es divisible exactamente entre el número " + num2); }
    }
}
