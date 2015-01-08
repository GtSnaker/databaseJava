package com.utad.BBDD.Hito3;

public class LigaVO {
	int id;
	Liga liga;
	String icono;
	
	public LigaVO(int id, Liga liga, String icono) {
		super();
		this.id = id;
		this.liga = liga;
		this.icono = icono;
	}

	public LigaVO() {
		id = -1;
		liga = null;
		icono = "null";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Liga getLiga() {
		return liga;
	}

	public void setLiga(Liga liga) {
		this.liga = liga;
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

}
