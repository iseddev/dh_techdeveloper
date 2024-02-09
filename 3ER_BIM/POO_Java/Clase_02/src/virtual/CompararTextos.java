package virtual;

import java.util.Scanner;

public class CompararTextos {
    public static void main(String[] args) {
        // Definir dos cadenas de texto. Comprobar si son iguales o distintas e indicar mediante un mensaje.
        String firstText = "Hola mundo";
        String secondText = "Hello world";
        String thirdText = "Hola mundo";
        String fourthText = "Hello world";
        System.out.println(isSameText(firstText, secondText));
        System.out.println(isSameText(firstText, thirdText));
        System.out.println(isSameText(secondText, thirdText));
        System.out.println(isSameText(secondText, fourthText));
    }

    public static String isSameText(String textOne, String textTwo) {
        String message = "";
        if(textOne.equals(textTwo)) {
            message ="**" + textOne + "** SI es igual que **" + textTwo + "**";
        } else { message = "**" + textOne + "** NO es igual que **" + textTwo + "**"; }
        return message;
    }
}