package metodo;

public class Mago extends Humano {
private int baston;
private int rayos;
private int pocion;

public Mago() {
	
}
public Mago(int vida, int baston, int rayos, int pocion) {
	super(vida);
	this.baston = baston;
	this.rayos = rayos;
	this.pocion = pocion;
}
public int getBaston() {
	return baston;
}
public void setBaston(int baston) {
	this.baston = baston;
}
public int getRayos() {
	return rayos;
}
public void setRayos(int rayos) {
	this.rayos=rayos;
}
public int getPocion() {
	return pocion;
}
public void setPocion(int pocion) {
	this.pocion = pocion;
}
@Override
public String toString() {
	return "Mago [baston=" + baston + ", rayos=" + rayos + ", pocion=" + pocion + ", toString()=" + super.toString()
			+ "]";
}
 //Funciones::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
public void ataqueMagia(Humano rival) {
	if (rival instanceof Guerrero) {
        
    
	int daño = (int) (Math.random() * 11) + 1;
	System.out.println("El mago ataca con magia y causa " + daño + " puntos de daño.");
    int dañoReducido = ((Guerrero) rival).reduccionPorArmadura(daño);
    int dañoTotal = daño - dañoReducido;
    rival.setVida(rival.getVida() - dañoTotal);
    
    System.out.println("La vida del rival ahora es: " + rival.getVida());
	}else {
		int daño = (int) (Math.random() * 11) + 1;
        rival.setVida(rival.getVida() - daño);
        System.out.println("El mago ataca con magia y causa " + daño + " puntos de daño.");
        System.out.println("La vida del rival ahora es: " + rival.getVida());
		
	}
}

public void ataqueBaston(Humano rival) {
    if (rival instanceof Guerrero) {
        int daño = (int) (Math.random() * 3) + 5;
        System.out.println("El mago ataca con el bastón y causa " + daño + " puntos de daño.");
        int dañoReducido = ((Guerrero) rival).reduccionPorArmadura(daño);
        int dañoTotal = daño - dañoReducido;
        rival.setVida(rival.getVida() - dañoTotal);
        
        System.out.println("La vida del Guerrero ahora es: " + rival.getVida());
    

        
        
        
    }else {
    	int daño = (int) (Math.random() * 3) + 5;
        rival.setVida(rival.getVida() - daño);
        System.out.println("El mago ataca con el bastón y causa " + daño + " puntos de daño.");
        System.out.println("La vida del rival ahora es: " + rival.getVida());
    }
}
    
    


public void pocionCurativa(Humano usuario) {
	int cura=(int)(Math.random() * 7) + 1;
	usuario.setVida(usuario.getVida()+cura);
	System.out.println("El mago se toma una poción y recupera " + cura + " puntos de vida.");
    System.out.println("Tu vida ahora es de: " + usuario.getVida()+" puntos");
}



}
