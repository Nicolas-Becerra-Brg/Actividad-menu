import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    
	public static boolean victoria=false;
	public static int juegosJugados = 0;
    public static int juegosGanados = 0;
        
	public static void crearPerfil(String nombre) {
        try {
            File archivoPerfil = new File(nombre + ".txt");
            FileWriter writerPerfil = new FileWriter(archivoPerfil);
            writerPerfil.write("Nombre: " + nombre + "\n");
            writerPerfil.write("Juegos Jugados: 0\n");
            writerPerfil.write("Juegos Ganados: 0\n");
            writerPerfil.close();
            System.out.println("Perfil creado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al crear el archivo.");
        }
    }
	
	public static void abrirPerfil(String nombre) {
        try {
            File archivoPerfil = new File(nombre + ".txt");
            Scanner readerPerfil = new Scanner(archivoPerfil);
            String linea1 = readerPerfil.nextLine();
            String linea2 = readerPerfil.nextLine();
            String linea3 = readerPerfil.nextLine();
            readerPerfil.close();
            System.out.println("Perfil cargado exitosamente.");
            System.out.println(linea1);
            System.out.println(linea2);
            System.out.println(linea3);
            jugarAdivinaQuien(nombre, archivoPerfil);
        } catch (IOException e) {
            System.out.println("Error al abrir el archivo.");
        }
    }
	
	public static void jugarAdivinaQuien(String nombre, File archivoPerfil) {
        Scanner input = new Scanner(System.in);
        
        try {
            Scanner readerPerfil = new Scanner(archivoPerfil);
            readerPerfil.nextLine(); 
            juegosJugados = Integer.parseInt(readerPerfil.nextLine().split(": ")[1]);
            juegosGanados = Integer.parseInt(readerPerfil.nextLine().split(": ")[1]);
            readerPerfil.close();
        } catch (IOException e) {
            System.out.println("Error al abrir el archivo.");
        }
        System.out.println("¡Adivina Quién!");
        juegosJugados++;
        if (victoria == true) {
            juegosGanados++;
        }
        actualizarEstadisticas(nombre, juegosJugados, juegosGanados);
        input.close();
    }
	
	public static void actualizarEstadisticas(String nombre, int juegosJugados, int juegosGanados) {
        try {
            File archivoPerfil = new File(nombre + ".txt");
            Scanner readerPerfil = new Scanner(archivoPerfil);
            String linea1 = readerPerfil.nextLine();
            readerPerfil.close();
            FileWriter writerPerfil = new FileWriter(archivoPerfil);
            writerPerfil.write(linea1 + "\n");
            writerPerfil.write("Juegos Jugados: " + juegosJugados + "\n");
            writerPerfil.write("Juegos Ganados: " + juegosGanados + "\n");
            writerPerfil.close();
            System.out.println("Estadísticas actualizadas exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al actualizar el archivo.");
        }
    }
	
	public static void main(String[] args) {
       
       Scanner input = new Scanner(System.in);
       
       System.out.println("¡Bienvenido al Menú Principal del Juego!");
       System.out.println("1. Crear Nuevo Perfil");
       System.out.println("2. Abrir Perfil Existente");
       System.out.print("Seleccione una opción: ");
       
       int opcion = input.nextInt();
       
       if (opcion == 1) {
           System.out.print("Por favor ingrese su nombre: ");
           String nombre = input.next();
           crearPerfil(nombre);
           juego();
       } else if (opcion == 2) {
           System.out.print("Por favor ingrese el nombre del perfil existente: ");
           String nombre = input.next();
           abrirPerfil(nombre);
           juego();
           
       } else {
           System.out.println("Opción inválida. Por favor seleccione 1 o 2.");
       }
       
       input.close();
   
	}
	
	public static void juego() { 
		System.out.println("JUEGO ADIVINA QUIEN?");

	       List<String> caracteristicasImportantes = Arrays.asList("Es bizco", "Es pelon", "Tiene brazos", 
					"Está Fuerte", "Esta cansado", "Está Feo", "Está Enfermo", "Está Triste", "Está Feliz");
		
		
		Scanner sc = new Scanner(System.in);
       Person[] persona = new Person[10];
       for (int i = 0; i < 10; i++) {
           persona[i] = new Person() {};
       }
       for (Person personas : persona) {
           System.out.print(personas.getNombre() + ": ");
           int contador = 0;
           for (String caracteristica : caracteristicasImportantes) {
               switch (caracteristica) {
                   case "Es bizco":
                       if (personas.getbizco()) {
                       
                           System.out.print("Es bizco, ");
                           contador++;
                       }
                       break;
                   case "Es pelon":
                       if (personas.getpelon() ) {
                          
                           System.out.print("Es pelon, ");
                           contador++;
                       }
                       break;
                   case "Tiene brazos":
                       if (personas.getbrazos()) {
                         
                           System.out.print("Tiene brazos, ");
                           contador++;
                       }
                       break;
                   case "Está Feo":
           if (personas.getEstaFeo()) {
               
               System.out.print("Está Feo, ");
               contador++;
           }
           break;
                   case "Está Fuerte":
           if (personas.getfuerte()) {
               
               System.out.print("Está Fuerte, ");
               contador++;
           }
           break;
                   case "Esta cansado":
           if (personas.getEstaCansado()) {
           
               System.out.print("Esta cansado, ");
               contador++;
           }
           break;
                   case "Está Enfermo":
           if (personas.getEstaEnfermo()) {
            
               System.out.print("Está Enfermo, ");
               contador++;
           }
           break;
                   case "Está Triste":
           if (personas.getEstaTriste()) {
               
               System.out.print("Está Triste, ");
               contador++;
           }
           break;
                   case "Está Feliz":
           if (personas.getEstaFeliz()) {
               
               System.out.print("Está Feliz, ");
               contador++;
           }
           break;
               }
               if (contador == 4) {
                   break;
               }
           }
           System.out.println("");
       }
       
      
        
       System.out.println("QUE COMIENCE EL JUEGO");
       
       int personaElegida = new Random().nextInt(10);
       
   
       for (int contadorPreguntas = 0; contadorPreguntas < 5; contadorPreguntas++) {
           System.out.println("Elija una opción para descartar jugadores:");
           System.out.println("1. ¿Es bizco?");
           System.out.println("2. ¿Es pelon?");
           System.out.println("3. ¿tiene brazos?");
           System.out.println("4. ¿Está Feo?");
           System.out.println("5. ¿esta fuerte?");
           System.out.println("6. ¿Está Cansado?");
           System.out.println("7. ¿Está Enfermo?");
           System.out.println("8. ¿Está Triste?");
           System.out.println("9. ¿Está Feliz?");
           
           int opcion_1 = sc.nextInt();
           switch (opcion_1) {
               case 1:
                   for (int i = 0; i < 10; i++) {
                   	  if (persona[i] != null && !persona[i].getbizco()) {
                             persona[i] = null;
                         }
                     }
                     break;
               case 2:
               	for (int i = 0; i < 10; i++) {
               		  if (persona[i] != null && !persona[i].getpelon()) {
               	            persona[i] = null;
               	        }
               	    }
               	    break;
               	case 3:
               		for (int i = 0; i < 10; i++) {
               		  if (persona[i] != null && !persona[i].getbrazos()) {
               	            persona[i] = null;
               	        }
               	    }
               	    break;
               	case 4:
               	for (int i = 0; i < 10; i++) {
               		  if (persona[i] != null && !persona[i].getEstaFeo()) {
               	            persona[i] = null;
               	        }
               	    }
               	    break;
               	case 5:
               	for (int i = 0; i < 10; i++) {
               		  if (persona[i] != null && !persona[i].getfuerte()) {
               	            persona[i] = null;
               	        }
               	    }
               	    break;
               	case 6:
               	for (int i = 0; i < 10; i++) {
               		  if (persona[i] != null && !persona[i].getEstaCansado()) {
               	            persona[i] = null;
               	        }
               	    }
               	    break;
               	case 7:
               	for (int i = 0; i < 10; i++) {
               		  if (persona[i] != null && !persona[i].getEstaEnfermo()) {
               	            persona[i] = null;
               	        }
               	    }
               	    break;
               	case 8:
               	for (int i = 0; i < 10; i++) {
               		  if (persona[i] != null && !persona[i].getEstaTriste()) {
               	            persona[i] = null;
               	        }
               	    }
               	    break;
               	case 9:
               	for (int i = 0; i < 10; i++) {
               		  if (persona[i] != null && !persona[i].getEstaFeliz()) {
               	            persona[i] = null;
               	        }
               	    }
               	    break;
               	}
        
           int numeroPersonasElegidas = 0;
           for (int i = 0; i < 10; i++) {
           if (persona[i] != null) {
           numeroPersonasElegidas++;
           }
           }
           
           if (numeroPersonasElegidas == 1) {
           for (int i = 0; i < 10; i++) {
           if (persona[i] != null) {
           	System.out.println("La persona elegida es " + persona[i].getNombre());
           	break;
           	}
           	}
           	return;
           	}
           System.out.println("Las personas que cumplen con la característica son: ");
           for (int i = 0; i < 10; i++) {
           if (persona[i] != null) {
           System.out.println((i + 1) + ". " + persona[i].getNombre());
           }
           }
           System.out.println("");
           }
       
       System.out.println("Elige la persona que crees que es la elegida (Introduce el número de la persona):");
       int eleccionUsuario = sc.nextInt();
       eleccionUsuario--;

     
       if (persona[eleccionUsuario] != null) {
           System.out.println("¡Correcto! La persona elegida es " + persona[eleccionUsuario].getNombre());
           victoria = true;
       } else {
           System.out.println("Incorrecto, la persona elegida no cumplía con las características");
       }
       
       
       }
	
	

       }