package _Tablas;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

import com.utad.BBDD.Hito3.DbConnection;

import DAOs.JugadorDAO;
import DAOs.JugadorXJugadorDAO;
import DAOs.JugadorXLogroDAO;
import DAOs.JugadorXPeriodoXMapaXServidorDAO;
import DAOs.JugadorXRazaDAO;
import DAOs.JugadorXServidorDAO;
import DAOs.JugadorXTorneoDAO;
import DAOs.LigaDAO;
import DAOs.LogroDAO;
import DAOs.MapaDAO;
import DAOs.PeriodoDAO;
import DAOs.RazaDAO;
import DAOs.ServidorDAO;
import DAOs.TorneoDAO;
import ENUMs.Raza;

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
		System.out.println("8 para borrar SERVIDOR");
		System.out.println("9 para borrar TORNEO");
		System.out.println("10 para borrar JUGADORXPERIODOXMAPAXSERVIDOR");
		System.out.println("11 para borrar JUGADORXRAZA");
		System.out.println("12 para borrar JUGADORXSERVIDOR");
		System.out.println("13 para borrar JUGADORXTORNEO");
		System.out.println("14 para borrar JUGADORXLOGRO");
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
					BorrarTablas.borrarServidor(connection);
					break;
				case 9:
					BorrarTablas.borrarTorneo(connection);
					break;
				case 10:
					BorrarTablas.borrarJugadorXPeriodoXMapaXServidor(connection);
					break;
				case 11:
					BorrarTablas.borrarJugadorXRaza(connection);
					break;
				case 12:
					BorrarTablas.borrarJugadorXServidor(connection);
					break;
				case 13:
					BorrarTablas.borrarJugadorXTorneo(connection);
					break;
				case 14:
					BorrarTablas.borrarJugadorXLogro(connection);
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
		System.out.println("Introduce la fecha de inicio: YY-MM-DD HH24:MM:SS");
		String inicio = (sc.nextLine());
		System.out.println("Introduce la fecha de fin: YY-MM-DD HH24:MM:SS");
		String fin = (sc.nextLine());
		miPeriodoDAO.borrar(connection, inicio, fin);
		System.out.println("Se ha borrado el periodo con inicio: " + inicio + " y fin: " + fin);
	}
	
	public static void borrarRaza(DbConnection connection) throws ClassNotFoundException, SQLException {
		RazaDAO miRazaDAO = new RazaDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el nombre de la raza que quieres eliminar: ");
		Raza raza = Raza.valueOf(sc.nextLine());
		miRazaDAO.borrar(connection, raza);
		System.out.println("Se ha borrado la raza con nombre: " + raza + " exitosamente.");
	}
	
	public static void borrarServidor(DbConnection connection) throws ClassNotFoundException, SQLException {
		ServidorDAO miServidorDAO = new ServidorDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el id del servidor que quieres eliminar: ");
		int valor = sc.nextInt();
		miServidorDAO.borrar(connection, valor);
		System.out.println("Se ha borrado el servidor con id: " + valor + " exitosamente.");
	}
	
	public static void borrarTorneo(DbConnection connection) throws ClassNotFoundException, SQLException {
		TorneoDAO miTorneoDAO = new TorneoDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el nombre del torneo que quieres eliminar: ");
		String nombre = sc.nextLine();
		System.out.println("Introduce el id de la liga del torneo que quieres eliminar: ");
		int liga = sc.nextInt();
		miTorneoDAO.borrar(connection, nombre, liga);
		System.out.println("Se ha borrado el torneo con nombre: " + nombre + " y liga: " + liga);
	}
	
	public static void borrarJugadorXPeriodoXMapaXServidor(DbConnection connection) throws ClassNotFoundException, SQLException {
		JugadorXPeriodoXMapaXServidorDAO miJugadorXPeriodoXMapaXServidorDAO = new JugadorXPeriodoXMapaXServidorDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el id de el jugador creador de la batalla que quieres eliminar: ");
		int idJugador = sc.nextInt();
		System.out.println("Introduce la fecha de inicio: YY-MM-DD HH24:MM:SS");
		String inicio = (sc.nextLine());
		miJugadorXPeriodoXMapaXServidorDAO.borrar(connection, idJugador, inicio);
		System.out.println("Se ha borrado el jugadorxperiodoxmapaxservidor con idJugador: " + idJugador + " inicio: "+ inicio+" exitosamente.");
	}
	
	public static void borrarJugadorXRaza(DbConnection connection) throws ClassNotFoundException, SQLException {
		JugadorXRazaDAO miJugadorXRazaDAO = new JugadorXRazaDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el id del jugador  que quieres eliminar: ");
		int id = sc.nextInt();
		System.out.println("Introduce el id del nombre de la raza de la fila que quieres eliminar: ");
		String nombre = sc.nextLine();
		Raza miRaza = Raza.valueOf(nombre);
		miJugadorXRazaDAO.borrar(connection, id, miRaza);
		System.out.println("Se ha borrado el jugadorxRaza con idJugador: " + id + " con raza: "+ miRaza +" exitosamente.");
	}
	
	public static void borrarJugadorXServidor(DbConnection connection) throws ClassNotFoundException, SQLException {
		JugadorXServidorDAO miJugadorXServidorDAO = new JugadorXServidorDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el id del jugador de la fila que quieres eliminar: ");
		int idJugador = sc.nextInt();
		System.out.println("Introduce el id del servidor de la fila que quieres eliminar: ");
		int idServidor = sc.nextInt();
		System.out.println("Introduce la fecha de inicio: YY-MM-DD HH24:MM:SS");
		String inicio = (sc.nextLine());
		miJugadorXServidorDAO.borrar(connection, idJugador, idServidor, inicio);
		System.out.println("Se ha borrado el jugadorxservidor con idJugador: " + idJugador + " con idServidor: "+ idServidor + "con inicio:" + inicio + " exitosamente.");
	}
	
	public static void borrarJugadorXTorneo(DbConnection connection) throws ClassNotFoundException, SQLException {
		JugadorXTorneoDAO miJugadorXTorneoDAO = new JugadorXTorneoDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el id de la fila que quieres eliminar: ");
		int id = sc.nextInt();
		System.out.println("Introduceel nombre del torneo de la fila que quieres eliminar");
		String nombre = (sc.nextLine());
		miJugadorXTorneoDAO.borrar(connection, id, nombre);
		System.out.println("Se ha borrado el jugadorxtorneo con id: " + id + " con idServidor: "+ id + " exitosamente.");
	}
	
	public static void borrarJugadorXLogro(DbConnection connection) throws ClassNotFoundException, SQLException {
		JugadorXLogroDAO miJugadorXLogroDAO = new JugadorXLogroDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el idJugador: ");
		int idJugador = sc.nextInt();
		System.out.println("Introduce el idLogro: ");
		int idLogro = sc.nextInt();
		miJugadorXLogroDAO.borrar(connection, idJugador, idLogro);
		System.out.println("Se ha borrado el jugadorxlogro con idJugador: " + idJugador + " con idServidor: "+ idLogro + " exitosamente.");
	}
}
