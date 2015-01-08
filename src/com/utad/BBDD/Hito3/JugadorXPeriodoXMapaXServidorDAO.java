package com.utad.BBDD.Hito3;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * clase cuyos metodos añaden, borran, ven y modifican tuplas de la tabla jugadorxperiodoxmapaxservidor
 * 
 * @see JugadorXPeriodoXMapaXServidorVO
 * 
 */

public class JugadorXPeriodoXMapaXServidorDAO {
	
	/**
	 * permite insertar una tupla en la tabla jugadorxperiodoxmapaxservidor
	 * 
	 * @param JugadorVO fila
	 * @param DbConnection connection
	 * @return void
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void registrar(JugadorXPeriodoXMapaXServidorVO fila, DbConnection connection)
			throws SQLException, ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("INSERT INTO jugadorxperiodoxmapaxservidor VALUES ('"
					+ fila.getIdJugador() + "', '" 
					+ fila.getIdMapa() + "','"
					+ fila.getIdServidor() + "','"
					+ fila.getInicio() + "','"
					+ fila.getFin() + "','"
					+ fila.getGanador() + ")");
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
	 * permite consultar todas las tuplas de la tabla jugadorxperiodoxmapaxservidor
	 * 
	 * @param DbConnection connection
	 * @return ArrayList<JugadorXPeriodoXMapaXServidorVO
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<JugadorXPeriodoXMapaXServidorVO> ver(DbConnection connection)
			throws SQLException, ClassNotFoundException {
		ArrayList<JugadorXPeriodoXMapaXServidorVO> jugadores = new ArrayList<JugadorXPeriodoXMapaXServidorVO>();
		try {
			Statement statement = connection.getConnection().createStatement();
			ResultSet res = statement.executeQuery("SELECT * FROM jugadorxperiodoxmapaxservidor");

			while (res.next()) {
				jugadores.add(new JugadorXPeriodoXMapaXServidorVO(res.getInt("idJugador"), res
						.getInt("idMapa"), res
						.getInt("idServidor"), res
						.getDate("incio"),res
						.getDate("fin"),res
						.getInt("ganador")
						));
			}
			res.close();
			statement.close();
//			connection.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"no se pudo consultar la batalla\n" + e);
		}
		return jugadores;
	}
	
	/**
	 * permite borrar una tupla en la tabla jugadorxperiodoxmapaxservidor
	 * 
	 * @param DbConnection connection
	 * @param int idJugador
	 * @param int idMapa
	 * @paran int idServidor
	 * @param Date inicio
	 * @param Date fin
	 * @param int ganador
	 * @return void
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void borrar(DbConnection connection, int idJugador,int idMapa, int idServidor, Date inicio, Date fin, int ganador)
			throws SQLException, ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("DELETE FROM jugadorxperiodoxmapaxservidor WHERE idJugador = " + idJugador + "AND inicio = " + inicio);
			statement.close();
//			connection.close();
		} catch (SQLException e) {
			System.out.println("Error" + e);
		}
	}
}