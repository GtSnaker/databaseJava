package com.utad.BBDD.Hito3;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * clase cuyos metodos añaden, borran, ven y modifican tuplas de la tabla jugadorxtorneo
 * 
 * @see JugadorXTorneoVO
 * 
 */

public class JugadorXTorneoDAO {
	
	/**
	 * permite insertar una tupla en la tabla jugadorxservidor
	 * 
	 * @param JugadorXTorneoVO fila
	 * @param DbConnection connection
	 * @return void
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void registrar(JugadorXTorneoVO fila, DbConnection connection)
			throws SQLException, ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("INSERT INTO jugadorxtorneo VALUES ('"
					+ fila.getId() + "', '" 
					+ fila.getNombre() + ")");
			JOptionPane.showMessageDialog(null,
					"Se ha registrado Exitosamente", "Información",
					JOptionPane.INFORMATION_MESSAGE);
			statement.close();
//			connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null,
					"No se pudo registrar al servidor");
		}
	}

	/**
	 * permite consultar todas las tuplas de la tabla jugadorxservidor
	 * 
	 * @param DbConnection connection
	 * @return ArrayList<JugadorXServidorVO
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<JugadorXTorneoVO> ver(DbConnection connection)
			throws SQLException, ClassNotFoundException {
		ArrayList<JugadorXTorneoVO> jugadores = new ArrayList<JugadorXTorneoVO>();
		try {
			Statement statement = connection.getConnection().createStatement();
			ResultSet res = statement.executeQuery("SELECT * FROM jugadorxtorneo");

			while (res.next()) {
				jugadores.add(new JugadorXTorneoVO(res.getInt("id"), res
						.getString("nombre")
						));
			}
			res.close();
			statement.close();
//			connection.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"no se pudo consultar la tabla\n" + e);
		}
		return jugadores;
	}
	/**
	 * permite borrar una tupla en la tabla jugadorxtorneo
	 * 
	 * @param DbConnection connection
	 * @param int id
	 * @param int nombre
	 * @return void
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void borrar(DbConnection connection, int id, String nombre)
			throws SQLException, ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("DELETE FROM jugadorxtorneo WHERE id = " + id + "AND nombre = " + nombre);
			statement.close();
//			connection.close();
		} catch (SQLException e) {
			System.out.println("Error" + e);
		}
	}
}