package VOs;

import ENUMs.Raza;

public class RazaVO {
	private Raza raza;
	
	public RazaVO(){
		raza = null;
	}
	
	public RazaVO(Raza raza) {
		super();
		this.raza = raza;
	}

	public Raza getRaza() {
		return raza;
	}

	public void setRaza(Raza raza) {
		this.raza = raza;
	}

}
