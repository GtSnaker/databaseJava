package com.utad.BBDD.Hito3;
import java.sql.Date;
import java.sql.SQLException;

/**
 * clase que casa con la estructura de la tabla jugador
 * 
 */
public class JugadorVO {
	private int id;
	private String nombre;
	private String apellido;
	private Date edad;
	private String pais;
	private String mail;
	private String battletag;
	private String password;
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private int liga;
	
	public JugadorVO (){
		id = -1;
		nombre = "null";
		apellido = "null";
		edad = null;
		pais = "null";
		mail = "null";
		battletag = "null";
		password = "null";
		liga = -1;
	}

	public JugadorVO(int id, String nombre, String apellido, Date edad,
			String pais, String mail, String battletag, String password,  int liga) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.pais = pais;
		this.mail = mail;
		this.battletag = battletag;
		this.password = password;
		this.liga = liga;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getEdad() {
		return edad;
	}

	public void setEdad(Date edad) {
		this.edad = edad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getBattletag() {
		return battletag;
	}

	public void setBattletag(String battletag) {
		this.battletag = battletag;
	}

	public int getLiga() {
		return liga;
	}

	public void setLiga(int liga) {
		this.liga = liga;
	}
	
	
}
