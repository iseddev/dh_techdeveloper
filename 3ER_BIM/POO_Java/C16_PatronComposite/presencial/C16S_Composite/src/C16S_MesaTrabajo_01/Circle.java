package C16S_MesaTrabajo_01;

public class Circle extends Figure{
    private final double PI = 3.14159;
    private double radius;

    public Circle(double radius) { this.radius = radius; }

    @Override
    public double calculateArea() {
        return PI * radius * radius;
    }

    @Override
    public String toString() { return "Circle"; }
}
