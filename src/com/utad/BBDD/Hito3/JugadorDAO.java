package com.utad.BBDD.Hito3;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class JugadorDAO {

	public void registrar(JugadorVO fila, DbConnection connection)
			throws SQLException, ClassNotFoundException {
		// PreparedStatement statement = connection
		// .getConnection()
		// .prepareStatement(
		// "insert into jugador values (-1, \"null\", \"null\", null, \"null\", \"null\", \"null\", \"null\", -1)");
		// statement.setInt(1, fila.getId());
		// statement.setString(2, fila.getNombre());
		// statement.setString(3, fila.getApellido());
		// statement.setDate(4, fila.getEdad());
		// statement.setString(5, fila.getPais());
		// statement.setString(6, fila.getMail());
		// statement.setString(7, fila.getBattletag());
		// statement.setString(8, fila.getPassword());
		// statement.setInt(9, fila.getLiga());
		// statement.close();
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
			connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null,
					"No se pudo registrar al jugador");
		}
	}

	/**
	 * permite consultar el empleado asociado al documento enviado como
	 * parametro
	 * 
	 * @param documento
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<JugadorVO> verTablaJugador(DbConnection connection)
			throws SQLException, ClassNotFoundException {
		ArrayList<JugadorVO> jugadores = new ArrayList<JugadorVO>();
		try {
			Statement statement = connection.getConnection().createStatement();
			ResultSet res = statement.executeQuery("SELECT * FROM jugador");

			while (res.next()) {
				jugadores.add(new JugadorVO(res.getInt("id"), res
						.getString("nombre"), res.getString("apellido"), res
						.getDate("edad"), res.getString("pais"), res
						.getString("mail"), res.getString("battletag"), res
						.getString("password"), res.getInt("liga")));
			}
			res.close();
			statement.close();
			connection.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"no se pudo consultar la Persona\n" + e);
		}
		return jugadores;
	}
}
