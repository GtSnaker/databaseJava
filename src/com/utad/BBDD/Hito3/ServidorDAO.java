package com.utad.BBDD.Hito3;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * clase cuyos metodos añaden, borran, ven y modifican tuplas de la tabla jugadorxtorneo
 * 
 * @see ServidorVO
 * 
 */

public class ServidorDAO {
	
	/**
	 * permite insertar una tupla en la tabla servidor
	 * 
	 * @param ServidorVO fila
	 * @param DbConnection connection
	 * @return void
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void registrar(Servidor fila, DbConnection connection)
			throws SQLException, ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("INSERT INTO servidor VALUES ('"
					+ fila.getId() + "', '" 
					+ fila.getNombre() + "', '"
					+ fila.getPais()  + "', '"
					+ fila.getMax() +
					")");
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
	 * permite consultar todas las tuplas de la tabla servidor
	 * 
	 * @param DbConnection connection
	 * @return ArrayList<ServidorVO
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<ServidorVO> ver(DbConnection connection)
			throws SQLException, ClassNotFoundException {
		ArrayList<ServidorVO> jugadores = new ArrayList<ServidorVO>();
		try {
			Statement statement = connection.getConnection().createStatement();
			ResultSet res = statement.executeQuery("SELECT * FROM servidor");

			while (res.next()) {
				jugadores.add(new ServidorVO(res.getInt("id"), res
						.getString("nombre"), res
						.getString("pais"), res
						.getInt("max")
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
	 * permite borrar una tupla en la tabla servidor
	 * 
	 * @param DbConnection connection
	 * @param int id
	 * @param String nombre
	 * @param String pais
	 * @param int max
	 * @return void
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void borrar(DbConnection connection, int id, String nombre, String pais, int max)
			throws SQLException, ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("DELETE FROM servidor WHERE id = " + id);
			statement.close();
//			connection.close();
		} catch (SQLException e) {
			System.out.println("Error" + e);
		}
	}
}