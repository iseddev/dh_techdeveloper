package MesaTrabajo;

public class CalculadorAreaCirculo extends CalculadorArea{
    @Override
    protected String calcularArea(Double radius) {
        if (radius < 1) { return "El valor del radio debe ser mayor que cero"; }
        else {
            Double area = Math.round(Math.PI * radius * radius * 100d) / 100d;
            return "El área del círculo es " + area + " unidades cuadradas";
        }
    }
}