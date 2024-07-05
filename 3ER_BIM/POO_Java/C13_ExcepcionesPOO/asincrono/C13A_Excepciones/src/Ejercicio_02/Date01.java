package Ejercicio_02;

public class Date01 {
    private int day;
    private int month;
    private int year;

    public Date01(int day, int month, int year) {
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
