package com.utad.BBDD.Hito3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import ENUMs.Raza;
import VOs.JugadorVO;
import VOs.JugadorXRazaVO;
import VOs.JugadorXServidorVO;
import _Tablas.BorrarTablas;
import _Tablas.CrearTablas;
import _Tablas.ModificarTablas;
import _Tablas.VerTablas;

public class ConsultasRapidas {
	public static void elegir(DbConnection connection)
			throws ClassNotFoundException, SQLException {
		System.out.println("Introduce 1 para mostrar JugadoresPorServidor");
		System.out.println("Introduce 2 para mostrar VictoriasDerrotasJugador");
		System.out.println("Introduce 3 para mostrar JugadoresPorLogro");
		Scanner sc = new Scanner(System.in);
		String numeroEntero = sc.nextLine();
		int opcion;
		try {
			opcion = Integer.parseInt(numeroEntero);
			if (opcion < 1 || opcion > 3) {
				System.out.println("Solo son validos numeros del 1 al 3");
			} else {
				switch (opcion) {
				case 1:
					ConsultasRapidas.JugadoresPorServidor(connection);
					break;
				case 2:
					ConsultasRapidas.VictoriasDerrotasJugador(connection);
					break;
				case 3:
					ConsultasRapidas.JugadoresPorLogro(connection);
					break;
				}
			}
		} catch (NumberFormatException ex) {
			System.out.println("Introduce un numero por favor...");
		}
	}

	public static void JugadoresPorLogro(DbConnection connection) throws ClassNotFoundException, SQLException{
		System.out.println("Elige el id de un logro disponible:");
		VerTablas.verLogro(connection);
		System.out.println("Introduce el id del logro:");
		Scanner sc = new Scanner(System.in);
		String numeroEntero = sc.nextLine();
		int numero = 0;
		try {
			numero = Integer.parseInt(numeroEntero);
		} catch (NumberFormatException ex) {
			System.out.println("Introduce un numero por favor...");
		}
		ArrayList<JugadorVO> jugadores = new ArrayList<JugadorVO>();
		try {
			Statement statement = connection.getConnection().createStatement();
			ResultSet res = statement
					.executeQuery("select * from jugadorxlogro join jugador where id = idjugador AND idlogro = "
							+ numero);

			while (res.next()) {
				jugadores.add(new JugadorVO(res.getInt("id"), res
						.getString("nombre"), res.getString("apellido"), res
						.getString("edad"), res.getString("pais"), res
						.getString("mail"), res.getString("battletag"), res
						.getString("password"), res.getInt("liga")));
			}
			res.close();
			statement.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"no se pudo consultar la tabla\n" + e);
		}
		if (jugadores.size() > 0) {
			JugadorVO miJugador = new JugadorVO();
			for (int i = 0; i < jugadores.size(); i++) {
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
	
	public static void VictoriasDerrotasJugador(DbConnection connection)
			throws ClassNotFoundException, SQLException {
		System.out.println("Elige el id de un jugador disponible:");
		VerTablas.verJugador(connection);
		System.out.println("Introduce el id del jugador:");
		Scanner sc = new Scanner(System.in);
		String numeroEntero = sc.nextLine();
		int numero = 0;
		try {
			numero = Integer.parseInt(numeroEntero);
		} catch (NumberFormatException ex) {
			System.out.println("Introduce un numero por favor...");
		}

		ArrayList<JugadorXRazaVO> jugadores = new ArrayList<JugadorXRazaVO>();
		try {
			Statement statement = connection.getConnection().createStatement();
			ResultSet res = statement
					.executeQuery("select * from jugadorxraza where id = "
							+ numero);

			while (res.next()) {
				String nombreRaza = res.getString("nombre");
				Raza miRaza = Raza.valueOf(nombreRaza);
				jugadores.add(new JugadorXRazaVO(res.getInt("id"), miRaza, res
						.getInt("ganadas"), res.getInt("perdidas")));
			}
			res.close();
			statement.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"no se pudo consultar la tabla\n" + e);
		}
		JugadorXRazaVO miJugadorXRaza = new JugadorXRazaVO();
		if (jugadores.size() > 0) {
			for (int i = 0; i < jugadores.size(); i++) {
				miJugadorXRaza = jugadores.get(i);
				System.out.println("Id: " + miJugadorXRaza.getId()
						+ ", Nombre: " + miJugadorXRaza.getRaza()
						+ ", Ganadas: " + miJugadorXRaza.getGanadas()
						+ ", Perdidas:" + miJugadorXRaza.getPerdidas());
			}
			System.out.println("");
		} else {
			System.out.println("No se pudo consultar.");
		}
	}

	public static void JugadoresPorServidor(DbConnection connection)
			throws ClassNotFoundException, SQLException {
		System.out.println("Elige un servidor de los disponibles:");
		VerTablas.verServidor(connection);
		System.out.println("Introduce el id del servidor:");
		Scanner sc = new Scanner(System.in);
		String numeroEntero = sc.nextLine();
		int numero = 0;
		try {
			numero = Integer.parseInt(numeroEntero);
		} catch (NumberFormatException ex) {
			System.out.println("Introduce un numero por favor...");
		}

		ArrayList<JugadorVO> jugadores = new ArrayList<JugadorVO>();
		try {
			Statement statement = connection.getConnection().createStatement();
			ResultSet res = statement
					.executeQuery("select * from jugadorxservidor join jugador where id = idjugador AND idservidor = "
							+ numero);

			while (res.next()) {
				jugadores.add(new JugadorVO(res.getInt("id"), res
						.getString("nombre"), res.getString("apellido"), res
						.getString("edad"), res.getString("pais"), res
						.getString("mail"), res.getString("battletag"), res
						.getString("password"), res.getInt("liga")));
			}
			res.close();
			statement.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"no se pudo consultar la tabla\n" + e);
		}
		if (jugadores.size() > 0) {
			JugadorVO miJugador = new JugadorVO();
			for (int i = 0; i < jugadores.size(); i++) {
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

}
