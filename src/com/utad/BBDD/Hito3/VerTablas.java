package com.utad.BBDD.Hito3;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
/**
 * clase que llama a todos los metodos ver de cada una de las clases DAO
 * 
 * @see *DAO
 */

public class VerTablas {
	
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
	
	
}
