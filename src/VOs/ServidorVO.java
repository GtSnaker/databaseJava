package VOs;
import java.sql.SQLException;

/**
 * clase que casa con la estructura de la tabla servidor
 * 
 */

public class ServidorVO {
	private int id;
	private String nombre;
	private String pais;
	private int max;
	
	public ServidorVO(){
		id = -1;
		nombre = "null";
		pais= "null";
		max = -1;
	}

	public ServidorVO(int id, String nombre, String pais, int max) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pais = pais;
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

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	
	
	
	
}