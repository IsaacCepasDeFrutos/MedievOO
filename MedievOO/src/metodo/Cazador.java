package metodo;

public class Cazador extends Humano {
    private int daga;
    private int arco;
    private boolean veneno;

    public Cazador() {
    }

    public Cazador(int vida, int daga, int arco, boolean veneno) {
        super(vida);
        this.daga = daga;
        this.arco = arco;
        this.veneno = veneno;
    }

    public int getDaga() {
        return daga;
    }

    public void setDaga(int daga) {
        this.daga = daga;
    }

    public int getArco() {
        return arco;
    }

    public void setArco(int arco) {
        this.arco = arco;
    }

    public boolean isVeneno() {
        return veneno;
    }

    public void setVeneno(boolean veneno) {
        this.veneno = veneno;
    }

    @Override
    public String toString() {
        return "Cazador [daga=" + daga + ", arco=" + arco + ", veneno=" + veneno + ", toString()=" + super.toString() + "]";
    }
//Funciones :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
    public void ataqueDaga(Humano rival) {
        if (rival instanceof Guerrero) {
        	int danio = (int) (Math.random() * 6) + 4;
            System.out.println("El cazador ataca con la daga y causa " + danio + " puntos de daño.");
            int dañoReducido = ((Guerrero) rival).reduccionPorArmadura(danio);
            int dañoTotal = danio - dañoReducido;
            rival.setVida(rival.getVida() - dañoTotal);
            
            int probabilidadEnvenenar = 40; // Por ejemplo, 80% de probabilidad
            envenenado(rival, probabilidadEnvenenar); // Llamar al método de envenenamiento con la probabilidad establecida
            
            System.out.println("La vida del rival ahora es: " + rival.getVida());
        } else {
        	int danio = (int) (Math.random() * 6) + 4;
            rival.setVida(rival.getVida() - danio);
            System.out.println("El cazador ataca con la daga y causa " + danio + " puntos de daño.");
            System.out.println("La vida del rival ahora es: " + rival.getVida());
            int probabilidadEnvenenar = 40; // Por ejemplo, 80% de probabilidad
            envenenado(rival, probabilidadEnvenenar); // Llamar al método de envenenamiento con la probabilidad establecida
        }
    }

    public void ataqueArco(Humano rival) {
        if (rival instanceof Guerrero) {
            int danio = (int) (Math.random() * 11) + 1;
            System.out.println("El cazador apunta y dispara una flecha, causa " + danio + " puntos de daño.");
            int dañoReducido = ((Guerrero) rival).reduccionPorArmadura(danio);
            int dañoTotal = danio - dañoReducido;
            rival.setVida(rival.getVida() - dañoTotal);
            
            int probabilidadEnvenenar = 50; // Por ejemplo, 80% de probabilidad
            envenenado(rival, probabilidadEnvenenar); // Llamar al método de envenenamiento con la probabilidad establecida
            
            System.out.println("La vida del rival ahora es: " + rival.getVida());
        } else {
            int danio = (int) (Math.random() * 11) + 1;
            rival.setVida(rival.getVida() - danio);
            System.out.println("El cazador apunta y dispara una flecha, causa " + danio + " puntos de daño.");
            System.out.println("La vida del rival ahora es: " + rival.getVida());
            int probabilidadEnvenenar = 50; // Por ejemplo, 80% de probabilidad
            envenenado(rival, probabilidadEnvenenar); // Llamar al método de envenenamiento con la probabilidad establecida
        }
    }

    private boolean envenenado(Humano rival, int probabilidadEnvenenar) {
        if (Math.random() * 100 < probabilidadEnvenenar) {
            rival.setVeneno(true);
            System.out.println("El rival ha sido envenenado.");
            return true; // Se envenenó al rival
        } else {
            System.out.println("El rival no ha sido envenenado.");
            return false; // No se envenenó al rival
        }
    }

    /*public int generarDanioEnvenenamiento() {
        // Generar un número de daño aleatorio para el envenenamiento
        int danio = (int) (Math.random() * 2) + 1; // Número aleatorio entre 1 y 2 (inclusive)
        return danio;
    }*/

    /*public void danioXturno(Humano rival) {
        if (rival.isVeneno()) {
            int danioEnvenenamiento = generarDanioEnvenenamiento();
            rival.setVida(getVida()-danioEnvenenamiento);
            System.out.println("El rival sufre " + danioEnvenenamiento + " puntos de daño por envenenamiento.");
            System.out.println("La vida del rival ahora es: " + rival.getVida());
        }
    }*/
}
