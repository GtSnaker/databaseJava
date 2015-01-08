package com.utad.BBDD.Hito3;
import java.sql.Timestamp;

public class PeriodoVO {
	private Timestamp inicio;
	private Timestamp fin;
	
	public Timestamp getInicio() {
		return inicio;
	}

	public void setInicio(Timestamp inicio) {
		this.inicio = inicio;
	}

	public Timestamp getFin() {
		return fin;
	}

	public void setFin(Timestamp fin) {
		this.fin = fin;
	}

	public PeriodoVO(){
		inicio = null;
		fin = null;
	}
	
	public PeriodoVO(Timestamp inicio, Timestamp fin) {
		super();
		this.inicio = inicio;
		this.fin = fin;
	}
}
