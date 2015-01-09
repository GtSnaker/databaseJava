package com.utad.BBDD.Hito3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class PeriodoDAO {
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
	public void registrar(PeriodoVO fila, DbConnection connection)
			throws SQLException, ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("INSERT INTO periodo VALUES ('"
					+ fila.getInicio() + "', '" + fila.getFin() + "')");
			JOptionPane.showMessageDialog(null,
					"Se ha registrado Exitosamente", "Información",
					JOptionPane.INFORMATION_MESSAGE);
			statement.close();
			// connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null,
					"No se pudo registrar el Periodo");
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
	public ArrayList<PeriodoVO> ver(DbConnection connection)
			throws SQLException, ClassNotFoundException {
		ArrayList<PeriodoVO> periodos = new ArrayList<PeriodoVO>();
		try {
			Statement statement = connection.getConnection().createStatement();
			ResultSet res = statement.executeQuery("SELECT * FROM periodo");
			while (res.next()) {
				periodos.add(new PeriodoVO(res.getString("inicio"), res
						.getString("fin")));
			}
			res.close();
			statement.close();
			// connection.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"no se pudo consultar el Periodo\n" + e);
		}
		return periodos;
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
	public void borrar(DbConnection connection, String inicio, String fin) throws SQLException,
			ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("DELETE FROM periodo WHERE inicio = " + inicio + " AND fin = " + fin);
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
	public void modificar(DbConnection connection, String inicio, String fin) throws SQLException,
			ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			ResultSet res = statement
					.executeQuery("SELECT * FROM periodo WHERE inicio = " + inicio + " AND fin = " + fin);
			System.out
					.println("Introduce el nombre de el campo que quieres cambiar: ");
			System.out.println("id, nombre, descripcion");
			Scanner sc = new Scanner(System.in);
			String columna = sc.nextLine();
			if (columna.equals("inicio") || columna.equals("fin")) {
//				int year, int month, int date, int hour, int minute, int second, int nano
				System.out.println("Introduce la fecha: YY-MM-DD HH24:MI:SS");
				String valor = sc.nextLine();
				statement.executeUpdate("UPDATE periodo SET " + columna + " = " + valor + " WHERE inicio = " + inicio + " AND fin = " + fin);
			} else {
				System.out.println("Introduce uno de los valores aceptados.");
			}
			System.out.println("Periodo modificado");
			statement.close();
			// connection.close();
		} catch (SQLException e) {
			System.out.println("Error" + e);
		}
	}
}
