package com.utad.BBDD.Hito3;

import java.sql.Date;
import java.sql.SQLException;
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
		miLigaVO.setLiga(Liga.diamante);
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
}
