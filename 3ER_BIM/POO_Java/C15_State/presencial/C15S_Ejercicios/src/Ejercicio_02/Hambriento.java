package Ejercicio_02;

public class Hambriento implements Estado {

    // Variable que nos ayuda a asociar nuestro Tamagotchi a este Estado
    private Tamagotchi tamagotchi;

    // Sobre escritura de todos los métodos que han sido heredados (al implementar) de la Interface Estado
    @Override
    public void darDeComer() {
        tamagotchi.establecerEstado(new Feliz());
        System.out.println("Tu mascota ha COMIDO y dice: " + tamagotchi.comoEstas());
    }
    @Override
    public void darDeBeber() {
        tamagotchi.establecerEstado(new Triste());
        System.out.println("Tu mascota ha BEBIDO y dice: " + tamagotchi.comoEstas());
    }
    @Override
    public void hacerleMimos() {
        System.out.println("Tu mascota ha sido mimada y dice: " + tamagotchi.comoEstas()); }
    @Override
    public String comoEstas() { return "Estoy HAMBRIENTA"; }


    @Override
    public void actualizarTamagotchi(Tamagotchi tamagotchi) { this.tamagotchi = tamagotchi; }
}
