package com.utad.BBDD.Hito3;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.io.*;
import com.mysql.jdbc.Connection;

public class DbConnection {
	static String db = null;
	static String login = null;
	static String password = null;
	static String url = null;

	java.sql.Connection connection = null;

	public DbConnection() throws ClassNotFoundException, SQLException {
		boolean conectado = false;
		while (!conectado) {
			try {
				db = "starcraft";
				login = null;
				Scanner sc = new Scanner(System.in);
				System.out.println("Intro User name:");
				login = sc.nextLine();
				password = null;
				System.out.println("Intro Password:");
				sc = new Scanner(System.in);
				password = sc.nextLine();
				url = "jdbc:mysql://localhost/" + db;

				Class.forName("com.mysql.jdbc.Driver");

				connection = DriverManager.getConnection(url, login, password);

				if (connection != null) {
					conectado = true;
					System.out.println("Connection to db: " + db + " on...");
				}
			} catch (SQLException e) {
				System.out.println("Error connecting: " + e);
			}
		}
	}

	public java.sql.Connection getConnection() {
		return connection;
	}

	public void close() {
		connection = null;
	}
}
