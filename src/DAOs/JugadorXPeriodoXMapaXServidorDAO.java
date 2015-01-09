package DAOs;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import VOs.JugadorXPeriodoXMapaXServidorVO;

import com.utad.BBDD.Hito3.DbConnection;

/**
 * clase cuyos metodos añaden, borran, ven y modifican tuplas de la tabla jugadorxperiodoxmapaxservidor
 * 
 * @see JugadorXPeriodoXMapaXServidorVO
 * 
 */

public class JugadorXPeriodoXMapaXServidorDAO {
	
	/**
	 * permite insertar una tupla en la tabla jugadorxperiodoxmapaxservidor
	 * 
	 * @param JugadorVO fila
	 * @param DbConnection connection
	 * @return void
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void registrar(JugadorXPeriodoXMapaXServidorVO fila, DbConnection connection)
			throws SQLException, ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("INSERT INTO jugadorxperiodoxmapaxservidor VALUES ('"
					+ fila.getIdJugador() + "', '" 
					+ fila.getIdMapa() + "','"
					+ fila.getIdServidor() + "','"
					+ fila.getInicio() + "','"
					+ fila.getFin() + "','"
					+ fila.getGanador() + ")");
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
	 * permite consultar todas las tuplas de la tabla jugadorxperiodoxmapaxservidor
	 * 
	 * @param DbConnection connection
	 * @return ArrayList<JugadorXPeriodoXMapaXServidorVO
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<JugadorXPeriodoXMapaXServidorVO> ver(DbConnection connection)
			throws SQLException, ClassNotFoundException {
		ArrayList<JugadorXPeriodoXMapaXServidorVO> jugadores = new ArrayList<JugadorXPeriodoXMapaXServidorVO>();
		try {
			Statement statement = connection.getConnection().createStatement();
			ResultSet res = statement.executeQuery("SELECT * FROM jugadorxperiodoxmapaxservidor");

			while (res.next()) {
				jugadores.add(new JugadorXPeriodoXMapaXServidorVO(res.getInt("idJugador"), res
						.getInt("idMapa"), res
						.getInt("idServidor"), res
						.getString("inicio"),res
						.getString("fin"),res
						.getInt("ganador")
						));
			}
			res.close();
			statement.close();
//			connection.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"no se pudo consultar la batalla\n" + e);
		}
		return jugadores;
	}
	
	/**
	 * permite borrar una tupla en la tabla jugadorxperiodoxmapaxservidor
	 * 
	 * @param DbConnection connection
	 * @param int idJugador
	 * @param int idMapa
	 * @paran int idServidor
	 * @param Date inicio
	 * @param Date fin
	 * @param int ganador
	 * @return void
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void borrar(DbConnection connection, int idJugador, String inicio)
			throws SQLException, ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			statement.executeUpdate("DELETE FROM jugadorxperiodoxmapaxservidor WHERE idJugador = " + idJugador + "AND inicio = " + inicio);
			statement.close();
//			connection.close();
		} catch (SQLException e) {
			System.out.println("Error" + e);
		}
	}
	
	/**
	 * permite modificar una tupla en la tabla jugadorxperiodoxmapaxservidor
	 * 
	 * @param DbConnection
	 *            connection
	 * @param int id
	 * @param int idMapa
	 * @param idServidor
	 * @param String inicio
	 * @param String fin
	 * @return void
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public void modificar(DbConnection connection, int idJugador, String inicio) throws SQLException,
			ClassNotFoundException {
		try {
			Statement statement = connection.getConnection().createStatement();
			ResultSet res = statement
					.executeQuery("SELECT * FROM jugadorxperiodoxmapaxservidor WHERE idjugador = " + idJugador + " AND inicio = " + inicio);
			
			while (res.next()) {
				System.out.println("IdJugador: " + res.getInt("idJugador") + ", idMapa: "
						+ res.getInt("idMapa") + ", idServidor: "
						+ res.getInt("idServidor") + ", Inicio: "
						+ res.getString("inicio") + ", Fin: "
						+ res.getString("fin") + ", Ganador: "
						+ res.getInt("ganador"));
			}
			System.out
					.println("Introduce el nombre de el campo que quieres cambiar: ");
			System.out
					.println("idJugador, idMapa, idServidor, inicio, fin, ganador");
			Scanner sc = new Scanner(System.in);
			String columna = sc.nextLine();
			if (columna.equals("idJugador") || columna.equals("idMapa")
					|| columna.equals("idServidor") || columna.equals("inicio")) {
				int index = res.findColumn(columna);
				if (index == 1 || index == 2 || index == 3 || index == 6) {
					System.out
							.println("Introdce el entero por el que quieres modificarlo: ");
					int valor = sc.nextInt();
					statement.executeUpdate("UPDATE jugadorxperiodoxmapaxservidor SET " + columna
							+ " = " + valor + " WHERE idjugador = " + idJugador + " AND inicio = " + inicio);
				} else {
					System.out
							.println("Introduce el string por el que quieres modificarlo: ");
					String valor = sc.nextLine();
					statement.executeUpdate("UPDATE jugadorxperiodoxmapaxservidor SET " + columna
							+ " = \"" + valor + "\" WHERE idjugador = " + idJugador + " AND inicio = " + inicio);
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