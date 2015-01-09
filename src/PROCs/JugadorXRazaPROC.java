package PROCs;

import ENUMs.Raza;

public class JugadorXRazaPROC {
	private Raza nombreRaza;
	private String nombreJugador;
	private int victorias;
	private int derrotas;
	
	public JugadorXRazaPROC(){
		this.nombreRaza = null;
		this.nombreJugador = "null";
		this.victorias = -1;
		this.derrotas = -1;
	}
	
	public JugadorXRazaPROC(Raza nombreRaza, String nombreJugador,
			int victorias, int derrotas) {
		super();
		this.nombreRaza = nombreRaza;
		this.nombreJugador = nombreJugador;
		this.victorias = victorias;
		this.derrotas = derrotas;
	}

	public Raza getNombreRaza() {
		return nombreRaza;
	}

	public void setNombreRaza(Raza nombreRaza) {
		this.nombreRaza = nombreRaza;
	}

	public String getNombreJugador() {
		return nombreJugador;
	}

	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}

	public int getVictorias() {
		return victorias;
	}

	public void setVictorias(int victorias) {
		this.victorias = victorias;
	}

	public int getDerrotas() {
		return derrotas;
	}

	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}
	
	
}
