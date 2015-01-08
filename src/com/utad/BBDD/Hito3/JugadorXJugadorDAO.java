package com.utad.BBDD.Hito3;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * clase cuyos metodos añaden, borran, ven y modifican tuplas de la tabla jugadorxjugador
 * 
 * @see JugadorXJugadorVO
 * 
 */

public class JugadorXJugadorDAO {
	
	/**
	 * permite insertar una tupla en la tabla jugadorxjugador
	 * 
	 * @param JugadorVO fila
	 * @param DbConnection connection
	 * @return void
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void registrar(JugadorXJugadorVO fila, DbConnection connection)
			throws SQLException, ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("INSERT INTO jugadorxjugador VALUES ('"
					+ fila.getId() + "', '" + fila.getId2() + "')");
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
	 * permite consultar todas las tuplas de la tabla jugadorxjugador
	 * 
	 * @param DbConnection connection
	 * @return ArrayList<JugadorXJugadorVO>
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<JugadorXJugadorVO> ver(DbConnection connection)
			throws SQLException, ClassNotFoundException {
		ArrayList<JugadorXJugadorVO> jugadores = new ArrayList<JugadorXJugadorVO>();
		try {
			Statement statement = connection.getConnection().createStatement();
			ResultSet res = statement.executeQuery("SELECT * FROM jugadorxjugador");

			while (res.next()) {
				jugadores.add(new JugadorXJugadorVO(res.getInt("id"), res
						.getInt("id2")));
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
	 * permite borrar una tupla en la tabla jugadorxjugador
	 * 
	 * @param DbConnection connection
	 * @param int id
	 * @param int id2
	 * @return void
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void borrar(DbConnection connection, int id,int id2)
			throws SQLException, ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("DELETE FROM jugadorxjugador WHERE id = " + id + " AND id2 = " + id2);
			statement.close();
//			connection.close();
		} catch (SQLException e) {
			System.out.println("Error" + e);
		}
	}
	
	/**
	 * permite modificar una tupla en la tabla jugador
	 * 
	 * @param DbConnection
	 *            connection
	 * @param int id
	 * @return void
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void modificar(DbConnection connection, int id, int id2)
			throws SQLException, ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			ResultSet res = statement.executeQuery("SELECT * FROM jugadorxjugador WHERE id = " + id);
			System.out.println("Introduce el nombre de el campo que quieres cambiar: ");
			System.out.println("id, id2");
			Scanner sc = new Scanner(System.in);
			String columna = sc.nextLine();
			if(columna.equals("id") || columna.equals("id2")){
				System.out.println("Introdce el entero por el que quieres modificarlo: ");
				int valor = sc.nextInt();
				statement.executeUpdate("UPDATE jugadorxjugador SET "+ columna +" = "+ valor +" WHERE id = " + id + " AND id2 = " + id2);
			}
			else{
				System.out.println("Introduce uno de los valores aceptados.");
			}
			System.out.println("JugadorXJugador modificado.");
			statement.close();
//			connection.close();
		} catch (SQLException e) {
			System.out.println("Error" + e);
		}
	}
}