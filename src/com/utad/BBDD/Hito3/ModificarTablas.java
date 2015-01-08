package com.utad.BBDD.Hito3;

import java.sql.SQLException;
import java.util.Scanner;

public class ModificarTablas {
	public static void elegir(DbConnection connection) throws ClassNotFoundException, SQLException{
		System.out.println("1 para modificar JUGADOR");
		System.out.println("2 para modificar LIGA");
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
					ModificarTablas.modificarJugador(connection);
					break;
				case 2:
					ModificarTablas.modificarLiga(connection);
					break;
				case 3:	
					break;
				case 4:
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
	
	public static void modificarJugador(DbConnection connection) throws ClassNotFoundException, SQLException{
		JugadorDAO miJugadorDAO = new JugadorDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el id de el jugador que quieres modificar: ");
		int id = sc.nextInt();
		miJugadorDAO.modificar(connection, id);
	}
	
	public static void modificarLiga(DbConnection connection) throws ClassNotFoundException, SQLException{
		LigaDAO miLigaDAO = new LigaDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el id de la liga que quieres modificar: ");
		int id = sc.nextInt();
		miLigaDAO.modificar(connection, id);
	}
}
