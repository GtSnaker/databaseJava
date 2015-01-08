package com.utad.BBDD.Hito3;
import java.sql.Date;
import java.sql.SQLException;

/**
 * clase que casa con la estructura de la tabla jugadorxjugador
 * 
 */

public class JugadorXJugadorVO {
	private int id;
	private int id2;
	
	public JugadorXJugadorVO(){
		id = -1;
		id2 = -1;
	}

	public JugadorXJugadorVO(int id, int id2) {
		super();
		this.id = id;
		this.id2 = id2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getId2() {
		return id2;
	}

	public void setId2(int id) {
		this.id2 = id;
	}
	
	
}