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
	
	public static void elegir(DbConnection connection) throws ClassNotFoundException, SQLException{
		System.out.println("1 para ver las tablas de JUGADOR");
		System.out.println("2 para ver las tablas de LIGA");
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
					VerTablas.verJugador(connection);
					break;
				case 2:
					VerTablas.verLiga(connection);
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
	
	public static void verJugador(DbConnection connection) throws ClassNotFoundException, SQLException {
		JugadorDAO miJugadorDAO = new JugadorDAO();
		JugadorVO miJugador;
		ArrayList<JugadorVO> jugadores = miJugadorDAO.ver(connection);
		if (jugadores.size() > 0) {
			int numero = 0;
			for (int i = 0; i < jugadores.size(); i++) {
				numero++;
				miJugador = jugadores.get(i);
				System.out.println("Id: " + miJugador.getId() + ", Nombre: " + miJugador.getNombre() + ", Apellido: " + miJugador.getApellido() + ", Edad: "+ miJugador.getEdad() + ", Pais: "+ miJugador.getPais() + ", Mail: "+ miJugador.getMail() + ", Battletag: "+ miJugador.getBattletag() + ", Password: **********" + ", Liga: "+ miJugador.getLiga());
			}
			System.out.println("");
		} else {
			System.out.println("No se pudo consultar.");
		}
	}
	
	public static void verLiga(DbConnection connection) throws ClassNotFoundException, SQLException {
		LigaDAO miLigaDAO = new LigaDAO();
		LigaVO miLiga;
		ArrayList<LigaVO> ligas = miLigaDAO.ver(connection);
		if (ligas.size() > 0) {
			for (int i = 0; i < ligas.size(); i++) {
				miLiga = ligas.get(i);
				System.out.println("Id: "+ miLiga.id + ", Liga: " + miLiga.liga+", icono: "+miLiga.icono);
			}
			System.out.println("");
		} else {
			System.out.println("No se pudo consultar.");
		}
	}
	
	
}
