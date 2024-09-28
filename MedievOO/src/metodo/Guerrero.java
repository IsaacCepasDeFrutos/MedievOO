package metodo;

public class Guerrero extends Humano {
    private int espada;
    private int armadura;
    private boolean turnoRedDisponible; // Indica si el ataque con la red está disponible en el siguiente turno

    public Guerrero() {
        this.turnoRedDisponible = true;
    }

    public Guerrero(int vida, int espada, int armadura) {
        super(vida);
        this.espada = espada;
        this.armadura = armadura;
        this.turnoRedDisponible = true;
    }

    public int getEspada() {
        return espada;
    }

    public void setEspada(int espada) {
        this.espada = espada;
    }

    public int getArmadura() {
        return armadura;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    @Override
    public String toString() {
        return "Guerrero [espada=" + espada + ", armadura=" + armadura + ", toString()=" + super.toString() + "]";
    }

    // Funciones de ataque

    public void ataqueEspada(Humano rival) {
    	if (rival instanceof Guerrero) {
            int daño = (int) (Math.random() * 6) + 3;
            System.out.println("El Guerrero ataca con su espada y causa " + daño + " puntos de daño.");
            int dañoReducido = ((Guerrero) rival).reduccionPorArmadura(daño);
            int dañoTotal = daño - dañoReducido;
            rival.setVida(rival.getVida() - dañoTotal); 
            System.out.println("La vida del rival ahora es: " + rival.getVida());
        

            
            
            
        }else {
        	int daño = (int) (Math.random() * 6) + 3;
            rival.setVida(rival.getVida() - daño);
            System.out.println("El Guerrero ataca con su espada y causa " + daño + " puntos de daño.");
            System.out.println("La vida del rival ahora es: " + rival.getVida());
        }
    
        
    }

    // Método del ataque Red
 // Método del ataque Red
    public boolean ataqueRed(Humano rival) {
        if (this.turnoRedDisponible) {
            if (rival instanceof Humano) {
                System.out.println("El Guerrero intenta lanzar su red.");
                // Lógica del ataque con la red
                // Si el ataque es exitoso
                if (ataqueExitoso()) {
                    rival.setTurnoReducido(true); // Reducir el turno del enemigo
                    this.turnoRedDisponible = false; // Marcar que el ataque con la red ha sido usado
                    System.out.println("La red del Guerrero ha atrapado al enemigo. El enemigo no podrá actuar en su próximo turno.");
                    return true; // El ataque con la red fue exitoso
                } else {
                    System.out.println("El ataque con la red ha fallado.");
                    return false; // El ataque con la red ha fallado
                }
            } else {
                System.out.println("El Guerrero ya ha usado su ataque con la red en este juego.");
                return false; // El ataque con la red ha fallado
            }
        } else {
            System.out.println("El Guerrero ya ha usado su ataque con la red en este juego.");
            return false; // El ataque con la red ha fallado
        }
    }


    // Método para determinar si el ataque con la red fue exitoso
    private boolean ataqueExitoso() {
        // Lógica para determinar si el ataque con la red fue exitoso
        // En este ejemplo, simplemente generamos un número aleatorio para simular el éxito o el fallo del ataque
        // Retorna true si el número aleatorio es menor o igual a 5 (simulando un 50% de probabilidad de éxito)
        return (Math.random() * 10) <= 6; 
    }


	// Método para saltar el siguiente turno del rival si está bajo el efecto de la red
    public void saltarSiguienteTurno(Humano rival) {
        if (rival.isTurnoReducido()) {
            System.out.println("El rival está bajo el efecto de la red y no podrá jugar su siguiente turno.");
            
        } else {
            System.out.println("El rival no está bajo el efecto de la red.");
        }
    }

    public int reduccionPorArmadura(int daño) {
        int dañoReducido = (int) (Math.random() * 3) + 1; // Valor de reducción aleatorio entre 1 y 3
        System.out.println("La armadura del Guerrero reduce el daño en " + dañoReducido + " puntos.");
        
       
        return dañoReducido;
    }
}

