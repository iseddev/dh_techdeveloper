package mesa_trabajo_1;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        ImpresoraEpson epson_1 = new ImpresoraEpson("xyz123", "wifi", new Date(), 123, 85.4);
        ImpresoraCannon cannon_1 = new ImpresoraCannon("123xyz", "wired", new Date(), 321, 99.0);

        System.out.println("epson_1 tiene papel? " + epson_1.tienePapel());
        System.out.println("epson_1 necesita tinta? " + epson_1.necesitaTinta());
        System.out.println("epson_1 imprime: " + epson_1.imprimir());

        System.out.println("cannon_1 tiene papel? " + cannon_1.tienePapel());
        System.out.println("cannon_1 necesita tinta? " + cannon_1.necesitaTinta());
        System.out.println("cannon_1 imprime: " + cannon_1.imprimir());
    }

}
