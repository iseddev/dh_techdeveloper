package virtual;

public class EsDivisible {
    // Hacer una función que reciba como parámetro dos valores y devuelva un boolean. La función debe comprobar si el primer número es divisible por el segundo.

    //NOTA: Que sea divisible quiere decir que al dividir da un valor exacto, es decir, sin decimales.

    //boolean esDivisible(int n, int divisor)
    static boolean esDivisible(int n, int divisor) { return n % divisor == 0; }

    public static void main(String[] args) {

        int num1 = 84;
        int num2 = 3;
        if(esDivisible(num1, num2)) { System.out.println(num1 + " SI es divisible entre " + num2); }
        else { System.out.println(num1 + " NO es divisible entre " + num2); }
        }
}
