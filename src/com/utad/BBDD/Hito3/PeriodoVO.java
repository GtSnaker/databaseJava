package com.utad.BBDD.Hito3;
import java.sql.Timestamp;

public class PeriodoVO {
	private String inicio;
	private String fin;
	
	public PeriodoVO(){
		inicio = "null";
		fin = "null";
	}
	
	public PeriodoVO(String inicio, String fin) {
		super();
		this.inicio = inicio;
		this.fin = fin;
	}

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}
	
}
