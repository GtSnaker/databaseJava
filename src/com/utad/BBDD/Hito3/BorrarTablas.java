package com.utad.BBDD.Hito3;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * clase que llama a todos los metodos borrar de cada una de las clases DAO
 * 
 * @see *DAO
 */
public class BorrarTablas {
	
	public static void elegir(DbConnection connection) throws ClassNotFoundException, SQLException{
		System.out.println("1 para borrar JUGADOR");
		System.out.println("2 para borrar LIGA");
		System.out.println("3 para borrar JUGADORXJUGADOR");
		System.out.println("4 para borrar LOGRO");
		Scanner sc = new Scanner(System.in);
		String numero = sc.nextLine();
		int opcion;
		try {
			opcion = Integer.parseInt(numero);
			if (opcion < 1 || opcion > 7) {
				System.out.println("Solo son validos numeros del 1 al 7");
			} else {
				switch (opcion) {
				case 1:
					BorrarTablas.borrarJugador(connection);
					break;
				case 2:
					BorrarTablas.borrarLiga(connection);
					break;
				case 3:	
					BorrarTablas.borrarJugadorXJugador(connection);
					break;
				case 4:
					BorrarTablas.borrarLogro(connection);
					break;
				case 5:
					break;
				case 6:
					System.out.println("caso 6");
					break;
				case 7:
					break;
				}
			}
		} catch (NumberFormatException ex) {
			System.out.println("Introduce un numero por favor...");
		}
	}
	
	public static void borrarJugador(DbConnection connection) throws ClassNotFoundException, SQLException {
		JugadorDAO miJugadorDAO = new JugadorDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el id de el jugador que quieres eliminar: ");
		int id = sc.nextInt();
		miJugadorDAO.borrar(connection, id);
		System.out.println("Se ha borrado al jugador con id: " + id + " exitosamente.");
	}
	
	public static void borrarLiga(DbConnection connection) throws ClassNotFoundException, SQLException {
		LigaDAO miLigaDAO = new LigaDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el id de la liga que quieres eliminar: ");
		int id = sc.nextInt();
		miLigaDAO.borrar(connection, id);
		System.out.println("Se ha borrado la liga con id: " + id + " exitosamente.");
	}
	
	public static void borrarJugadorXJugador(DbConnection connection) throws ClassNotFoundException, SQLException {
		JugadorXJugadorDAO miJugadorXJugadorDAO = new JugadorXJugadorDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el id de el primer jugador amigo que quieres eliminar: ");
		int id = sc.nextInt();
		System.out.println("Introduce el id de el segundo jugador amigo que quieres eliminar: ");
		int id2 = sc.nextInt();
		miJugadorXJugadorDAO.borrar(connection, id, id2);
		System.out.println("Se ha borrado el jugadorxjugador con id: " + id + " id2: "+ id2+" exitosamente.");
	}
	
	public static void borrarLogro(DbConnection connection) throws ClassNotFoundException, SQLException {
		LogroDAO miLogroDAO = new LogroDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el id de el logro que quieres eliminar: ");
		int id = sc.nextInt();
		miLogroDAO.borrar(connection, id);
		System.out.println("Se ha borrado la liga con id: " + id + " exitosamente.");
	}
	
}
