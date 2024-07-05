package C16A_Ejemplo_01;

public class DeptoFinanciero implements Depto {
    private int id;
    private String name;

    public DeptoFinanciero(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void getName() {
        System.out.println(getClass().getSimpleName());
    }
}
