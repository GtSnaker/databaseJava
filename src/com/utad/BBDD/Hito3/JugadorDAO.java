package com.utad.BBDD.Hito3;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * clase cuyos metodos añaden, borran, ven y modifican tuplas de la tabla
 * jugador
 * 
 * @see JugadorVO
 * 
 */
public class JugadorDAO {

	/**
	 * permite insertar una tupla en la tabla jugador
	 * 
	 * @param JugadorVO
	 *            fila
	 * @param DbConnection
	 *            connection
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
			// connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null,
					"No se pudo registrar al jugador");
		}
	}

	/**
	 * permite consultar todas las tuplas de la tabla jugador
	 * 
	 * @param DbConnection
	 *            connection
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
						.getString("edad"), res.getString("pais"), res
						.getString("mail"), res.getString("battletag"), res
						.getString("password"), res.getInt("liga")));
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
	 * permite borrar una tupla en la tabla jugador
	 * 
	 * @param DbConnection
	 *            connection
	 * @param int id
	 * @return void
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void borrar(DbConnection connection, int id) throws SQLException,
			ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("DELETE FROM jugador WHERE id = " + id);
			statement.close();
			// connection.close();
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
	public void modificar(DbConnection connection, int id) throws SQLException,
			ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			ResultSet res = statement
					.executeQuery("SELECT * FROM jugador WHERE id = " + id);
			
			while (res.next()) {
				System.out.println("Id: " + res.getInt("id") + ", Nombre: "
						+ res.getString("nombre") + ", Apellido: "
						+ res.getString("apellido") + ", Edad: "
						+ res.getString("edad") + ", Pais: "
						+ res.getString("pais") + ", Mail: "
						+ res.getString("mail") + ", Battletag: "
						+ res.getString("battletag")
						+ ", Password: **********, Liga: " + res.getInt("liga"));
			}
			

			System.out
					.println("Introduce el nombre de el campo que quieres cambiar: ");
			System.out
					.println("id, nombre, apellido, edad, pais, mail, battletag, password, liga");
			Scanner sc = new Scanner(System.in);
			String columna = sc.nextLine();
			if (columna.equals("id") || columna.equals("nombre")
					|| columna.equals("apellido") || columna.equals("edad")
					|| columna.equals("pais") || columna.equals("mail")
					|| columna.equals("battletag")
					|| columna.equals("password") || columna.equals("liga")) {
				int index = res.findColumn(columna);
				if (index == 1 || index == 9) {
					System.out
							.println("Introdce el entero por el que quieres modificarlo: ");
					int valor = sc.nextInt();
					statement.executeUpdate("UPDATE jugador SET " + columna
							+ " = " + valor + " WHERE id = " + id);
				} else {
					System.out
							.println("Introduce el string por el que quieres modificarlo: ");
					String valor = sc.nextLine();
					statement.executeUpdate("UPDATE jugador SET " + columna
							+ " = \"" + valor + "\" WHERE id = " + id);
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
