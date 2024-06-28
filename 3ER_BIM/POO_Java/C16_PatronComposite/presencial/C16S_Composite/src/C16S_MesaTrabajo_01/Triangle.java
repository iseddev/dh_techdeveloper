package C16S_MesaTrabajo_01;

public class Triangle extends Figure {
    private double base, height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() { return base * height / 2; }

    @Override
    public String toString() { return "Triangle"; }
}
