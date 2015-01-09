package com.utad.BBDD.Hito3;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * clase cuyos metodos añaden, borran, ven y modifican tuplas de la tabla jugadorxservidor
 * 
 * @see JugadorXRazaVO
 * 
 */

public class JugadorXServidorDAO {
	
	/**
	 * permite insertar una tupla en la tabla jugadorxservidor
	 * 
	 * @param JugadorXServidorVO fila
	 * @param DbConnection connection
	 * @return void
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void registrar(JugadorXServidorVO fila, DbConnection connection)
			throws SQLException, ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("INSERT INTO jugadorxservidor VALUES ('"
					+ fila.getIdJugador() + "', '" 
					+ fila.getIdServidor() + "','"
					+ fila.getInicio() + "','"
					+ fila.getFin()
							+ ")");
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
	public ArrayList<JugadorXServidorVO> ver(DbConnection connection)
			throws SQLException, ClassNotFoundException {
		ArrayList<JugadorXServidorVO> jugadores = new ArrayList<JugadorXServidorVO>();
		try {
			Statement statement = connection.getConnection().createStatement();
			ResultSet res = statement.executeQuery("SELECT * FROM jugadorxservidor");

			while (res.next()) {
				jugadores.add(new JugadorXServidorVO(res.getInt("idJugador"), res
						.getInt("IdServidor"), res
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
	 * permite borrar una tupla en la tabla jugadorxservidor
	 * 
	 * @param DbConnection connection
	 * @param int idJugador
	 * @param int idServidor
	 * @paran Date inicio
	 * @param Date fin
	 * @return void
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void borrar(DbConnection connection, int idJugador,int idServidor, String inicio)
			throws SQLException, ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("DELETE FROM jugadorxservidor WHERE idJugador = " + idJugador + "AND idServidor = " + idServidor +"AND inicio = " + inicio);
			statement.close();
//			connection.close();
		} catch (SQLException e) {
			System.out.println("Error" + e);
		}
	}
}