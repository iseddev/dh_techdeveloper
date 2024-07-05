package Ejercicio_01;

public class Session {
    private static Session SESSION;
    private Session() {}

    // Para poder invocar a getInstance(), es necesario que el método sea "static", ya que de esta forma lo podremos llamar al instanciarlo desde la Clase (Session), para esto el atributo SESSION también debe ser static.
    // synchronized nos ayuda a evitar que se creen dos instancias al momento de llamar a getInstance() por dos ejecuciones al mismo tiempo
    public synchronized static Session getInstance() {
        // Preguntamos si el atributo INSTANCE no ha sido creado anteriormente
        if (SESSION == null)
            // Si no ha sido creado, se crea la instancia a la Clase Singleton
            SESSION = new Session();
        System.out.println(SESSION);
        // Se retorna la instancia de esta Clase
        return SESSION;
    }

    @Override
    public String toString() { return "Session"; }
}
