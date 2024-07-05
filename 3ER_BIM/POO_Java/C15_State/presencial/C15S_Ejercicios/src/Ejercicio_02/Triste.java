package Ejercicio_02;

public class Triste implements Estado {

    private Tamagotchi tamagotchi;
    @Override
    public void darDeComer() { System.out.println("Tu mascota ha COMIDO, Beep beep (tu mascota está vomitando!!!)"); }

    @Override
    public void darDeBeber() { System.out.println("Tu mascota ha BEBIDO, Beep beep beep (display titilando!!!)"); }

    @Override
    public void hacerleMimos() {
        tamagotchi.establecerEstado(new Feliz());
        System.out.println("Tu mascota ha sido mimada y dice: " + tamagotchi.comoEstas());
    }

    @Override
    public String comoEstas() { return "Estoy TRISTE"; }

    @Override
    public void actualizarTamagotchi(Tamagotchi tamagotchi) { this.tamagotchi = tamagotchi; }
}
