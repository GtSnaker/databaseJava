package VOs;
import java.sql.Date;
import java.sql.SQLException;

import ENUMs.Raza;

/**
 * clase que casa con la estructura de la tabla jugadorxraza
 * 
 */

public class JugadorXRazaVO {
	private int id;
	private Raza raza;
	private int ganadas;
	private int perdidas;
	
	public JugadorXRazaVO(){
		id = -1;
		raza = null;
		ganadas = -1;
		perdidas = -1;
	}

	public JugadorXRazaVO(int id, Raza raza, int ganadas, int perdidas) {
		super();
		this.id = id;
		this.ganadas = ganadas;
		this.raza = raza;
		this.perdidas = perdidas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Raza getRaza() {
		return raza;
	}

	public void setRaza(Raza raza) {
		this.raza = raza;
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