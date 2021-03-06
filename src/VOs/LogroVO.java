package VOs;

public class LogroVO {
	private int id;
	private String nombre;
	private String descripcion;
	
	public LogroVO(){
		id = -1;
		nombre = "null";
		descripcion = "null";
	}
	
	public LogroVO(int id, String nombre, String descripcion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
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
}
