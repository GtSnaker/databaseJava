package com.utad.BBDD.Hito3;

public class JugadorXLogroVO {
	private int idJugador;
	private int idLogro;
	
	public int getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}

	public int getIdLogro() {
		return idLogro;
	}

	public void setIdLogro(int idLogro) {
		this.idLogro = idLogro;
	}

	public JugadorXLogroVO(){
		idJugador = -1;
		idLogro = -1;
	}
	
	public JugadorXLogroVO(int idJugador, int idLogro) {
		super();
		this.idJugador = idJugador;
		this.idLogro = idLogro;
	}
}
