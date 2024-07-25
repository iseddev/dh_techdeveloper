package MesaTrabajo;

public class CalculadorAreaCuadrado extends CalculadorArea{
    @Override
    protected String calcularArea(Double side) {
        if (side < 1) { return "El valor del lado debe ser mayor que cero"; }
        else {
            Double area = Math.round(side * side * 100d) / 100d;
            return "El area del cuadrado es " + area + " unidades cuadradas";
        }
    }
}
