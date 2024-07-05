package C16A_Ejemplo_01;

import java.util.ArrayList;
import java.util.List;

public class DeptoComposite implements Depto {
    private int id;
    private String name;

    private List<Depto> childDepto;

    public DeptoComposite(int id, String name) {
        this.id = id;
        this.name = name;
        this.childDepto = new ArrayList<>();
    }

    public void getName() { childDepto.forEach(Depto::getName); }

    public void addDepto(Depto departamento) { childDepto.add(departamento); }

    public void removeDepto(Depto departamento) { childDepto.remove(departamento); }
}