package C16A_Ejemplo_01;

public class DeptoTest implements Depto {
    private int id;
    private String name;

    public DeptoTest(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void getName() { System.out.println("Depto: " + name); }
}
