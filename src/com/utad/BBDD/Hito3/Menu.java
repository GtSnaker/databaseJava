package com.utad.BBDD.Hito3;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Statement;
import java.util.Scanner;
import java.sql.Date;

public class Menu {
	public static void inicializar() throws ClassNotFoundException,
			SQLException {
		DbConnection connection = new DbConnection();

		int opcion = 1;
		while (opcion != 0) {
			System.out.println("Introduce 1 para Ver Tabla");
			System.out.println("Introduce 2 para Consulta Rápida");
			System.out.println("Introduce 3 para Insertar fila en tabla");
			System.out.println("Introduce 4 para Borrar fila de tabla");
			System.out.println("Introduce 5 para Modificar fila de tabla");
			System.out
					.println("Introduce 6 para Ejecutar procedimiento almacenado");
			System.out.println("Introduce 7 para Salir de la aplicacion");
			Scanner sc = new Scanner(System.in);
			String numeroEntero = sc.nextLine();

			try {
				opcion = Integer.parseInt(numeroEntero);
				if (opcion < 1 || opcion > 7) {
					System.out.println("Solo son validos numeros del 1 al 7");
				} else {
					switch (opcion) {
					case 1:
						verJugador(connection);
						break;
					case 2:
						crearJugador(connection);
						break;
					case 3:
						break;
					case 4:
						break;
					case 5:
						break;
					case 6:
						System.out.println("caso 6");
						break;
					case 7:
						System.out.println("Buenas noches, bendisiones :)");
						opcion = 0;
						break;
					}
				}
			} catch (NumberFormatException ex) {
				System.out.println("Introduce un numero por favor...");
			}
		}
	}

	
	public static void verJugador(DbConnection connection) throws ClassNotFoundException, SQLException {
		JugadorDAO miJugadorDAO = new JugadorDAO();
		JugadorVO miJugador;
		ArrayList<JugadorVO> jugadores = miJugadorDAO.verTablaJugador(connection);
		if (jugadores.size() > 0) {
			int numero = 0;
			for (int i = 0; i < jugadores.size(); i++) {
				numero++;
				miJugador = jugadores.get(i);
				System.out.println("Id: " + miJugador.getId() + ", Nombre: " + miJugador.getNombre() + ", Apellido: " + miJugador.getApellido() + ", Edad: "+ miJugador.getEdad() + ", Pais: "+ miJugador.getPais() + ", Mail: "+ miJugador.getMail() + ", Battletag: "+ miJugador.getBattletag() + ", Password: **********" + ", Liga: "+ miJugador.getLiga());
			}
			System.out.println("");
		} else {
			JOptionPane.showMessageDialog(null, "Actualmente no "
					+ "existen registros de personas", "INFORMACIÓN",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public static void crearJugador(DbConnection connection) throws ClassNotFoundException, SQLException {
		JugadorDAO miJugadorDAO = new JugadorDAO();
		JugadorVO miJugadorVO = new JugadorVO();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce el id");
		miJugadorVO.setId(Integer.parseInt(sc.nextLine()));
		System.out.println("Introduce el nombre");
		miJugadorVO.setNombre(sc.nextLine());
		System.out.println("Introduce el apellido");
		miJugadorVO.setApellido(sc.nextLine());
		System.out.println("Introduce la edad");
		Date miDate = new Date(1991, 1, 4);
		miJugadorVO.setEdad(miDate);
		System.out.println("Introduce el pais");
		miJugadorVO.setPais(sc.nextLine());
		System.out.println("Introduce el mail");
		miJugadorVO.setMail(sc.nextLine());
		System.out.println("Introduce el battletag");
		miJugadorVO.setBattletag(sc.nextLine());
		System.out.println("Introduce el password");
		miJugadorVO.setPassword(sc.nextLine());
		System.out.println("Introduce la liga");
		miJugadorVO.setLiga(Integer.parseInt(sc.nextLine()));
		miJugadorDAO.registrar(miJugadorVO, connection);
	}
	
	
}
