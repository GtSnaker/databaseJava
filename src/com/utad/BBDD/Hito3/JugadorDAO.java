package com.utad.BBDD.Hito3;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * clase cuyos metodos añaden, borran, ven y modifican tuplas de la tabla jugador
 * 
 * @see JugadorVO
 * 
 */

public class JugadorDAO {
	
	/**
	 * permite insertar una tupla en la tabla jugador
	 * 
	 * @param JugadorVO fila
	 * @param DbConnection connection
	 * @return void
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void registrar(JugadorVO fila, DbConnection connection)
			throws SQLException, ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("INSERT INTO jugador VALUES ('"
					+ fila.getId() + "', '" + fila.getNombre() + "', '"
					+ fila.getApellido() + "', '" + fila.getEdad() + "', '"
					+ fila.getPais() + "', '" + fila.getMail() + "', '"
					+ fila.getBattletag() + "', '" + fila.getPassword()
					+ "', '" + fila.getLiga() + "')");
			JOptionPane.showMessageDialog(null,
					"Se ha registrado Exitosamente", "Información",
					JOptionPane.INFORMATION_MESSAGE);
			statement.close();
//			connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null,
					"No se pudo registrar al jugador");
		}
	}

	/**
	 * permite consultar todas las tuplas de la tabla jugador
	 * 
	 * @param DbConnection connection
	 * @return ArrayList<JugadorVO>
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<JugadorVO> ver(DbConnection connection)
			throws SQLException, ClassNotFoundException {
		ArrayList<JugadorVO> jugadores = new ArrayList<JugadorVO>();
		try {
			Statement statement = connection.getConnection().createStatement();
			ResultSet res = statement.executeQuery("SELECT * FROM jugador");

			while (res.next()) {
				jugadores.add(new JugadorVO(res.getInt("id"), res
						.getString("nombre"), res.getString("apellido"), res
						.getDate("edad"), res.getString("pais"), res
						.getString("mail"), res.getString("battletag"), res
						.getString("password"), res.getInt("liga")));
			}
			res.close();
			statement.close();
//			connection.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"no se pudo consultar la Persona\n" + e);
		}
		return jugadores;
	}
	
	/**
	 * permite borrar una tupla en la tabla jugador
	 * 
	 * @param DbConnection connection
	 * @param int id
	 * @return void
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void borrar(DbConnection connection, int id)
			throws SQLException, ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("DELETE FROM jugador WHERE id = " + id);
			statement.close();
//			connection.close();
		} catch (SQLException e) {
			System.out.println("Error" + e);
		}
	}
}
