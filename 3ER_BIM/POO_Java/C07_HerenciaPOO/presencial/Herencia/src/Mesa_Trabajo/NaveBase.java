package Mesa_Trabajo;

public class NaveBase extends ObjetoGrafico{
    private double velocidad;
    protected int vida;

    public NaveBase(int posX, int posY, char direccion, double velocidad, int vida) {
        super(posX, posY, direccion);
        this.velocidad = velocidad;
        this.vida = vida;
    }

    public void irA(int x, int y, char dir) {
        if(this.direccion != dir) {
            System.out.println("Direccion actual: " + this.direccion + ", Dirección ingresada: " + dir);
            this.posX = x;
            this.posY = y;
            this.direccion = girar(dir);
        } else {
            this.posX = x;
            this.posY = y;
        }
    }

    public char girar(char dir) { return this.direccion = dir; }

    public void restarVida(int valor) { vida -= valor; }
}
