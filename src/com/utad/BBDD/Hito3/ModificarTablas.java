package com.utad.BBDD.Hito3;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

public class ModificarTablas {
	public static void elegir(DbConnection connection) throws ClassNotFoundException, SQLException{
		System.out.println("1 para modificar JUGADOR");
		System.out.println("2 para modificar LIGA");
		System.out.println("3 para modificar JUGADORXJUGADOR");
		System.out.println("4 para modificar LOGRO");
		System.out.println("5 para modificar MAPA");
		System.out.println("6 para modificar PERIODO");
		System.out.println("7 para modificar RAZA");
		System.out.println("8 para modificar SERVIDOR");
		System.out.println("9 para modificar TORNEO");
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
					ModificarTablas.modificarJugador(connection);
					break;
				case 2:
					ModificarTablas.modificarLiga(connection);
					break;
				case 3:
					ModificarTablas.modificarJugadorXJugador(connection);
					break;
				case 4:
					ModificarTablas.modificarLogro(connection);
					break;
				case 5:
					ModificarTablas.modificarMapa(connection);
					break;
				case 6:
					ModificarTablas.modificarPeriodo(connection);
					break;
				case 7:
					ModificarTablas.modificarRaza(connection);
					break;
				case 8:
					ModificarTablas.modificarServidor(connection);
					break;
				case 9:
					ModificarTablas.modificarTorneo(connection);
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
	
	public static void modificarJugadorXJugador(DbConnection connection) throws ClassNotFoundException, SQLException{
		JugadorXJugadorDAO miJugadorXJugadorDAO = new JugadorXJugadorDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el id el primer jugador amigo que quieres modificar: ");
		int id = sc.nextInt();
		System.out.println("Introduce el id el segundo jugador amigo que quieres modificar: ");
		int id2 = sc.nextInt();
		miJugadorXJugadorDAO.modificar(connection, id, id2);
	}
	
	public static void modificarLogro(DbConnection connection) throws ClassNotFoundException, SQLException{
		LogroDAO miLogroDAO = new LogroDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el id de la liga que quieres modificar: ");
		int id = sc.nextInt();
		miLogroDAO.modificar(connection, id);
	}
	
	public static void modificarMapa(DbConnection connection) throws ClassNotFoundException, SQLException{
		MapaDAO miMapaDAO = new MapaDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el id de el mapa que quieres modificar: ");
		int id = sc.nextInt();
		miMapaDAO.modificar(connection, id);
	}
	
	public static void modificarPeriodo(DbConnection connection) throws ClassNotFoundException, SQLException{
		PeriodoDAO miPeriodoDAO = new PeriodoDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce la fecha de inicio: YY-MM-DD HH24:MM:SS");
		String inicio = (sc.nextLine());
		System.out.println("Introduce la fecha de fin: YY-MM-DD HH24:MM:SS");
		String fin = (sc.nextLine());
		miPeriodoDAO.modificar(connection, inicio, fin);
	}
	
	public static void modificarRaza(DbConnection connection) throws ClassNotFoundException, SQLException{
		RazaDAO miRazaDAO = new RazaDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el nombre de el Raza que quieres modificar: ");
		Raza raza = Raza.valueOf(sc.nextLine());
		miRazaDAO.modificar(connection, raza);
	}
	
	public static void modificarServidor(DbConnection connection) throws ClassNotFoundException, SQLException{
		ServidorDAO miServidorDAO = new ServidorDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el id de el servidor que quieres modificar: ");
		int valor = sc.nextInt();
		miServidorDAO.modificar(connection, valor);
	}
	
	public static void modificarTorneo(DbConnection connection) throws ClassNotFoundException, SQLException{
		TorneoDAO miTorneoDAO = new TorneoDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el nombre del torneo que quieres modificar: ");
		String nombre = sc.nextLine();
		System.out.println("Introduce el id de la liga del torneo que quieres eliminar: ");
		int liga = Integer.parseInt(sc.nextLine());
		miTorneoDAO.modificar(connection, nombre, liga);
	}
	public static void modificarJugadorXPeriodoXMapaXServidor(DbConnection connection) throws ClassNotFoundException, SQLException{
		JugadorXPeriodoXMapaXServidorDAO miJugadorXPeriodoXMapaXServidorDAO = new JugadorXPeriodoXMapaXServidorDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el id: ");
		int id = sc.nextInt();
		System.out.println("Introduce la fecha de inicio: YY-MM-DD HH24:MM:SS");
		String inicio = sc.nextLine();
		miJugadorXPeriodoXMapaXServidorDAO.modificar(connection, id,inicio);
	}
	
	public static void modificarJugadorXRaza(DbConnection connection) throws ClassNotFoundException, SQLException{
		JugadorXRazaDAO miJugadorXRazaDAO = new JugadorXRazaDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el id : ");
		int id = sc.nextInt();
		System.out.println("Introduce el nombre de la raza: ");
		String nombreRaza = sc.nextLine();
		Raza miRaza = Raza.valueOf(nombreRaza);
		System.out.println("Introduce el numero de partidas ganadas: ");
		int ganadas = sc.nextInt();
		System.out.println("Introduce el numero de partidas perdidas: ");
		int perdidas = sc.nextInt();
		miJugadorXRazaDAO.modificar(connection, id , miRaza);
	}
	
	public static void modificarJugadorXServidor(DbConnection connection) throws ClassNotFoundException, SQLException{
		JugadorXServidorDAO miJugadorXServidorDAO = new JugadorXServidorDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el idJugador : ");
		int idJugador = sc.nextInt();
		System.out.println("Introduce el idServidor: ");
		int idServidor = sc.nextInt();
		System.out.println("Introduce la fecha de inicio: YY-MM-DD HH24:MM:SS");
		String inicio = sc.nextLine();
		miJugadorXServidorDAO.modificar(connection, idJugador , idServidor, inicio);
	}
	
	public static void modificarJugadorXTorneo(DbConnection connection) throws ClassNotFoundException, SQLException{
		JugadorXTorneoDAO miJugadorXTorneoDAO = new JugadorXTorneoDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el idJugador : ");
		int id = sc.nextInt();
		System.out.println("Introduce el nombre: ");
		String nombre = sc.nextLine();
		miJugadorXTorneoDAO.modificar(connection, id , nombre);
	}
}
