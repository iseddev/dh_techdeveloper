package Ejercicio_02;

public class Sediento implements Estado {

    private Tamagotchi tamagotchi;
    @Override
    public void darDeComer() {
        tamagotchi.establecerEstado(new Triste());
        System.out.println("Tu mascota ha comido, y dice: " + tamagotchi.comoEstas());
    }

    @Override
    public void darDeBeber() {
        tamagotchi.establecerEstado(new Feliz());
        System.out.println("Tu mascota ha bebido y dice: " + tamagotchi.comoEstas());
    }

    @Override
    public void hacerleMimos() { System.out.println("Tu mascota ha sido mimada y dice: " + tamagotchi.comoEstas()); }

    @Override
    public String comoEstas() { return "Estoy SEDIENTA"; }

    @Override
    public void actualizarTamagotchi(Tamagotchi tamagotchi) { this.tamagotchi = tamagotchi; }
}