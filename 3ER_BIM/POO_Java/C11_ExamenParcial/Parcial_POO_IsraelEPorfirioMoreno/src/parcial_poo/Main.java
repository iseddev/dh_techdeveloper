package parcial_poo;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Particular particular01 = new Particular(new Consulta(new Date(), "Cardiología", 8, 45), new Date(), "Jorge", "González", 1250.0, "A12B34C56");
        System.out.println("Hacer evaluacion inicial? " + particular01.hacerEvaluacionInicial());
        particular01.setPrimerConsulta(true);
        System.out.println("Hacer evaluacion inicial? " + particular01.hacerEvaluacionInicial());

        System.out.println("********************************************");
        ObraSocial obraSocial01 = new ObraSocial(new Consulta(new Date(), "Oncología", 10, 30), new Date(), "Alberto", "Posada", "GOB01", 10);
        System.out.println("Hacer evaluacion inicial? " + obraSocial01.hacerEvaluacionInicial());
        ObraSocial obraSocial02 = new ObraSocial(new Consulta(new Date(), "Radiología", 12, 20), new Date(), "Diana", "Alvarado", "GOB02", 8);
        System.out.println("Hacer evaluacion inicial? " + obraSocial02.hacerEvaluacionInicial());
        obraSocial02.setPrimerConsulta(true);
        System.out.println("Hacer evaluacion inicial? " + obraSocial02.hacerEvaluacionInicial());

        obraSocial01.compareTo(obraSocial02);
        obraSocial02.compareTo(obraSocial01);
    }
}