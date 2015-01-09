package DAOs;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.utad.BBDD.Hito3.DbConnection;

import VOs.TorneoVO;

/**
 * clase cuyos metodos añaden, borran, ven y modifican tuplas de la tabla torneo
 * 
 * @see TorneoVO
 * 
 */

public class TorneoDAO {

	/**
	 * permite insertar una tupla en la tabla servidor
	 * 
	 * @param TorneoVO
	 *            fila
	 * @param DbConnection
	 *            connection
	 * @return void
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void registrar(TorneoVO fila, DbConnection connection)
			throws SQLException, ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("INSERT INTO torneo VALUES ('"
					+ fila.getNombre() + "', '" + fila.getLiga() + "', '"
					+ fila.getPremio() + "', '" + fila.getInicio() + "', '"
					+ fila.getFin() + "')");
			JOptionPane.showMessageDialog(null,
					"Se ha registrado Exitosamente", "Información",
					JOptionPane.INFORMATION_MESSAGE);
			statement.close();
			// connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null,
					"No se pudo registrar al torneo");
		}
	}

	/**
	 * permite consultar todas las tuplas de la tabla torneo
	 * 
	 * @param DbConnection
	 *            connection
	 * @return ArrayList<TorneoVO
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<TorneoVO> ver(DbConnection connection)
			throws SQLException, ClassNotFoundException {
		ArrayList<TorneoVO> jugadores = new ArrayList<TorneoVO>();
		try {
			Statement statement = connection.getConnection().createStatement();
			ResultSet res = statement.executeQuery("SELECT * FROM torneo");

			while (res.next()) {
				jugadores.add(new TorneoVO(res.getString("nombre"), res
						.getInt("liga"), res.getString("premio"), res
						.getString("inicio"), res.getString("fin")));
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
	 * permite borrar una tupla en la tabla torneo
	 * 
	 * @param DbConnection
	 *            connection
	 * @param String
	 *            nombre
	 * @param int liga
	 * @param String
	 *            premio
	 * @param Date
	 *            inicio
	 * @param Date
	 *            fin
	 * @return void
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void borrar(DbConnection connection, String nombre, int liga)
			throws SQLException, ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("DELETE FROM torneo WHERE nombre = "
					+ nombre + "and liga = " + liga);
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
	public void modificar(DbConnection connection, String nombre, int liga)
			throws SQLException, ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			ResultSet res = statement
					.executeQuery("SELECT * FROM torneo WHERE nombre = '"
							+ nombre + "' AND liga = '" + liga + "'");
			while (res.next()) {
				System.out.println("Nombre: " + res.getString("nombre") + ", Liga: "
						+ res.getInt("liga") + ", Premio: "
						+ res.getString("premio") + ", Inicio: "
						+ res.getString("inicio") + ", Fin: "
						+ res.getString("fin"));
			}
			System.out
					.println("Introduce el nombre de el campo que quieres cambiar: ");
			System.out.println("nombre, liga, premio, inicio, fin");
			Scanner sc = new Scanner(System.in);
			String columna = sc.nextLine();
			if (columna.equals("nombre") || columna.equals("liga")
					|| columna.equals("premio") || columna.equals("inicio")
					|| columna.equals("fin")) {
				int index = res.findColumn(columna);
				System.out
						.println("Introduce el string por el que quieres modificarlo: ");
				String valor = sc.nextLine();
				statement.executeUpdate("UPDATE torneo SET " + columna
						+ " = \"" + valor + "\" WHERE nombre = '"
							+ nombre + "' AND liga = '" + liga + "'");
			} else {
				System.out.println("Introduce uno de los valores aceptados.");
			}
			System.out.println("Torneo modificado");
			statement.close();
			// connection.close();
		} catch (SQLException e) {
			System.out.println("Error" + e);
		}
	}
}