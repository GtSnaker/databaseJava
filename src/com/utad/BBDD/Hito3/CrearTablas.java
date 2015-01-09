package com.utad.BBDD.Hito3;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

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
		System.out.println("Introduce la edad");
		Date miDate = new Date(1991, 1, 4);
		miJugadorVO.setEdad(miDate);
		System.out.println("Introduce el pais");
		miJugadorVO.setPais(sc.nextLine());
		System.out.println("Introduce el mail");
		miJugadorVO.setMail(sc.nextLine());
		System.out.println("Introduce el battletag");
		miJugadorVO.setBattletag(sc.nextLine());
		System.out.println("Introduce el password");
		miJugadorVO.setPassword(sc.nextLine());
		System.out.println("Introduce la liga");
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
		miPeriodoVO.setInicio(dato);
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
		dato = new Timestamp(anio, mes, dia, hora, minuto, segundo, nano);
		miPeriodoVO.setFin(dato);
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
		System.out.println("Introduce el nombre");
		miTorneoVO.setNombre(sc.nextLine());
		System.out.println("Introduce el numero de la liga (1-7)");
		int numero = Integer.parseInt(sc.nextLine());
		miTorneoVO.setLiga(numero);
		System.out.println("Introduce el premio");
		miTorneoVO.setPremio(sc.nextLine());
		System.out.println("Introduce el anio de inicio");
		numero = Integer.parseInt(sc.nextLine());
		System.out.println("Introduce el mes de inicio");
		int numero2 = Integer.parseInt(sc.nextLine());
		System.out.println("Introduce el dia de inicio");
		int numero3 = Integer.parseInt(sc.nextLine());
		Date inicio = new Date(numero, numero2, numero3);
		System.out.println("Introduce el anio de fin");
		numero = Integer.parseInt(sc.nextLine());
		System.out.println("Introduce el mes de fin");
		numero2 = Integer.parseInt(sc.nextLine());
		System.out.println("Introduce el dia de fin");
		numero3 = Integer.parseInt(sc.nextLine());
		Date fin = new Date(numero, numero2, numero3);
		miTorneoVO.setInicio(inicio);
		miTorneoVO.setFin(fin);
		miTorneoDAO.registrar(miTorneoVO, connection);
	}
}
