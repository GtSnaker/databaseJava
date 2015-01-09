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
	public void registrar(ServidorVO fila, DbConnection connection)
			throws SQLException, ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			System.out.println("ID: " + fila.getId());
			statement.executeUpdate("INSERT INTO servidor VALUES ('"
					+ fila.getId() + "', '" 
					+ fila.getNombre() + "', '"
					+ fila.getPais()  + "', '"
					+ fila.getMax() +
					"');");
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
	public ArrayList<ServidorVO> ver(DbConnection connection) throws SQLException, ClassNotFoundException {
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
	public void borrar(DbConnection connection, int id)
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
	public void modificar(DbConnection connection, int id)
			throws SQLException, ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			ResultSet res = statement.executeQuery("SELECT * FROM servidor WHERE id = " + id);
			while (res.next()) {
				System.out.println("Id: " + res.getInt("id") + ", Nombre: "
						+ res.getString("nombre") + ", Pais: "
						+ res.getString("pais") + ", Maximo: "
						+ res.getInt("max"));
			}
			System.out.println("Introduce el nombre de el campo que quieres cambiar: ");
			System.out.println("id, nombre, pais, max");
			Scanner sc = new Scanner(System.in);
			String columna = sc.nextLine();
			if(columna.equals("id") || columna.equals("nombre") || columna.equals("pais") || columna.equals("max")){
				int index = res.findColumn(columna);
				if (index == 1 || index == 4){
					System.out.println("Introdce el entero por el que quieres modificarlo: ");
					int valor = sc.nextInt();
					statement.executeUpdate("UPDATE servidor SET "+ columna +" = "+ valor +" WHERE id = " + id);
				}
				else{
					System.out.println("Introduce el string por el que quieres modificarlo: ");
					String valor = sc.nextLine();
					statement.executeUpdate("UPDATE servidor SET "+ columna +" = \""+ valor +"\" WHERE id = " + id);
				}
			}
			else{
				System.out.println("Introduce uno de los valores aceptados.");
			}
			System.out.println("Logro modificado");
			statement.close();
//			connection.close();
		} catch (SQLException e) {
			System.out.println("Error" + e);
		}
	}
}