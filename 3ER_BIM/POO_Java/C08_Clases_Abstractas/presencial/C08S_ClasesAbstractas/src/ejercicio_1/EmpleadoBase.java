package ejercicio_1;

public class EmpleadoBase extends Empleado {
    private int aniosAntiguedad;
    private double salarioBase;
    private double bono;
    private double incentivo;

    public EmpleadoBase(String nombre, int numeroEmpleado, int aniosAntiguedad, double salarioBase, double bono, double incentivo) {
        super(nombre, numeroEmpleado);
        this.aniosAntiguedad = aniosAntiguedad;
        this.salarioBase = salarioBase;
        this.bono = bono;
        this.incentivo = incentivo;
    }

    public Double getSalarioBase() { return salarioBase; }

    @Override
    // Para sobre escribir este método (que viene de Empleado), es necesario que devuelva el mismo tipo de dato (o no) y que el tipo y número de parámetros sea el mismo, entonces es que podemos aplicar la directiva @Override
    public Double calcularSalario() {
        for(int i = 0; i <= 5; i++) { System.out.println("Calculando Salario Total de EmpleadoBase..."); }
        double salarioTotal = salarioBase + bono + incentivo;
        return  salarioTotal;
    }
}
