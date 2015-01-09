package com.utad.BBDD.Hito3;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * clase que llama a todos los metodos ver de cada una de las clases DAO
 * 
 * @see *DAO
 */
public class VerTablas {

	public static void elegir(DbConnection connection)
			throws ClassNotFoundException, SQLException {
		System.out.println("1 para ver las tablas de JUGADOR");
		System.out.println("2 para ver las tablas de LIGA");
		System.out.println("3 para ver las tablas de JUGADORXJUGADOR");
		System.out.println("4 para ver las tablas de LOGRO");
		System.out.println("5 para ver las tablas de MAPA");
		System.out.println("6 para ver las tablas de PERIODO");
		System.out.println("7 para ver las tablas de RAZA");
		System.out.println("8 para ver las tablas de SERVIDOR");
		System.out.println("9 para ver las tablas de TORNEO");
		System.out.println("10 para ver las tablas de JUGADORXPERIODOXMAPAXSERVIDOR");
		System.out.println("11 para ver las tablas de JUGADORXRAZA");
		System.out.println("12 para ver las tablas de JUGADORXSERVIDOR");
		System.out.println("13 para ver las tablas de JUGADORXTORNEO");
		System.out.println("14 para ver las tablas de JUGADORXLOGRO");
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
					VerTablas.verJugador(connection);
					break;
				case 2:
					VerTablas.verLiga(connection);
					break;
				case 3:
					VerTablas.verJugadorXJugador(connection);
					break;
				case 4:
					VerTablas.verLogro(connection);
					break;
				case 5:
					VerTablas.verMapa(connection);
					break;
				case 6:
					VerTablas.verPeriodo(connection);
					break;
				case 7:
					VerTablas.verRaza(connection);
					break;
				case 8:
					VerTablas.verServidor(connection);
					break;
				case 9:
					VerTablas.verJugadorXPeriodoXMapaXServidor(connection);
					break;
				case 10:
					VerTablas.verJugadorXRaza(connection);
					break;
				case 11:
					VerTablas.verJugadorXServidor(connection);
					break;
				case 12:
					VerTablas.verTorneo(connection);
					break;
				case 13:
					VerTablas.verTorneo(connection);
					break;
				case 14:
					VerTablas.verTorneo(connection);
					break;
				}
			}
		} catch (NumberFormatException ex) {
			System.out.println("Introduce un numero por favor...");
		}
	}
	
	
	public static void verJugador(DbConnection connection)
			throws ClassNotFoundException, SQLException {
		JugadorDAO miJugadorDAO = new JugadorDAO();
		JugadorVO miJugador;
		ArrayList<JugadorVO> jugadores = miJugadorDAO.ver(connection);
		if (jugadores.size() > 0) {
			int numero = 0;
			for (int i = 0; i < jugadores.size(); i++) {
				numero++;
				miJugador = jugadores.get(i);
				System.out.println("Id: " + miJugador.getId() + ", Nombre: "
						+ miJugador.getNombre() + ", Apellido: "
						+ miJugador.getApellido() + ", Edad: "
						+ miJugador.getEdad() + ", Pais: "
						+ miJugador.getPais() + ", Mail: "
						+ miJugador.getMail() + ", Battletag: "
						+ miJugador.getBattletag() + ", Password: **********"
						+ ", Liga: " + miJugador.getLiga());
			}
			System.out.println("");
		} else {
			System.out.println("No se pudo consultar.");
		}
	}

	public static void verLiga(DbConnection connection)
			throws ClassNotFoundException, SQLException {
		LigaDAO miLigaDAO = new LigaDAO();
		LigaVO miLiga;
		ArrayList<LigaVO> ligas = miLigaDAO.ver(connection);
		if (ligas.size() > 0) {
			for (int i = 0; i < ligas.size(); i++) {
				miLiga = ligas.get(i);
				System.out.println("Id: " + miLiga.id + ", Liga: "
						+ miLiga.liga + ", icono: " + miLiga.icono);
			}
			System.out.println("");
		} else {
			System.out.println("No se pudo consultar.");
		}
	}

	public static void verJugadorXJugador(DbConnection connection)
			throws ClassNotFoundException, SQLException {
		JugadorXJugadorDAO miJugadorXJugadorDAO = new JugadorXJugadorDAO();
		JugadorXJugadorVO miJugadorXJugador;
		ArrayList<JugadorXJugadorVO> jugadores = miJugadorXJugadorDAO
				.ver(connection);
		if (jugadores.size() > 0) {
			for (int i = 0; i < jugadores.size(); i++) {
				miJugadorXJugador = jugadores.get(i);
				System.out.println("Id: " + miJugadorXJugador.getId()
						+ ", Id2: " + miJugadorXJugador.getId2());
			}
			System.out.println("");
		} else {
			System.out.println("No se pudo consultar.");
		}
	}

	public static void verLogro(DbConnection connection)
			throws ClassNotFoundException, SQLException {
		LogroDAO miLogroDAO = new LogroDAO();
		LogroVO miLogro;
		ArrayList<LogroVO> logros = miLogroDAO.ver(connection);
		if (logros.size() > 0) {
			for (int i = 0; i < logros.size(); i++) {
				miLogro = logros.get(i);
				System.out.println("Id: " + miLogro.getId() + ", Nombre: "
						+ miLogro.getNombre() + ", Descripcion: "
						+ miLogro.getDescripcion());
			}
			System.out.println("");
		} else {
			System.out.println("No se pudo consultar.");
		}
	}

	public static void verMapa(DbConnection connection)
			throws ClassNotFoundException, SQLException {
		MapaDAO miMapaDAO = new MapaDAO();
		MapaVO miMapa;
		ArrayList<MapaVO> mapas = miMapaDAO.ver(connection);
		if (mapas.size() > 0) {
			for (int i = 0; i < mapas.size(); i++) {
				miMapa = mapas.get(i);
				System.out.println("Id: " + miMapa.getId() + ", Nombre: "
						+ miMapa.getNombre() + ", Descripcion: "
						+ miMapa.getDescripcion() + ", Maximo: "
						+ miMapa.getMax());
			}
			System.out.println("");
		} else {
			System.out.println("No se pudo consultar.");
		}
	}

	public static void verPeriodo(DbConnection connection)
			throws ClassNotFoundException, SQLException {
		PeriodoDAO miPeriodoDAO = new PeriodoDAO();
		PeriodoVO miPeriodo;
		ArrayList<PeriodoVO> periodos = miPeriodoDAO.ver(connection);
		if (periodos.size() > 0) {
			for (int i = 0; i < periodos.size(); i++) {
				miPeriodo = periodos.get(i);
				System.out.println("Inicio: " + miPeriodo.getInicio()
						+ ", Fin: " + miPeriodo.getFin());
			}
			System.out.println("");
		} else {
			System.out.println("No se pudo consultar.");
		}
	}

	public static void verRaza(DbConnection connection)
			throws ClassNotFoundException, SQLException {
		RazaDAO miRazaDAO = new RazaDAO();
		RazaVO miRaza;
		ArrayList<RazaVO> razas = miRazaDAO.ver(connection);
		if (razas.size() > 0) {
			for (int i = 0; i < razas.size(); i++) {
				miRaza = razas.get(i);
				System.out.println("Raza: " + miRaza.getRaza());
			}
			System.out.println("");
		} else {
			System.out.println("No se pudo consultar.");
		}
	}

	public static void verServidor(DbConnection connection)
			throws ClassNotFoundException, SQLException {
		ServidorDAO miServidorDAO = new ServidorDAO();
		ServidorVO miServidor;
		ArrayList<ServidorVO> servidors = miServidorDAO.ver(connection);
		if (servidors.size() > 0) {
			for (int i = 0; i < servidors.size(); i++) {
				miServidor = servidors.get(i);
				System.out.println("Id: " + miServidor.getId() + ", Nombre: "
						+ miServidor.getNombre() + ", Pais: "
						+ miServidor.getPais() + ", " + miServidor.getMax());
			}
			System.out.println("");
		} else {
			System.out.println("No se pudo consultar.");
		}
	}

	public static void verTorneo(DbConnection connection)
			throws ClassNotFoundException, SQLException {
		TorneoDAO miTorneoDAO = new TorneoDAO();
		TorneoVO miTorneo;
		ArrayList<TorneoVO> torneos = miTorneoDAO.ver(connection);
		if (torneos.size() > 0) {
			for (int i = 0; i < torneos.size(); i++) {
				miTorneo = torneos.get(i);
				System.out.println("Nombre: " + miTorneo.getNombre()
						+ ", Liga: " + miTorneo.getLiga() + ", Premio: "
						+ miTorneo.getPremio() + ", Inicio: "
						+ miTorneo.getInicio() + ", Fin: " + miTorneo.getFin());
			}
			System.out.println("");
		} else {
			System.out.println("No se pudo consultar.");
		}
	}
	
	public static void verJugadorXPeriodoXMapaXServidor(DbConnection connection)
			throws ClassNotFoundException, SQLException {
		JugadorXPeriodoXMapaXServidorDAO miJugadorXPeriodoXMapaXServidorDAO = new JugadorXPeriodoXMapaXServidorDAO();
		JugadorXPeriodoXMapaXServidorVO miJugadorXPeriodoXMapaXServidor;
		ArrayList<JugadorXPeriodoXMapaXServidorVO> jugadores = miJugadorXPeriodoXMapaXServidorDAO
				.ver(connection);
		if (jugadores.size() > 0) {
			for (int i = 0; i < jugadores.size(); i++) {
				miJugadorXPeriodoXMapaXServidor = jugadores.get(i);
				System.out.println("IdJugador: " + miJugadorXPeriodoXMapaXServidor.getIdJugador()
						+ ", IdMapa: " + miJugadorXPeriodoXMapaXServidor.getIdMapa()
						+ ", IdServidor: " +  miJugadorXPeriodoXMapaXServidor.getIdServidor()
						+ ", Inicio: " + miJugadorXPeriodoXMapaXServidor.getInicio()
						+ ", Fin:" + miJugadorXPeriodoXMapaXServidor.getFin()
						+ ", Ganador:" + miJugadorXPeriodoXMapaXServidor.getGanador()
						);
			}
			System.out.println("");
		} else {
			System.out.println("No se pudo consultar.");
		}
		
		
	}
	
	public static void verJugadorXServidor(DbConnection connection)
			throws ClassNotFoundException, SQLException {
		JugadorXServidorDAO miJugadorXServidorDAO = new JugadorXServidorDAO();
		JugadorXServidorVO miJugadorXServidor;
		ArrayList<JugadorXServidorVO> jugadores = miJugadorXServidorDAO
				.ver(connection);
		if (jugadores.size() > 0) {
			for (int i = 0; i < jugadores.size(); i++) {
				miJugadorXServidor = jugadores.get(i);
				System.out.println("IdJugador: " + miJugadorXServidor.getIdJugador()
						+ ", IdServidor: " + miJugadorXServidor.getIdServidor()
						+ ", Inicio: " + miJugadorXServidor.getInicio()
						+ ", Fin:" + miJugadorXServidor.getFin()
						);
			}
			System.out.println("");
		} else {
			System.out.println("No se pudo consultar.");
		}
		
		
	}
	
	public static void verJugadorXRaza(DbConnection connection)
			throws ClassNotFoundException, SQLException {
		JugadorXRazaDAO miJugadorXRazaDAO = new JugadorXRazaDAO();
		JugadorXRazaVO miJugadorXRaza;
		ArrayList<JugadorXRazaVO> jugadores = miJugadorXRazaDAO
				.ver(connection);
		if (jugadores.size() > 0) {
			for (int i = 0; i < jugadores.size(); i++) {
				Raza miRaza = miJugadorXRaza.getRaza();
				String nombre = valueof(miRaza);
				miJugadorXRaza = jugadores.get(i);
				System.out.println("Id: " + miJugadorXRaza.getId()
						+ ", Nombre: " + nombre
						+ ", Ganadas: " + miJugadorXRaza.getGanadas()
						+ ", Perdidas:" + miJugadorXRaza.getPerdidas()
						);
			}
			System.out.println("");
		} else {
			System.out.println("No se pudo consultar.");
		}
		
		
	}
	
	public static void verJugadorXTorneo(DbConnection connection)
			throws ClassNotFoundException, SQLException {
		JugadorXTorneoDAO miJugadorXTorneoDAO = new JugadorXTorneoDAO();
		JugadorXTorneoVO miJugadorXTorneo;
		ArrayList<JugadorXTorneoVO> jugadores = miJugadorXTorneoDAO
				.ver(connection);
		if (jugadores.size() > 0) {
			for (int i = 0; i < jugadores.size(); i++) {
				miJugadorXTorneo = jugadores.get(i);
				System.out.println("Id: " + miJugadorXTorneo.getId()
						+ ", Nombre:: " + miJugadorXTorneo.getNombre()
						);
			}
			System.out.println("");
		} else {
			System.out.println("No se pudo consultar.");
		}
		
		
	}

}
