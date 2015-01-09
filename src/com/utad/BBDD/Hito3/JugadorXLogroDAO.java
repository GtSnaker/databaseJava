package com.utad.BBDD.Hito3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class JugadorXLogroDAO {

	/**
	 * permite insertar una tupla en la tabla jugadorxlogro
	 * 
	 * @param JugadorVO
	 *            fila
	 * @param DbConnection
	 *            connection
	 * @return void
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void registrar(JugadorXLogroVO fila, DbConnection connection)
			throws SQLException, ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("INSERT INTO jugadorxlogro VALUES ('"
					+ fila.getIdJugador() + "', '" + fila.getIdLogro() + "')");
			JOptionPane.showMessageDialog(null,
					"Se ha registrado Exitosamente", "Información",
					JOptionPane.INFORMATION_MESSAGE);
			statement.close();
			// connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null,
					"No se pudo registrar al jugador");
		}
	}

	/**
	 * permite consultar todas las tuplas de la tabla jugadorxlogro
	 * 
	 * @param DbConnection
	 *            connection
	 * @return ArrayList<JugadorVO>
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<JugadorXLogroVO> ver(DbConnection connection)
			throws SQLException, ClassNotFoundException {
		ArrayList<JugadorXLogroVO> jugadores = new ArrayList<JugadorXLogroVO>();
		try {
			Statement statement = connection.getConnection().createStatement();
			ResultSet res = statement
					.executeQuery("SELECT * FROM jugadorxlogro");

			while (res.next()) {
				jugadores.add(new JugadorXLogroVO(res.getInt("idJugador"), res
						.getInt("intLogro")));
			}
			res.close();
			statement.close();
			// connection.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"no se pudo consultar la Persona\n" + e);
		}
		return jugadores;
	}
	
	/**
	 * permite borrar una tupla en la tabla jugadorxlogro
	 * 
	 * @param DbConnection
	 *            connection
	 * @param int id
	 * @return void
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void borrar(DbConnection connection, int idJugador, int idLogro) throws SQLException,
			ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("DELETE FROM jugadorxlogro WHERE idJugador = " + idJugador + " idLogro = " + idLogro);
			statement.close();
			// connection.close();
		} catch (SQLException e) {
			System.out.println("Error" + e);
		}
	}
	
	/**
	 * permite modificar una tupla en la tabla jugadorxlogro
	 * 
	 * @param DbConnection
	 *            connection
	 * @param int id
	 * @return void
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void modificar(DbConnection connection, int idJugador, int idLogro) throws SQLException,
			ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			ResultSet res = statement
					.executeQuery("SELECT * FROM jugadorxlogro WHERE idJugador = " + idJugador + " idLogro = " + idLogro);
			
			while (res.next()) {
				System.out.println("IdJugador: " + res.getInt("idJugador") + ", IdLogro: "
						+ res.getInt("idLogro"));
			}
			System.out
					.println("Introduce el nombre de el campo que quieres cambiar: ");
			System.out
					.println("idJugador, idLogro");
			Scanner sc = new Scanner(System.in);
			String columna = sc.nextLine();
			if (columna.equals("idJugador") || columna.equals("idLogro")) {
				System.out
						.println("Introdce el entero por el que quieres modificarlo: ");
				int valor = sc.nextInt();
				statement.executeUpdate("UPDATE jugadorxlogro SET " + columna
						+ " = " + valor + " WHERE idJugador = " + idJugador + " idLogro = " + idLogro);
			} else {
				System.out.println("Introduce uno de los valores aceptados.");
			}
			System.out.println("Jugadorxlogro modificado.");
			statement.close();
			// connection.close();
		} catch (SQLException e) {
			System.out.println("Error" + e);
		}
	}

}
