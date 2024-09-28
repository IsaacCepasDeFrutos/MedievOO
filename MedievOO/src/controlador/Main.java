package controlador;
import java.util.Scanner;
import metodo.Mago;
import metodo.Cazador;
import metodo.Guerrero;
import metodo.Humano;



public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Elegir el tipo de personaje para el jugador 1.
        System.out.println("Jugador 1, elige tu personaje:");
        System.out.println("1. Mago");
        System.out.println("2. Cazador");
        System.out.println("3. Guerrero");
        int opcionJugador1 = obtenerOpcionValida(scanner);//Utilizamos el scanner para que a traves de la funcion obtenerOpcionValida demos valor a opcionJugador1.
        Humano jugador1 = crearPersonaje(opcionJugador1);//Esto utiliza una funcion que mediante un switch eliges 1, 2 o 3 y crea un objeto que hereda de tipo Humano respectivamente. 

        
        
        // Elegir el tipo de personaje para el jugador 2.
        System.out.println("Jugador 2, elige tu personaje:");
        System.out.println("1. Mago");
        System.out.println("2. Cazador");
        System.out.println("3. Guerrero");
        int opcionJugador2 = obtenerOpcionValida(scanner);//Utilizamos el scanner para que a traves de la funcion obtenerOpcionValida demos valor a opcionJugador2.
        Humano jugador2 = crearPersonaje(opcionJugador2);//Esto utiliza una funcion que mediante un switch eliges 1, 2 o 3 y crea un objeto que hereda de tipo Humano respectivamente. 
        
       
        
        
        
        //Inicializacion del juego.
        boolean juegoEnCurso = true;
        // Inicialización del turno. Siempre el Jugador1 juega primero.
        boolean turnoJugador1 = true;
        boolean turnoJugador2 = false; // Agregado para control explícito, aunque es redundante, es para poder implementar alteraciones en los turnos.
        int contadorTurnos=1;//Inicia el valor del contador de turnos en 1 para ser más familiar con el usuario.
        
        
        
        
        //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::EMPIEZA EL JUEGO (BUCLE):::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
        while (juegoEnCurso) {
        	
        	System.out.println("Turno "+contadorTurnos+"." );//Imprime el turno en el que nos encontramos.
        	
        	//_____Sistema de turnos basado en if else_____Si es el turno del jugador uno no es el del dos_______.
            
        	if (turnoJugador1) {//::::TURNO JUGADOR1:::::
            	
                System.out.println("Turno del Jugador 1:");
                mostrarOpciones(opcionJugador1);//LLama a la función mostrarOpciones dandole como valor las opcionJugador1
                int accionJugador1 = obtenerAccionValida(scanner, obtenerMaxOpciones(opcionJugador1));// Mediante la funcion obtenerMaxOpciones acotados el número max de casos de- 
                //la variable obtenerAccionValida y le da valor a accionJugador1.
                
                
                
                //::::::::::::::::::Arreglo mmmuy acotado para saltar el turno si el jugador es guerrero y elije la opcion de la red.:::::::::::::::::::::::::::::::
                
             
                if (jugador1 instanceof Guerrero && accionJugador1 == 2) {// Verificar si el jugador 1 es un Guerrero y ha seleccionado el ataque con la red.
                    Guerrero guerreroJugador1 = (Guerrero) jugador1;
                    if (guerreroJugador1.ataqueRed(jugador2)) { // Si el ataque con la red fue exitoso
                        guerreroJugador1.saltarSiguienteTurno(jugador2); // Saltar el siguiente turno del jugador 2 si está bajo el efecto de la red.
                    }
                } else {//En caso de no ser asi, transcurre normalmente el turno.
                	
                    ejecutarAccionJugador(opcionJugador1, accionJugador1, jugador1, jugador2);
                    turnoJugador1 = false; //Salir del turno del jugador 1
                    turnoJugador2 = true;// Entrar en el turno del jugador 2
                }
                
                //Chequea si el jugador 2 esta envenenado y si lo está el jugador 1 le aplica el daño.
                if (jugador2.isVeneno()) {
                    jugador1.danioXturno(jugador2);
                }
                
            } else if (turnoJugador2) {//::::TURNO JUGADOR2:::::
            	
                System.out.println("Turno del Jugador 2:");
                mostrarOpciones(opcionJugador2);//LLama a la función mostrarOpciones dandole como valor las opcionJugador2.
                int accionJugador2 = obtenerAccionValida(scanner, obtenerMaxOpciones(opcionJugador2));// Mediante la funcion obtenerMaxOpciones acotados el número max de casos de- 
                //la variable obtenerAccionValida y le da valor a accionJugador1.
                
              //::::::::::::::::::Arreglo mmmuy acotado para saltar el turno si el jugador es guerrero y elije la opcion de la red.:::::::::::::::::::::::::::::::
                
                
                if (jugador2 instanceof Guerrero && accionJugador2 == 2) {// Verificar si el jugador 2 es un Guerrero y ha seleccionado el ataque con la red.
                    Guerrero guerreroJugador2 = (Guerrero) jugador2;
                    if (guerreroJugador2.ataqueRed(jugador1)) { //Si el ataque con la red fue exitoso.
                        guerreroJugador2.saltarSiguienteTurno(jugador1); //Saltar el siguiente turno del jugador 1 si está bajo el efecto de la red.
                        
                    } else {//En caso de no ser asi, transcurre normalmente el turno.
                        ejecutarAccionJugador(opcionJugador2, accionJugador2, jugador2, jugador1);
                        turnoJugador2 = false;//Salir del turno del jugador 2.
                        turnoJugador1 = true;//Entrar en el turno del jugador 1.
                    }
                } else {
                    ejecutarAccionJugador(opcionJugador2, accionJugador2, jugador2, jugador1);
                    turnoJugador2 = false; //Salir del turno del jugador 2.
                    turnoJugador1 = true; //Entrar en el turno del jugador 1.
                } 
                contadorTurnos++;//Suma 1 al contador de turnos.
                
              //Chequea si el jugador 1 esta envenenado y si lo está el jugador 2 le aplica el daño.
                if (jugador1.isVeneno()) {
                    jugador2.danioXturno(jugador1);
                }
            }
                       

            // Verificar si el juego ha terminado en el caso de que la vida de alguno de los jugadores sea 0.
            if (jugador1.getVida() <= 0 || jugador2.getVida() <= 0) {
                juegoEnCurso = false;//ACABA EL BUCLE WHILE POR LO QUE TERMINA EL JUEGO.
                System.out.println("Fin del juego.");
                
                // Determinar el ganador
                if (jugador1.getVida() <= 0 && jugador2.getVida() <= 0) {
                    System.out.println("¡Empate!");
                } else if (jugador1.getVida() <= 0) {
                    System.out.println("¡El Jugador 2 es el ganador!");
                } else {
                    System.out.println("¡El Jugador 1 es el ganador!");
                }
            }

            // Solicitar al usuario presionar Enter para continuar
            System.out.println("Presiona Enter para continuar...");
            scanner.nextLine(); // Consumir el \n que queda del nextInt()
            scanner.nextLine(); // Esperar a que el usuario presione Enter.
        }

        scanner.close();//Cierra el Scanner.

      //:::::::::::::::::::::::::::::::::FINALIZA EL JUEGO:::::::::::::::::::::::::::::::::::::::::::::::::::.
        
    } //FIN DEL METODO MAIN.
    
    
    
