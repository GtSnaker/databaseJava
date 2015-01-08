package com.utad.BBDD.Hito3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.mysql.jdbc.ResultSetMetaData;

/**
 * clase cuyos metodos añaden, borran, ven y modifican tuplas de la tabla liga
 * 
 * @see LigaVO
 * 
 */
public class LigaDAO {
	
	/**
	 * permite insertar una tupla en la tabla liga
	 * 
	 * @param LigaVO fila
	 * @param DbConnection connection
	 * @return void
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void registrar(LigaVO fila, DbConnection connection)
			throws SQLException, ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("INSERT INTO liga VALUES ('"
					+ fila.getId() + "', '" + fila.getLiga() + "', '"
					+ fila.getIcono() + "')");
			JOptionPane.showMessageDialog(null,
					"Se ha registrado Exitosamente", "Información",
					JOptionPane.INFORMATION_MESSAGE);
			statement.close();
//			connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null,
					"No se pudo registrar la liga");
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
	public ArrayList<LigaVO> ver(DbConnection connection)
			throws SQLException, ClassNotFoundException {
		ArrayList<LigaVO> ligas = new ArrayList<LigaVO>();
		try {
			Statement statement = connection.getConnection().createStatement();
			ResultSet res = statement.executeQuery("SELECT * FROM liga");

			while (res.next()) {
				String nombreLiga =  res.getString("nombre");
				Liga miLiga = Liga.valueOf(nombreLiga);
				ligas.add(new LigaVO(res.getInt("id"), miLiga,  res.getString("icono")));
			}
			res.close();
			statement.close();
//			connection.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"no se pudo consultar la liga\n" + e);
		}
		return ligas;
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
	public void borrar(DbConnection connection, int id)
			throws SQLException, ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("DELETE FROM liga WHERE id = " + id);
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
	public void modificar(DbConnection connection, int id)
			throws SQLException, ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			ResultSet res = statement.executeQuery("SELECT * FROM liga WHERE id = " + id);
			System.out.println("Introduce el nombre de el campo que quieres cambiar: ");
			System.out.println("id, nombre, icono");
			Scanner sc = new Scanner(System.in);
			String columna = sc.nextLine();
			if(columna.equals("id") || columna.equals("nombre") || columna.equals("icono")){
				int index = res.findColumn(columna);
				if (index == 1){
					System.out.println("Introdce el entero por el que quieres modificarlo: ");
					int valor = sc.nextInt();
					statement.executeUpdate("UPDATE liga SET "+ columna +" = "+ valor +" WHERE id = " + id);
				}
				else{
					System.out.println("Introduce el string por el que quieres modificarlo: ");
					String valor = sc.nextLine();
					if(columna.equals("nombre")){
						try {
							Liga miLiga = Liga.valueOf(valor);
							String q = "UPDATE liga SET "+ columna +" = \'"+ valor +"\' WHERE id = " + id;
							statement.executeUpdate(q);
						} catch(Exception e){
							System.out.println(e);
						}
					}
					else {
						statement.executeUpdate("UPDATE liga SET "+ columna +" = \""+ valor +"\" WHERE id = " + id);
					}
				}
			}
			else{
				System.out.println("Introduce uno de los valores aceptados.");
			}
			statement.close();
//			connection.close();
		} catch (SQLException e) {
			System.out.println("Error" + e);
		}
	}
	
	
}
