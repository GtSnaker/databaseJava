package com.utad.BBDD.Hito3;

public class MapaVO {
	private int id;
	private String nombre;
	private String descripcion;
	private int max;
	
	public MapaVO(){
		id = -1;
		nombre = "null";
		descripcion = "null";
		max = -1;
	}

	public MapaVO(int id, String nombre, String descripcion, int max) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.max = max;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public int getMax() {
		return max;
	}


	public void setMax(int max) {
		this.max = max;
	}
}
