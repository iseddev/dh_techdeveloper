package Presencial_01;

public class CuentaCorriente extends Cuenta implements ImpuestoGravable {
    private double descubiertoPermitido = 500.0;

    @Override
    public double extraer(double montoRetiro) {
        if(montoRetiro > saldo) {
            double extraAplicado = saldo + descubiertoPermitido;
            if(montoRetiro > extraAplicado) {
                System.out.println("ERROR: No cuenta con sufuciente saldo para realizar retiro...");
                System.out.println("Saldo: " + saldo + ", Extra: " + descubiertoPermitido + ", Total Disponible: " + extraAplicado);
                System.out.println("Monto retiro: " + montoRetiro);
                return saldo;
            } else {
                double montoTotalExtra = saldo + descubiertoPermitido;
                System.out.println("Retiro: " + montoRetiro);
                System.out.println("Saldo: " + saldo + ", Descubierto Permitido: " + descubiertoPermitido);
                System.out.println("Saldo total extra: " + montoTotalExtra);
                System.out.println("El banco le permite extraer");
                saldo -= montoRetiro;
                System.out.println("Saldo final = " + saldo);
                return saldo;
            }
        }
        return saldo;
    }

    @Override
    public double gravarImpuesto(double porcentaje) {
        System.out.println("Gravando Impuesto");
        saldo -= saldo * (porcentaje / 100);
        System.out.println("Impuesto: " + porcentaje + "%, Saldo después de impuestos: " + saldo);
        return saldo;
    }
}
