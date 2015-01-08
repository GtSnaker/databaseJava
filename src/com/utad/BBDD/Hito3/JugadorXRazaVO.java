package com.utad.BBDD.Hito3;
import java.sql.Date;
import java.sql.SQLException;

/**
 * clase que casa con la estructura de la tabla jugadorxraza
 * 
 */

public class JugadorXRazaVO {
	private int id;
	private int nombre;
	private int ganadas;
	private int perdidas;
	
	public JugadorXRazaVO(){
		id = -1;
		nombre = -1;
		ganadas = -1;
		perdidas = -1;
	}

	public JugadorXRazaVO(int id, int nombre, int ganadas, int perdidas) {
		super();
		this.id = id;
		this.ganadas = ganadas;
		this.nombre = nombre;
		this.perdidas = perdidas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public int getGanadas() {
		return ganadas;
	}

	public void setGanadas(int ganadas) {
		this.ganadas = ganadas;
	}

	public int getPerdidas() {
		return perdidas;
	}

	public void setPerdidas(int perdidas) {
		this.perdidas = perdidas;
	}

	
	
	
	
	
}