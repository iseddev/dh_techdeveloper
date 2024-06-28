package Ejercicio_02;

public class EsDivisible {
    public static void main(String[] args) {
        int num1 = 24;
        int num2 = 8;

        if(num1 % num2 == 0) {
            System.out.println(num1 + " es divisible exactamente entre el número " + num2);
        } else { System.out.println(num1 + " NO es divisible exactamente entre el número " + num2); }
    }
}
