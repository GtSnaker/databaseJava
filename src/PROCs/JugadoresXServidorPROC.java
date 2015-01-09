package PROCs;

public class JugadoresXServidorPROC {
	private int idServidor;
	private String nombreServidor;
	private String paisServidor;
	private int idJugador;
	private String battletag;
	
	public int getIdServidor() {
		return idServidor;
	}

	public void setIdServidor(int idServidor) {
		this.idServidor = idServidor;
	}

	public String getNombreServidor() {
		return nombreServidor;
	}

	public void setNombreServidor(String nombreServidor) {
		this.nombreServidor = nombreServidor;
	}

	public String getPaisServidor() {
		return paisServidor;
	}

	public void setPaisServidor(String paisServidor) {
		this.paisServidor = paisServidor;
	}

	public int getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}

	public String getBattletag() {
		return battletag;
	}

	public void setBattletag(String battletag) {
		this.battletag = battletag;
	}
	
	public JugadoresXServidorPROC(){
		idServidor = -1;
		nombreServidor = "null";
		paisServidor = "null";
		idJugador = -1;
		battletag = "null";
	}
	
	public JugadoresXServidorPROC(int idServidor, String nombreServidor,
			String paisServidor, int idJugador, String battletag) {
		super();
		this.idServidor = idServidor;
		this.nombreServidor = nombreServidor;
		this.paisServidor = paisServidor;
		this.idJugador = idJugador;
		this.battletag = battletag;
	}
}
