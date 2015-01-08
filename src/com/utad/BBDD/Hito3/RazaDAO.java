package com.utad.BBDD.Hito3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class RazaDAO {
	/**
	 * permite insertar una tupla en la tabla liga
	 * 
	 * @param LigaVO
	 *            fila
	 * @param DbConnection
	 *            connection
	 * @return void
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void registrar(RazaVO fila, DbConnection connection)
			throws SQLException, ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("INSERT INTO raza VALUES ('"
					+ fila.getRaza() + "')");
			JOptionPane.showMessageDialog(null,
					"Se ha registrado Exitosamente", "Información",
					JOptionPane.INFORMATION_MESSAGE);
			statement.close();
			// connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "No se pudo registrar la raza");
		}
	}
	
	/**
	 * permite consultar todas las tuplas de la tabla liga
	 * 
	 * @param DbConnection connection
	 * @return ArrayList<LigaVO>
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<RazaVO> ver(DbConnection connection)
			throws SQLException, ClassNotFoundException {
		ArrayList<RazaVO> razas = new ArrayList<RazaVO>();
		try {
			Statement statement = connection.getConnection().createStatement();
			ResultSet res = statement.executeQuery("SELECT * FROM raza");

			while (res.next()) {
				String nombreLiga =  res.getString("nombre");
				Raza miRaza = Raza.valueOf(nombreLiga);
				razas.add(new RazaVO(miRaza));
			}
			res.close();
			statement.close();
//			connection.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"no se pudo consultar la liga\n" + e);
		}
		return razas;
	}
	
	/**
	 * permite borrar una tupla en la tabla liga
	 * 
	 * @param DbConnection connection
	 * @param int id
	 * @return void
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void borrar(DbConnection connection, Raza raza)
			throws SQLException, ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("DELETE FROM raza WHERE nombre = " + raza);
			statement.close();
//			connection.close();
		} catch (SQLException e) {
			System.out.println("Error" + e);
		}
	}
	
	/**
	 * permite modificar una tupla en la tabla liga
	 * 
	 * @param DbConnection
	 *            connection
	 * @param int id
	 * @return void
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void modificar(DbConnection connection, Raza raza)
			throws SQLException, ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			ResultSet res = statement.executeQuery("SELECT * FROM raza WHERE nombre = " + raza);
			System.out.println("Introduce el nombre de el campo que quieres cambiar: ");
			System.out.println("nombre");
			Scanner sc = new Scanner(System.in);
			String columna = sc.nextLine();
			if(columna.equals("nombre")){
				System.out.println("Introduce el string por el que quieres modificarlo: ");
				String valor = sc.nextLine();
				try {
					Liga miLiga = Liga.valueOf(valor);
					String q = "UPDATE raza SET "+ columna +" = \'"+ valor +"\' WHERE nombre = " + raza;
					statement.executeUpdate(q);
				} catch(Exception e){
					System.out.println(e);
				}
				System.out.println("Liga modificada.");
				statement.close();
//				connection.close();
			} else{
				System.out.println("Introduce uno de los valores aceptados.");
			}
		} catch (SQLException e) {
			System.out.println("Error" + e);
		}
	}

}
