package Mesa_Trabajo;

public class ObjetoGrafico {
    protected int posX;
    protected int posY;
    protected char direccion;

    public ObjetoGrafico(int posX, int posY, char direccion) {
        this.posX = posX;
        this.posY = posY;
        this.direccion = direccion;
    }

    public void irA(int x, int y, char dir) {
        this.posX = x;
        this.posY = y;
        this.direccion = dir;
    }

    @Override
    public String toString() {
        return "Posición {" +
                "posX=" + posX +
                ", posY=" + posY +
                ", direccion=" + direccion +
                '}';
    }
}