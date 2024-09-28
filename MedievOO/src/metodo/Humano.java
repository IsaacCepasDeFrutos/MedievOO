package metodo;

public abstract class Humano {
    private int vida = 25;
    private boolean turnoReducido;
    private boolean veneno; // Nuevo atributo para indicar si el humano está envenenado

    public Humano() {
    }

    public Humano(int vida) {
        super();
        this.vida = vida;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public boolean isTurnoReducido() {
        return turnoReducido;
    }

    public void setTurnoReducido(boolean turnoReducido) {
        this.turnoReducido = turnoReducido;
    }

    public boolean isVeneno() { // Método para obtener el estado de veneno
        return veneno;
    }

    public void setVeneno(boolean veneno) { // Método para modificar el estado de veneno
        this.veneno = veneno;
    }
    public int generarDanioEnvenenamiento() {
        // Generar un número de daño aleatorio para el envenenamiento
        int danio = (int) (Math.random() * 2) + 1; // Número aleatorio entre 1 y 2 (inclusive)
        System.out.println("La vida quitada es de " + danio);
        return danio;
    }
    public void danioXturno(Humano rival) {
        if (rival.isVeneno()) {
            int danioEnvenenamiento = generarDanioEnvenenamiento(); // Generar daño aleatorio
            rival.setVida(rival.getVida() - danioEnvenenamiento); // Reducir la vida del rival según el daño
            System.out.println("El rival sufre " + danioEnvenenamiento + " puntos de daño por envenenamiento.");
            System.out.println("La vida del rival ahora es: " + rival.getVida());
        }
    }

    @Override
    public String toString() {
        return "Humano [vida=" + vida + "]";
    }
}