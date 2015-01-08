package com.utad.BBDD.Hito3;
import java.sql.Date;
import java.sql.SQLException;

/**
 * clase que casa con la estructura de la tabla jugadorxtorneo
 * 
 */

public class JugadorXTorneoVO {
	private int id;
	private String nombre;
	
	public JugadorXTorneoVO(){
		id = -1;
		nombre = "null";
	}

	public JugadorXTorneoVO(int idJugador, String nombre) {
		super();
		this.id = idJugador;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
	
}