//::::::::::::::FUNCIONES DE CONTROL:::::::::::::::::::::::::::::::::::::::.
    public static int obtenerOpcionValida(Scanner scanner) {// Método para obtener una opción válida.
        int opcion;
        do {// Inicio del bucle do-while
            System.out.print("Selecciona una opción válida: ");
            while (!scanner.hasNextInt()) {// Bucle while interno para verificar si la entrada no es un entero.
                System.out.print("Selecciona una opción válida: ");
                scanner.next();// Consumir la entrada no válida
            }
            opcion = scanner.nextInt();// Almacenar la opción ingresada por el usuario.
        } while (opcion < 1 || opcion > 3); //Repetir el bucle si la opción no está en el rango válido (1 a 3).

        return opcion;//Devuelve el valor de opcion.
    }

    public static int obtenerAccionValida(Scanner scanner, int maxOpciones) {// Método para obtener una accion válida a la que le pasamos la cantidad disponible de maxOpciones.
        int accion;
        do {// Inicio del bucle do-while
            
            while (!scanner.hasNextInt()) {// Bucle while interno para verificar si la entrada no es un entero.
                System.out.print("Selecciona una opción válida: ");
                scanner.next();// Consumir la entrada no válida
            }
            accion = scanner.nextInt();// Almacenar la accion ingresada por el usuario.
        } while (accion < 1 || accion > maxOpciones);//Repetir el bucle si la opción no está en el rango válido.
        
        return accion;//Devuelve el valor de opcion.
        
    }
    public static int obtenerMaxOpciones(int opcionPersonaje) {//Funcion para establecer el numero maximo de opciones en cada CASO (Clase). 
        int maxOpciones=0;//Inicializamos a 0 por que es lo que necesita.
        
        switch (opcionPersonaje) {//Damos el valor en funcion al caso con SWITCH.
            case 1: // Mago
                maxOpciones = 3;// Magia, Baston y Pocion.
                break;
            case 2: // Cazador 
                maxOpciones = 2; //Daga y Arco.
                break;
            case 3: // Guerrero
                maxOpciones = 2; //Espada y Red.
                break;      
        }
        return maxOpciones;//Devuelve el valor.
    }
    

    
    public static Humano crearPersonaje(int opcion) {//Da valor a opcion en funcion de la salida de un SWITCH.
        switch (opcion) {
            case 1:
                return new Mago(); //Crea objeto Mago.
            case 2:
                return new Cazador(); //Crea objeto Cazador.
            case 3:
                return new Guerrero(); //Crea objeto Guerrero.
            default:
                System.out.println("Opción no válida, creando Mago por defecto."); //Esto con las limitaciones no va a pasar NUNCA.
                return new Mago();
        }
    }
  //::::::::::::::FUNCIONES DE JUEGO:::::::::::::::::::::::::::::::::::::::
    public static void mostrarOpciones(int opcionPersonaje) { //Función para Mostrar las posibilidades de cada objeto.
        switch (opcionPersonaje) {
            case 1: // Mago
                System.out.println("Selecciona una opción:");
                System.out.println("1. Ataque con magia");
                System.out.println("2. Ataque con bastón");
                System.out.println("3. Usar poción curativa");
                break;
            case 2: // Cazador
            	System.out.println("Selecciona una opción:");
                System.out.println("1. Ataque con daga");
                System.out.println("2. Ataque con arco");
                break;
            case 3: // Guerrero
                System.out.println("Selecciona una opción:");
                System.out.println("1. Ataque con la espada");
                System.out.println("2. Ataque con la red (Solo una vez por partida)");
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
        System.out.print("Opción: ");
    }

    public static void ejecutarAccionJugador(int opcionPersonaje, int accion, Humano jugadorActual, Humano rival) {// Ejecuta la accion del jugador. El SWITCH maneja Personajes.
    																												//La estructura if/else se encarga de ejecutar las acciones en funcion de "accion".
        switch (opcionPersonaje) {
            case 1: // Mago
                if (accion == 1) {//Si la accion del Mago es 1 El jugador actual emplea la funcion ataqueMagia() contra el rival.
           
                    ((Mago) jugadorActual).ataqueMagia(rival);
                    
                } else if (accion == 2) {//Si la accion del Mago es 2 El jugador actual emplea la funcion ataqueBaston() contra el rival.
                	
                    ((Mago) jugadorActual).ataqueBaston(rival);
                    
                } else if (accion == 3) {//Si la accion del Mago es 3 El jugador actual emplea la funcion pocionCurativa() contra el jugadorActual(Es decir, sobre si mismo).
                	
                    ((Mago) jugadorActual).pocionCurativa(jugadorActual);
                    
                } else {
                    System.out.println("Opción no válida"); //No va a pasar.
                }
                break;
            case 2: // Cazador
            	if (accion == 1) {
                    ((Cazador) jugadorActual).ataqueDaga(rival);
                } else if (accion == 2) {
                    ((Cazador) jugadorActual).ataqueArco(rival);
                } else {
                    System.out.println("Opción no válida");
                }
                break;
            default:
                System.out.println("Opción no válida");
                break;
            case 3: // Guerrero
                if (accion == 1) {
                    ((Guerrero) jugadorActual).ataqueEspada(rival);
                } else if (accion == 2) {
                    ((Guerrero) jugadorActual).ataqueRed(rival);
                } else {
                    System.out.println("Opción no válida");
                }
                break;
            
        }
    }


}//FIN DE LA CLASE MAIN :)



