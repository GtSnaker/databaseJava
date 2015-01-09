package com.utad.BBDD.Hito3;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import _Tablas.BorrarTablas;
import _Tablas.CrearTablas;
import _Tablas.ModificarTablas;
import _Tablas.VerTablas;

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
						VerTablas.elegir(connection);
						break;
					case 2:
						System.out.println("Fallos en las consultas rapidas...");
						break;
					case 3:
						CrearTablas.elegir(connection);		
						break;
					case 4:
						BorrarTablas.elegir(connection);
						break;
					case 5:
						ModificarTablas.elegir(connection);
						break;
					case 6:
						Procedimientos.elegir(connection);
						break;
					case 7:
						System.out.println("Buenas noches, bendisiones :)");
						opcion = 0;
						connection.close();
						break;
					}
				}
			} catch (NumberFormatException ex) {
				System.out.println("Introduce un numero por favor...");
			}
		}
	}	
}
