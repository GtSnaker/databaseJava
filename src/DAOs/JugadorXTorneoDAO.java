package DAOs;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.utad.BBDD.Hito3.DbConnection;

import VOs.JugadorXTorneoVO;

/**
 * clase cuyos metodos añaden, borran, ven y modifican tuplas de la tabla jugadorxtorneo
 * 
 * @see JugadorXTorneoVO
 * 
 */

public class JugadorXTorneoDAO {
	
	/**
	 * permite insertar una tupla en la tabla jugadorxservidor
	 * 
	 * @param JugadorXTorneoVO fila
	 * @param DbConnection connection
	 * @return void
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void registrar(JugadorXTorneoVO fila, DbConnection connection)
			throws SQLException, ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("INSERT INTO jugadorxtorneo VALUES ('"
					+ fila.getId() + "', '" 
					+ fila.getNombre() + ")");
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
	public ArrayList<JugadorXTorneoVO> ver(DbConnection connection)
			throws SQLException, ClassNotFoundException {
		ArrayList<JugadorXTorneoVO> jugadores = new ArrayList<JugadorXTorneoVO>();
		try {
			Statement statement = connection.getConnection().createStatement();
			ResultSet res = statement.executeQuery("SELECT * FROM jugadorxtorneo");

			while (res.next()) {
				jugadores.add(new JugadorXTorneoVO(res.getInt("id"), res
						.getString("nombre")
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
	 * permite borrar una tupla en la tabla jugadorxtorneo
	 * 
	 * @param DbConnection connection
	 * @param int id
	 * @param int nombre
	 * @return void
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void borrar(DbConnection connection, int id, String nombre)
			throws SQLException, ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("DELETE FROM jugadorxtorneo WHERE id = " + id + "AND nombre = " + nombre);
			statement.close();
//			connection.close();
		} catch (SQLException e) {
			System.out.println("Error" + e);
		}
	}
	
	/**
	 * permite modificar una tupla en la tabla jugadorxtorneo
	 * 
	 * @param DbConnection connection
	 * @param int id
	 * @param String nombre
	 * @return void
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void modificar(DbConnection connection, int id, String nombre) throws SQLException,
			ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			ResultSet res = statement
					.executeQuery("SELECT * FROM jugadorxtorneo WHERE id = " + id + " AND nombre = " + nombre);
			
			while (res.next()) {
				System.out.println("Id: " + res.getInt("id") + ", Nombre: "
						+ res.getString("nombre"));
			}
			System.out
					.println("Introduce el nombre de el campo que quieres cambiar: ");
			System.out
					.println("id, nombre");
			Scanner sc = new Scanner(System.in);
			String columna = sc.nextLine();
			if (columna.equals("id") || columna.equals("nombre")) {
				int index = res.findColumn(columna);
				if (index == 1) {
					System.out
							.println("Introdce el entero por el que quieres modificarlo: ");
					int valor = sc.nextInt();
					statement.executeUpdate("UPDATE jugadorxtorneo SET " + columna
							+ " = " + valor + " WHERE id = " + id + " AND nombre = " + nombre);
				} else {
					System.out
							.println("Introduce el string por el que quieres modificarlo: ");
					String valor = sc.nextLine();
					statement.executeUpdate("UPDATE jugadorxtorneo SET " + columna
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