package Ejercicio_01;

public class Date03 {
    private int day;
    private int month;
    private int year;

    public Date03(int day, int month, int year) throws Exception{
        if(day < 1 || day > 31 || month < 1 || month > 12)
            throw new Exception("ERROR!!! Valores ingresados no válido...");
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Date01{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}