package Ejercicio_02;

public class Feliz implements Estado {

    private Tamagotchi tamagotchi;
    @Override
    public void darDeComer() {
        tamagotchi.establecerEstado(new Sediento());
        System.out.println("Tu mascota ha comido y dice: " + tamagotchi.comoEstas());
    }

    @Override
    public void darDeBeber() {
        tamagotchi.establecerEstado(new Hambriento());
        System.out.println("Tu mascota ha bebido y dice: " + tamagotchi.comoEstas());
    }

    @Override
    public void hacerleMimos() { System.out.println("Tu mascota ha sido mimada y dice: " + tamagotchi.comoEstas()); }

    @Override
    public String comoEstas() { return "Estoy FELIZ"; }

    @Override
    public void actualizarTamagotchi(Tamagotchi tamagotchi) { this.tamagotchi = tamagotchi; }
}
