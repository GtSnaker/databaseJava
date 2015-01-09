package VOs;
import java.sql.Date;
import java.sql.SQLException;

/**
 * clase que casa con la estructura de la tabla torneo
 * 
 */

public class TorneoVO {
	private String nombre;
	private int liga;
	private String premio;
	private String inicio;
	private String fin;
	
	public TorneoVO(){
		nombre = "null";
		liga = -1;
		premio = "null";
		inicio = null;
		fin = null;
	}

	public TorneoVO(String nombre, int liga, String premio, String inicio, String fin) {
		super();
		this.nombre =  nombre;
		this.liga = liga;
		this.premio= premio;
		this.inicio = inicio;
		this.fin = fin;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getLiga() {
		return liga;
	}

	public void setLiga(int liga) {
		this.liga = liga;
	}

	public String getPremio() {
		return premio;
	}

	public void setPremio(String premio) {
		this.premio = premio;
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