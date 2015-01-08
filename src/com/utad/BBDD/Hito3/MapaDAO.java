package com.utad.BBDD.Hito3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class MapaDAO {
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
	public void registrar(MapaVO fila, DbConnection connection)
			throws SQLException, ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("INSERT INTO mapa VALUES ('"
					+ fila.getId() + "', '" + fila.getNombre() + "', '"
					+ fila.getDescripcion() + "', '" + fila.getMax() +"')");
			JOptionPane.showMessageDialog(null,
					"Se ha registrado Exitosamente", "Información",
					JOptionPane.INFORMATION_MESSAGE);
			statement.close();
			// connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane
					.showMessageDialog(null, "No se pudo registrar el logro");
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
	public ArrayList<MapaVO> ver(DbConnection connection) throws SQLException,
			ClassNotFoundException {
		ArrayList<MapaVO> mapas = new ArrayList<MapaVO>();
		try {
			Statement statement = connection.getConnection().createStatement();
			ResultSet res = statement.executeQuery("SELECT * FROM mapa");

			while (res.next()) {
				mapas.add(new MapaVO(res.getInt("id"), res
						.getString("nombre"), res.getString("descripcion"), res.getInt("max")));
			}
			res.close();
			statement.close();
			// connection.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"no se pudo consultar la Persona\n" + e);
		}
		return mapas;
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
	public void borrar(DbConnection connection, int id)
			throws SQLException, ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("DELETE FROM mapa WHERE id = " + id);
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
			ResultSet res = statement.executeQuery("SELECT * FROM mapa WHERE id = " + id);
			System.out.println("Introduce el nombre de el campo que quieres cambiar: ");
			System.out.println("id, nombre, descripcion, max");
			Scanner sc = new Scanner(System.in);
			String columna = sc.nextLine();
			if(columna.equals("id") || columna.equals("nombre") || columna.equals("descripcion") || columna.equals("max")){
				int index = res.findColumn(columna);
				if (index == 1 || index == 4){
					System.out.println("Introdce el entero por el que quieres modificarlo: ");
					int valor = sc.nextInt();
					statement.executeUpdate("UPDATE mapa SET "+ columna +" = "+ valor +" WHERE id = " + id);
				}
				else{
					System.out.println("Introduce el string por el que quieres modificarlo: ");
					String valor = sc.nextLine();
					statement.executeUpdate("UPDATE mapa SET "+ columna +" = \""+ valor +"\" WHERE id = " + id);
				}
			}
			else{
				System.out.println("Introduce uno de los valores aceptados.");
			}
			System.out.println("Mapa modificado");
			statement.close();
//			connection.close();
		} catch (SQLException e) {
			System.out.println("Error" + e);
		}
	}
}
