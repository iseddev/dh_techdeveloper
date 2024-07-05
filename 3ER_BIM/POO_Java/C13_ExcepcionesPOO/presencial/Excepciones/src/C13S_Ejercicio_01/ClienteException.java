package C13S_Ejercicio_01;

public class ClienteException extends Exception {
    public ClienteException() { super(); }
    public ClienteException(String message) { super(message); }

    /*
    @Override
    public String toString() {
        return "Se produjo la siguiente excepcion: " + this.getClass().getName() + "==> " + this.getMessage();
    }
     */
}