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
	/**
	 * permite modificar una tupla en la tabla jugadorxraza
	 * 
	 * @param DbConnection connection
	 * @param int id
	 * @param Raza nombre
	 * @return void
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void modificar(DbConnection connection, int id, Raza nombre) throws SQLException,
			ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			ResultSet res = statement
					.executeQuery("SELECT * FROM jugadorxraza WHERE id = " + id + " AND nombre = " + nombre);
			
			while (res.next()) {
				String nombreRaza = res.getString("nombre");
				Raza miRaza = Raza.valueOf(nombreRaza);
				System.out.println("Id: " + res.getInt("id") + ", Nombre: "
						+ miRaza + ", Ganadas: "
						+ res.getInt("ganadas") + ", Perdidas: "
						+ res.getString("inicio") + ", Fin: "
						+ res.getString("fin") + ", Ganador: "
						+ res.getInt("ganador"));
			}
			System.out
					.println("Introduce el nombre de el campo que quieres cambiar: ");
			System.out
					.println("id, nombre, ganadas, perdidas");
			Scanner sc = new Scanner(System.in);
			String columna = sc.nextLine();
			if (columna.equals("id") || columna.equals("nombre")
					|| columna.equals("ganadas") || columna.equals("perdidas")) {
				int index = res.findColumn(columna);
				if (index == 1 || index == 3 || index == 4) {
					System.out
							.println("Introdce el entero por el que quieres modificarlo: ");
					int valor = sc.nextInt();
					statement.executeUpdate("UPDATE jugadorxraza SET " + columna
							+ " = " + valor + " WHERE id = " + id + " AND nombre = " + nombre);
				} else {
					System.out
							.println("Introduce el string por el que quieres modificarlo: ");
					String valor = sc.nextLine();
					statement.executeUpdate("UPDATE jugadorxraza SET " + columna
							+ " = \"" + valor + "\" WHERE id = " + id + " AND nombre = " + nombre);
				}
			} else {
				System.out.println("Introduce uno de los valores aceptados.");
			}
			System.out.println("Jugador modificado.");
			statement.close();
			// connection.close();
		} catch (SQLException e) {
			System.out.println("Error" + e);
		}
	}
}