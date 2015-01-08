package com.utad.BBDD.Hito3;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;
/**
 * clase que llama a todos los metodos borrar de cada una de las clases DAO
 * 
 * @see *DAO
 */
public class BorrarTablas {
	
	public static void borrarJugador(DbConnection connection) throws ClassNotFoundException, SQLException {
		JugadorDAO miJugadorDAO = new JugadorDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el id de el jugador que quieres eliminar: ");
		int id = sc.nextInt();
		miJugadorDAO.borrar(connection, id);
		System.out.println("Se ha borrado al jugador con id: " + id + " exitosamente.");
	}
}
