package com.utad.BBDD.Hito3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class Procedimientos {

	public static void elegir(DbConnection connection) {
		System.out
				.println("Introduce 1 para ejecutar el procedimiento JugadoresXServidor: ");
		System.out
				.println("Introduce 2 para ejecutar el procedimiento JugadorXRaza: ");
		Scanner sc = new Scanner(System.in);
		String numero = sc.nextLine();
		int opcion;
		try {
			opcion = Integer.parseInt(numero);
			if (opcion < 1 || opcion > 2) {
				System.out.println("Solo son validos numeros del 1 al 2");
			} else {
				switch (opcion) {
				case 1:
					Procedimientos.JugadoresPorServidor(connection);
					break;
				case 2:
					Procedimientos.JugadorPorRaza(connection);
					break;
				}
			}
		} catch (NumberFormatException ex) {
			System.out.println("Introduce un numero por favor...");
		}
	}

	/**
	 * llama al procedimiento JugadoresPorServidor y muestra el resultado de la
	 * tabla que se modifica (JugadoresXServidor)
	 *
	 * @param DbConnection
	 *            connection
	 * @return void
	 */
	public static void JugadoresPorServidor(DbConnection connection) {
		// SET @p0='1'; CALL `JugadoresPorServidor`(@p0);
		try {
			Statement statement = connection.getConnection().createStatement();
			Scanner sc = new Scanner(System.in);
			System.out.println("Introduce el id del servidor: ");
			int idServidor = sc.nextInt();
			statement.executeQuery("CALL `JugadoresPorServidor`(" + idServidor
					+ ")");

			ResultSet res = statement
					.executeQuery("SELECT * FROM jugadoresxservidor");
			ArrayList<JugadoresXServidorPROC> jugadores = new ArrayList<JugadoresXServidorPROC>();
			while (res.next()) {
				jugadores.add(new JugadoresXServidorPROC(res
						.getInt("idServidor"), res.getString("nombreServidor"),
						res.getString("paisServidor"), res.getInt("idJugador"),
						res.getString("battletag")));
			}

			JugadoresXServidorPROC miJugadoresXServidorPROC = new JugadoresXServidorPROC();

			if (jugadores.size() > 0) {
				for (int i = 0; i < jugadores.size(); i++) {
					miJugadoresXServidorPROC = jugadores.get(i);
					System.out.println("IdServidor: "
							+ miJugadoresXServidorPROC.getIdServidor()
							+ ", NombreServidor: "
							+ miJugadoresXServidorPROC.getNombreServidor()
							+ ", PaisServidor: "
							+ miJugadoresXServidorPROC.getPaisServidor()
							+ ", IdJugador: "
							+ miJugadoresXServidorPROC.getIdJugador()
							+ ", Battletag: "
							+ miJugadoresXServidorPROC.getBattletag());
				}

				System.out.println("");
			} else {
				System.out.println("No se pudo consultar.");
				statement.close();
				// connection.close();
			}
		} catch (SQLException e) {
			System.out.println("Error" + e);
		}
	}

	/**
	 * llama al procedimiento JugadorPorRaza y muestra el resultado de la tabla
	 * que se modifica (JugadorXRazaPROC)
	 *
	 * @param DbConnection
	 *            connection
	 * @return void
	 */
	public static void JugadorPorRaza(DbConnection connection) {
		try {
			Statement statement = connection.getConnection().createStatement();
			Scanner sc = new Scanner(System.in);
			System.out
					.println("Introduce el nombre de la raza (terran, zerg, protoss): ");
			String nombreRaza = sc.nextLine();
			statement.executeQuery("CALL `JugadorPorRaza`('" + nombreRaza
					+ "')");
			ResultSet res = statement
					.executeQuery("SELECT * FROM jugadorxrazaproc");
			ArrayList<JugadorXRazaPROC> jugadores = new ArrayList<JugadorXRazaPROC>();
			
			while (res.next()) {
				String nombreLiga = res.getString("nombreRaza");
				Raza miRaza = Raza.valueOf(nombreLiga);
				jugadores.add(new JugadorXRazaPROC(miRaza, res.getString("nombreJugador"),
						res.getInt("victorias"), res.getInt("derrotas")));
			}

			JugadorXRazaPROC miJugadorXRazaPROC = new JugadorXRazaPROC();

			if (jugadores.size() > 0) {
				for (int i = 0; i < jugadores.size(); i++) {
					miJugadorXRazaPROC = jugadores.get(i);
					System.out.println("NombreRaza: "
							+ miJugadorXRazaPROC.getNombreRaza()
							+ ", NombreJugador: "
							+ miJugadorXRazaPROC.getNombreJugador()
							+ ", Victorias: "
							+ miJugadorXRazaPROC.getVictorias()
							+ ", Derrotas: "
							+ miJugadorXRazaPROC.getDerrotas());
				}

				System.out.println("");
			} else {
				System.out.println("No se pudo consultar.");
				statement.close();
				// connection.close();
			}
		} catch (SQLException e) {
			System.out.println("Error" + e);
		}
	}
}
