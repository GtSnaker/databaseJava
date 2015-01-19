package _Tablas;

import java.sql.Date;
import java.sql.SQLException;
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
import ENUMs.Liga;
import ENUMs.Raza;
import VOs.JugadorVO;
import VOs.JugadorXJugadorVO;
import VOs.JugadorXLogroVO;
import VOs.JugadorXPeriodoXMapaXServidorVO;
import VOs.JugadorXRazaVO;
import VOs.JugadorXServidorVO;
import VOs.JugadorXTorneoVO;
import VOs.LigaVO;
import VOs.LogroVO;
import VOs.MapaVO;
import VOs.PeriodoVO;
import VOs.RazaVO;
import VOs.ServidorVO;
import VOs.TorneoVO;

/**
 * clase que llama a todos los metodos crear/registrar/añadir de cada una de las clases DAO
 * 
 * @see *DAO
 */
public class CrearTablas {
	
	public static void elegir(DbConnection connection) throws ClassNotFoundException, SQLException{
		System.out.println("1 para crear JUGADOR");
		System.out.println("2 para crear LIGA");
		System.out.println("3 para crear JUGADORXJUGADOR");
		System.out.println("4 para crear LOGRO");
		System.out.println("5 para crear MAPA");
		System.out.println("6 para crear PERIODO");
		System.out.println("7 para crear RAZA");
		System.out.println("8 para crear SERVIDOR");
		System.out.println("9 para crear TORNEO");
		System.out.println("10 para crear JUGADORXPERIODOXMAPAXSERVIDOR");
		System.out.println("11 para crear JUGADORXRAZA");
		System.out.println("12 para crear JUGADORXSERVIDOR");
		System.out.println("13 para crear JUGADORXTORNEO");
		System.out.println("14 para crear JUGADORXLOGRO");
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
					CrearTablas.crearJugador(connection);
					break;
				case 2:
					CrearTablas.crearLiga(connection);
					break;
				case 3:	
					CrearTablas.crearJugadorXJugador(connection);
					break;
				case 4:
					CrearTablas.crearLogro(connection);
					break;
				case 5:
					CrearTablas.crearMapa(connection);
					break;
				case 6:
					CrearTablas.crearPeriodo(connection);
					break;
				case 7:
					CrearTablas.crearRaza(connection);
					break;
				case 8:
					CrearTablas.crearServidor(connection);
					break;
				case 9:
					CrearTablas.crearTorneo(connection);
					break;
				case 10:
					CrearTablas.crearJugadorXPeriodoXMapaXServidor(connection);
					break;
				case 11:
					CrearTablas.crearJugadorXRaza(connection);
					break;
				case 12:
					CrearTablas.crearJugadorXServidor(connection);
					break;
				case 13:
					CrearTablas.crearJugadorXTorneo(connection);
					break;
				case 14:
					CrearTablas.crearJugadorXLogro(connection);
					break;
				}
			}
		} catch (NumberFormatException ex) {
			System.out.println("Introduce un numero por favor...");
		}
	}
	
	public static void crearJugador(DbConnection connection) throws ClassNotFoundException, SQLException {
		JugadorDAO miJugadorDAO = new JugadorDAO();
		JugadorVO miJugadorVO = new JugadorVO();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el id");
		miJugadorVO.setId(Integer.parseInt(sc.nextLine()));
		System.out.println("Introduce el nombre");
		miJugadorVO.setNombre(sc.nextLine());
		System.out.println("Introduce el apellido");
		miJugadorVO.setApellido(sc.nextLine());
		System.out.println("Introduce la edad: YYYY-MM-DD");
		miJugadorVO.setEdad(sc.nextLine());
		System.out.println("Introduce el pais");
		miJugadorVO.setPais(sc.nextLine());
		System.out.println("Introduce el mail");
		miJugadorVO.setMail(sc.nextLine());
		System.out.println("Introduce el battletag");
		miJugadorVO.setBattletag(sc.nextLine());
		System.out.println("Introduce el password");
		miJugadorVO.setPassword(sc.nextLine());
		System.out.println("Introduce la liga (id)");
		miJugadorVO.setLiga(Integer.parseInt(sc.nextLine()));
		miJugadorDAO.registrar(miJugadorVO, connection);
	}
	
	public static void crearLiga(DbConnection connection) throws ClassNotFoundException, SQLException {
		LigaDAO miLigaDAO = new LigaDAO();
		LigaVO miLigaVO = new LigaVO();
		Scanner sc = new Scanner(System.in);	
		System.out.println("Introduce el id");
		miLigaVO.setId(Integer.parseInt(sc.nextLine()));
		System.out.println("Introduce la liga");
		miLigaVO.setLiga(Liga.valueOf(sc.nextLine()));
		System.out.println("Introduce el nombre");
		miLigaVO.setIcono(sc.nextLine());
		miLigaDAO.registrar(miLigaVO, connection);
	}
	
	public static void crearJugadorXJugador(DbConnection connection) throws ClassNotFoundException, SQLException {
		JugadorXJugadorDAO miJugadorXJugadorDAO = new JugadorXJugadorDAO();
		JugadorXJugadorVO miJugadorXJugadorVO = new JugadorXJugadorVO();
		Scanner sc = new Scanner(System.in);	
		System.out.println("Introduce el id");
		miJugadorXJugadorVO.setId(sc.nextInt());
		System.out.println("Introduce el id2");
		miJugadorXJugadorVO.setId2(sc.nextInt());
		miJugadorXJugadorDAO.registrar(miJugadorXJugadorVO, connection);
	}
	
	public static void crearLogro(DbConnection connection) throws ClassNotFoundException, SQLException {
		LogroDAO miLogroDAO = new LogroDAO();
		LogroVO miLogroVO = new LogroVO();
		Scanner sc = new Scanner(System.in);	
		System.out.println("Introduce el id");
		miLogroVO.setId(Integer.parseInt(sc.nextLine()));
		System.out.println("Introduce el nombre");
		miLogroVO.setNombre(sc.nextLine());
		System.out.println("Introduce la descripcion");
		miLogroVO.setDescripcion(sc.nextLine());
		miLogroDAO.registrar(miLogroVO, connection);
	}
	
	public static void crearMapa(DbConnection connection) throws ClassNotFoundException, SQLException {
		MapaDAO miMapaDAO = new MapaDAO();
		MapaVO miMapaVO = new MapaVO();
		Scanner sc = new Scanner(System.in);	
		System.out.println("Introduce el id");
		miMapaVO.setId(Integer.parseInt(sc.nextLine()));
		System.out.println("Introduce el nombre");
		miMapaVO.setNombre(sc.nextLine());
		System.out.println("Introduce la descripcion");
		miMapaVO.setDescripcion(sc.nextLine());
		System.out.println("Introduce el numero maximo de jugadores");
		miMapaVO.setMax(Integer.parseInt(sc.nextLine()));
		miMapaDAO.registrar(miMapaVO, connection);
	}
	
	public static void crearPeriodo(DbConnection connection) throws ClassNotFoundException, SQLException {
		PeriodoDAO miPeriodoDAO = new PeriodoDAO();
		PeriodoVO miPeriodoVO = new PeriodoVO();
		Scanner sc = new Scanner(System.in);	
		System.out.println("Introduce la fecha de inicio: YY-MM-DD HH24:MM:SS");
		miPeriodoVO.setInicio(sc.nextLine());
		System.out.println("Introduce la fecha de fin: YY-MM-DD HH24:MM:SS");
		miPeriodoVO.setFin(sc.nextLine());
		miPeriodoDAO.registrar(miPeriodoVO, connection);
	}
	
	public static void crearRaza(DbConnection connection) throws ClassNotFoundException, SQLException {
		RazaDAO miRazaDAO = new RazaDAO();
		RazaVO miRazaVO = new RazaVO();
		Scanner sc = new Scanner(System.in);	
		System.out.println("Introduce la raza");
		miRazaVO.setRaza(Raza.valueOf(sc.nextLine()));
		miRazaDAO.registrar(miRazaVO, connection);
	}
	
	public static void crearServidor(DbConnection connection) throws ClassNotFoundException, SQLException {
		ServidorDAO miServidorDAO = new ServidorDAO();
		ServidorVO miServidorVO = new ServidorVO();
		Scanner sc = new Scanner(System.in);	
		System.out.println("Introduce el id");
		int numero = Integer.parseInt(sc.nextLine());
		miServidorVO.setId(numero);
		miServidorVO.getId();
		System.out.println("Introduce el nombre");
		miServidorVO.setNombre(sc.nextLine());
		System.out.println("Introduce el pais (EJ)");
		miServidorVO.setPais(sc.nextLine());
		System.out.println("Introduce el numero maximo de jugadores");
		numero = Integer.parseInt(sc.nextLine());
		miServidorVO.setMax(numero);
		miServidorDAO.registrar(miServidorVO, connection);
	}
	
	public static void crearTorneo(DbConnection connection) throws ClassNotFoundException, SQLException {
		TorneoDAO miTorneoDAO = new TorneoDAO();
		TorneoVO miTorneoVO = new TorneoVO();
		Scanner sc = new Scanner(System.in);	
		System.out.println("Introduce la fecha de inicio: YY-MM-DD HH24:MM:SS");
		miTorneoVO.setInicio(sc.nextLine());
		System.out.println("Introduce la fecha de fin: YY-MM-DD HH24:MM:SS");
		miTorneoVO.setFin(sc.nextLine());
		miTorneoDAO.registrar(miTorneoVO, connection);
	}
	
	public static void crearJugadorXPeriodoXMapaXServidor(DbConnection connection) throws ClassNotFoundException, SQLException {
		JugadorXPeriodoXMapaXServidorDAO miJugadorXPeriodoXMapaXServidorDAO = new JugadorXPeriodoXMapaXServidorDAO();
		JugadorXPeriodoXMapaXServidorVO miJugadorXPeriodoXMapaXServidorVO = new JugadorXPeriodoXMapaXServidorVO();
		Scanner sc = new Scanner(System.in);	
		System.out.println("Introduce el idJugador");
		miJugadorXPeriodoXMapaXServidorVO.setIdJugador(sc.nextInt());
		System.out.println("Introduce el idMapa");
		miJugadorXPeriodoXMapaXServidorVO.setIdMapa(sc.nextInt());
		System.out.println("Introduce la fecha de inicio: YY-MM-DD HH24:MM:SS");
		miJugadorXPeriodoXMapaXServidorVO.setInicio(sc.nextLine());
		System.out.println("Introduce la fecha de fin: YY-MM-DD HH24:MM:SS");
		miJugadorXPeriodoXMapaXServidorVO.setFin(sc.nextLine());
		miJugadorXPeriodoXMapaXServidorDAO.registrar(miJugadorXPeriodoXMapaXServidorVO, connection);
	}
	
	public static void crearJugadorXRaza(DbConnection connection) throws ClassNotFoundException, SQLException {
		JugadorXRazaDAO miJugadorXRazaDAO = new JugadorXRazaDAO();
		JugadorXRazaVO miJugadorXRazaVO = new JugadorXRazaVO();
		Scanner sc = new Scanner(System.in);	
		System.out.println("Introduce el idJugador");
		miJugadorXRazaVO.setId(sc.nextInt());
		System.out.println("Introduce el nombre");
		String nombre = sc.nextLine();
		Raza miRaza = Raza.valueOf(nombre);
		miJugadorXRazaVO.setRaza(miRaza);
		System.out.println("Introduce el numero de ganadas");
		miJugadorXRazaVO.setGanadas(sc.nextInt());
		System.out.println("Introduce el numero de sc.perdidas");
		miJugadorXRazaVO.setPerdidas(sc.nextInt());
		miJugadorXRazaDAO.registrar(miJugadorXRazaVO, connection);
	}
	
	public static void crearJugadorXServidor(DbConnection connection) throws ClassNotFoundException, SQLException {
		JugadorXServidorDAO miJugadorXServidorDAO = new JugadorXServidorDAO();
		JugadorXServidorVO miJugadorXServidorVO = new JugadorXServidorVO();
		Scanner sc = new Scanner(System.in);	
		System.out.println("Introduce el idJugador");
		miJugadorXServidorVO.setIdJugador(sc.nextInt());
		System.out.println("Introduce el idServidor");
		miJugadorXServidorVO.setIdServidor(sc.nextInt());
		System.out.println("Introduce la fecha de inicio: YY-MM-DD HH24:MM:SS");
		miJugadorXServidorVO.setInicio(sc.nextLine());
		System.out.println("Introduce la fecha de fin: YY-MM-DD HH24:MM:SS");
		miJugadorXServidorVO.setFin(sc.nextLine());
		miJugadorXServidorDAO.registrar(miJugadorXServidorVO, connection);
	}
	
	public static void crearJugadorXTorneo(DbConnection connection) throws ClassNotFoundException, SQLException {
		JugadorXTorneoDAO miJugadorXTorneoDAO = new JugadorXTorneoDAO();
		JugadorXTorneoVO miJugadorXTorneoVO = new JugadorXTorneoVO();
		Scanner sc = new Scanner(System.in);	
		System.out.println("Introduce el id");
		miJugadorXTorneoVO.setId(sc.nextInt());
		System.out.println("Introduce el nombre");
		miJugadorXTorneoVO.setNombre(sc.nextLine());
		miJugadorXTorneoDAO.registrar(miJugadorXTorneoVO, connection);
	}
	
	public static void crearJugadorXLogro(DbConnection connection) throws ClassNotFoundException, SQLException {
		JugadorXLogroDAO miJugadorXLogroDAO = new JugadorXLogroDAO();
		JugadorXLogroVO miJugadorXLogroVO = new JugadorXLogroVO();
		Scanner sc = new Scanner(System.in);	
		System.out.println("Introduce el idJugador");
		miJugadorXLogroVO.setIdJugador(sc.nextInt());
		System.out.println("Introduce el idLogro");
		miJugadorXLogroVO.setIdLogro(sc.nextInt());
		miJugadorXLogroDAO.registrar(miJugadorXLogroVO, connection);
	}
}
