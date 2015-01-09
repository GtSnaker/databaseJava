package VOs;
import java.sql.Date;
import java.sql.SQLException;

/**
 * clase que casa con la estructura de la tabla jugadorxservidor
 * 
 */

public class JugadorXServidorVO {
	private int idJugador;
	private int idServidor;
	private String inicio;
	private String fin;
	
	public JugadorXServidorVO(){
		idJugador = -1;
		idServidor = -1;
		inicio = null;
		fin = null;
	}

	public JugadorXServidorVO(int idJugador, int idServidor, String inicio, String fin) {
		super();
		this.idJugador = idJugador;
		this.idServidor = idServidor;
		this.inicio = inicio;
		this.fin = fin;
	}

	public int getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}

	public int getIdServidor() {
		return idServidor;
	}

	public void setIdServidor(int idServidor) {
		this.idServidor = idServidor;
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