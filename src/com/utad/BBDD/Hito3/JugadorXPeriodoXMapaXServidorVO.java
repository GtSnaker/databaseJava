package com.utad.BBDD.Hito3;
import java.sql.Date;
import java.sql.SQLException;

/**
 * clase que casa con la estructura de la tabla jugadorxperiodoxmapaxservidor
 * 
 */

public class JugadorXPeriodoXMapaXServidorVO {
	private int idJugador;
	private int idMapa;
	private int idServidor;
	private Date inicio;
	private Date fin;
	private int ganador;
	
	public JugadorXPeriodoXMapaXServidorVO(){
		idJugador = -1;
		idMapa = -1;
		idServidor = -1;
		inicio = null;
		fin = null;
		ganador = -1;
	}

	public JugadorXPeriodoXMapaXServidorVO(int idJugador,int idMapa,int idServidor,Date inicio,Date fin,int ganador) {
		super();
		this.idJugador = idJugador;
		this.idMapa = idMapa;
		this.idServidor = idServidor;
		this.inicio = inicio;
		this.fin = fin;
		this.ganador = ganador;
	}

	public int getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}

	public int getIdMapa() {
		return idMapa;
	}

	public void setIdMapa(int idMapa) {
		this.idMapa = idMapa;
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

	public int getGanador() {
		return ganador;
	}

	public void setGanador(int ganador) {
		this.ganador = ganador;
	}

	
	
	
	
}