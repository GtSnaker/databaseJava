package com.utad.BBDD.Hito3;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * clase cuyos metodos añaden, borran, ven y modifican tuplas de la tabla
 * jugadorxraza
 * 
 * @see JugadorXRazaVO
 * 
 */

public class JugadorXRazaDAO {

	/**
	 * permite insertar una tupla en la tabla jugadorxraza
	 * 
	 * @param JugadorXRazaVO
	 *            fila
	 * @param DbConnection
	 *            connection
	 * @return void
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void registrar(JugadorXRazaVO fila, DbConnection connection)
			throws SQLException, ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("INSERT INTO jugadorxraza VALUES ('"
					+ fila.getId() + "', '" + fila.getRaza() + "','"
					+ fila.getGanadas() + "','" + fila.getPerdidas() + ")");
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
	 * permite consultar todas las tuplas de la tabla jugadorxperiodoxraza
	 * 
	 * @param DbConnection
	 *            connection
	 * @return ArrayList<JugadorXRaza
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<JugadorXRazaVO> ver(DbConnection connection)
			throws SQLException, ClassNotFoundException {
		ArrayList<JugadorXRazaVO> jugadores = new ArrayList<JugadorXRazaVO>();
		try {
			Statement statement = connection.getConnection().createStatement();
			ResultSet res = statement
					.executeQuery("SELECT * FROM jugadorxraza");

			while (res.next()) {
				String nombreRaza = res.getString("nombre");
				Raza miRaza = Raza.valueOf(nombreRaza);
				jugadores.add(new JugadorXRazaVO(res.getInt("id"), miRaza, res
						.getInt("ganadas"), res.getInt("perdidas")));
			}
			res.close();
			statement.close();
			// connection.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"no se pudo consultar la tabla\n" + e);
		}
		return jugadores;
	}

	/**
	 * permite borrar una tupla en la tabla jugadorxraza
	 * 
	 * @param DbConnection
	 *            connection
	 * @param int id
	 * @param int nombre
	 * @paran int ganadas
	 * @param int perdidas
	 * @return void
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void borrar(DbConnection connection, int id, Raza nombre) throws SQLException,
			ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("DELETE FROM jugadorxraza WHERE id = " + id
					+ "AND nombre = " + nombre);
			statement.close();
			// connection.close();
		} catch (SQLException e) {
			System.out.println("Error" + e);
		}
	}
}