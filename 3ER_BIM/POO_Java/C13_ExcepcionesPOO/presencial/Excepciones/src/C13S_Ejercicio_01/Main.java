package C13S_Ejercicio_01;

public class Main {
    public static void main(String[] args) {
        Cliente cliente01 = new Cliente("Israel", "Porfirio", "ABC123D4", 800.0);
        try{ cliente01.comprar(900.0); }
        catch (ClienteException err) { System.err.println(err); }

        try{ cliente01.comprar(500.0); }
        catch (ClienteException err) { System.err.println(err); }

        try{ cliente01.pagarDeuda(800.0); }
        catch (ClienteException err) { System.err.println(err); }

        try{ cliente01.pagarDeuda(0.0); }
        catch (ClienteException err) { System.err.println(err); }

        try{ cliente01.pagarDeuda(1000.0); }
        catch (ClienteException err) { System.err.println(err); }

        System.out.println("Sistema sigue en ejecución...");
    }
}