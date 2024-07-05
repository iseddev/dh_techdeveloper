package C16A_Ejemplo_01;

public class DeptoVentas implements Depto {
    private int id;
    private String name;

    public DeptoVentas(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void getName() {
        System.out.println(getClass().getSimpleName());
    }
}
