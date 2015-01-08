package com.utad.BBDD.Hito3;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
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
		System.out.println("5 para borrar MAPA");
		System.out.println("6 para borrar PERIODO");
		System.out.println("7 para borrar RAZA");
		Scanner sc = new Scanner(System.in);
		String numero = sc.nextLine();
		int opcion;
		try {
			opcion = Integer.parseInt(numero);
			if (opcion < 1 || opcion > 14) {
				System.out.println("Solo son validos numeros del 1 al 14");
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
					BorrarTablas.borrarMapa(connection);
					break;
				case 6:
					BorrarTablas.borrarPeriodo(connection);
					break;
				case 7:
					BorrarTablas.borrarRaza(connection);
					break;
				case 8:
					break;
				case 9:
					break;
				case 10:
					break;
				case 11:
					break;
				case 12:
					break;
				case 13:
					break;
				case 14:
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
	
	public static void borrarMapa(DbConnection connection) throws ClassNotFoundException, SQLException {
		MapaDAO miMapaDAO = new MapaDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el id de el mapa que quieres eliminar: ");
		int id = sc.nextInt();
		miMapaDAO.borrar(connection, id);
		System.out.println("Se ha borrado la liga con id: " + id + " exitosamente.");
	}
	
	public static void borrarPeriodo(DbConnection connection) throws ClassNotFoundException, SQLException {
		PeriodoDAO miPeriodoDAO = new PeriodoDAO();
		Scanner sc = new Scanner(System.in);	
		System.out.println("Introdce el año del inicio: ");
		int anio = sc.nextInt();
		System.out.println("Introdce el mes del inicio: ");
		int mes = sc.nextInt();
		System.out.println("Introdce el dia del inicio: ");
		int dia = sc.nextInt();
		System.out.println("Introdce la hora del inicio: ");
		int hora = sc.nextInt();
		System.out.println("Introdce el minuto del inicio: ");
		int minuto = sc.nextInt();
		System.out.println("Introdce el segundo del inicio: ");
		int segundo = sc.nextInt();
		System.out.println("Introdce el nano del inicio: ");
		int nano = sc.nextInt();
		Timestamp dato = new Timestamp(anio, mes, dia, hora, minuto, segundo, nano);
		System.out.println("Introdce el año del fin: ");
		anio = sc.nextInt();
		System.out.println("Introdce el mes del fin: ");
		mes = sc.nextInt();
		System.out.println("Introdce el dia del fin: ");
		dia = sc.nextInt();
		System.out.println("Introdce la hora del fin: ");
		hora = sc.nextInt();
		System.out.println("Introdce el minuto del fin: ");
		minuto = sc.nextInt();
		System.out.println("Introdce el segundo del fin: ");
		segundo = sc.nextInt();
		System.out.println("Introdce el nano del fin: ");
		nano = sc.nextInt();
		Timestamp dato2 = new Timestamp(anio, mes, dia, hora, minuto, segundo, nano);
		miPeriodoDAO.borrar(connection, dato, dato2);
		System.out.println("Se ha borrado el periodo con inicio: " + dato + " y fin: " + dato2);
	}
	
	public static void borrarRaza(DbConnection connection) throws ClassNotFoundException, SQLException {
		RazaDAO miRazaDAO = new RazaDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el nombre de la raza que quieres eliminar: ");
		Raza raza = Raza.valueOf(sc.nextLine());
		miRazaDAO.borrar(connection, raza);
		System.out.println("Se ha borrado la raza con nombre: " + raza + " exitosamente.");
	}
}
