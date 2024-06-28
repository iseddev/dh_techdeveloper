package C16S_MesaTrabajo_01;

public class Main {
    public static void main(String[] args) {
        Figure circle = new Circle(2);
        Figure triangle = new Triangle(8, 9);
        Figure rectangle = new Rectangle(5, 3);
        System.out.println(circle.calculateArea());
        System.out.println(triangle.calculateArea());
        System.out.println(rectangle.calculateArea());

        // ########## Crear vagón ##########
        FigureComposite wagon = new FigureComposite();
        // Vagón de 10 por 6
        wagon.addFigure(new Rectangle(10, 6));
        // Tres ruedas de 0.5 de radio
        wagon.addFigure(new Circle(0.5));
        wagon.addFigure(new Circle(0.5));
        wagon.addFigure(new Circle(0.5));

        // Se calcula el área total del vagón
        System.out.println("Vagón compuesto por las " + wagon);
        System.out.println("Área total vagón: " + wagon.calculateArea());

        // ########## Crear una locomotora ##########
        FigureComposite locomotive = new FigureComposite();
        // Rectángulo de 10 por 4
        locomotive.addFigure(new Rectangle(10, 4));
        // Rectángulo de 6 por 2
        locomotive.addFigure(new Rectangle(6, 2));
        // Rectángulo de 1 por 2
        locomotive.addFigure(new Rectangle(1, 2));
        // Dos círculos de 0.5 de radio
        locomotive.addFigure(new Circle(0.5));
        locomotive.addFigure(new Circle(0.5));
        // Triángulo de 1 x 1
        locomotive.addFigure(new Triangle(1, 1));

        // Se calcula el área total de la locomotora
        System.out.println("Locomotora compuesta por las " + locomotive);
        System.out.println("Area total locomotora: " + locomotive.calculateArea());
    }
}
