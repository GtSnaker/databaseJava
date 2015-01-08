package com.utad.BBDD.Hito3;
import java.sql.Date;
import java.sql.SQLException;

/**
 * clase que casa con la estructura de la tabla jugadorxservidor
 * 
 */

public class JugadorXServidorVO {
	private int idJugador;
	private int idServidor;
	private Date inicio;
	private Date fin;
	
	public JugadorXServidorVO(){
		idJugador = -1;
		idServidor = -1;
		inicio = null;
		fin = null;
	}

	public JugadorXServidorVO(int idJugador, int idServidor, Date inicio, Date fin) {
		super();
		this.idJugador = idJugador;
		this.idServidor = idServidor;
		this.inicio = inicio;
		this.fin = fin;
	}

	public int getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}

	public int getIdServidor() {
		return idServidor;
	}

	public void setIdServidor(int idServidor) {
		this.idServidor = idServidor;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	
	
}