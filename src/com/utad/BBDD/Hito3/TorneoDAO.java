package com.utad.BBDD.Hito3;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * clase cuyos metodos añaden, borran, ven y modifican tuplas de la tabla torneo
 * 
 * @see TorneoVO
 * 
 */

public class TorneoDAO {
	
	/**
	 * permite insertar una tupla en la tabla servidor
	 * 
	 * @param TorneoVO fila
	 * @param DbConnection connection
	 * @return void
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void registrar(TorneoVO fila, DbConnection connection)
			throws SQLException, ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("INSERT INTO torneo VALUES ('"
					+ fila.getNombre() + "', '" 
					+ fila.getLiga() + "', '"
					+ fila.getPremio()  + "', '"
					+ fila.getInicio() + "', '"
					+ fila.getFin() +
					")");
			JOptionPane.showMessageDialog(null,
					"Se ha registrado Exitosamente", "Información",
					JOptionPane.INFORMATION_MESSAGE);
			statement.close();
//			connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null,
					"No se pudo registrar al torneo");
		}
	}

	/**
	 * permite consultar todas las tuplas de la tabla torneo
	 * 
	 * @param DbConnection connection
	 * @return ArrayList<TorneoVO
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<TorneoVO> ver(DbConnection connection)
			throws SQLException, ClassNotFoundException {
		ArrayList<TorneoVO> jugadores = new ArrayList<TorneoVO>();
		try {
			Statement statement = connection.getConnection().createStatement();
			ResultSet res = statement.executeQuery("SELECT * FROM torneo");

			while (res.next()) {
				jugadores.add(new TorneoVO(res.getString("nombre"), res
						.getInt("liga"), res
						.getString("premio"), res
						.getDate("inicio"), res
						.getDate("fin")
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
	 * permite borrar una tupla en la tabla torneo
	 * 
	 * @param DbConnection connection
	 * @param String nombre
	 * @param int liga
	 * @param String premio
	 * @param Date inicio
	 * @param Date fin
	 * @return void
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void borrar(DbConnection connection, String nombre, int liga, String premio, Date inicio, Date fin)
			throws SQLException, ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("DELETE FROM torneo WHERE nombre = " + nombre + "and liga = " + liga);
			statement.close();
//			connection.close();
		} catch (SQLException e) {
			System.out.println("Error" + e);
		}
	}
}