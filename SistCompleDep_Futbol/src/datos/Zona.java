package datos;

import java.util.Set;

public class Zona {
	private int idZona;               // PK 2     
	private String nombreZona;        // Senior - Libre - Veterano - Empresa - Colegio
	private Set<Campeonato> campeonato; // (NO va en el Constructor)  Campeonato Senior 2019 - Campeonato Libre - 20119 - Campeonato Veterano 2019
//-------------------------------------
//Constructores
	public Zona() {}

	public Zona(int idZona, String nombreZona) {
		super();
		this.idZona =idZona;
		this.nombreZona = nombreZona;
	}

//-------------------------------------
//Getter y Setter
	public int getIdZona() {
		return idZona;
	}
	protected void setIdZona(int idZona) {
		this.idZona = idZona;
	}
//--------

	public String getNombreZona() {
		return nombreZona;
	}
	public void setNombreZona(String nombreZona) {
		this.nombreZona = nombreZona;
	}

	//------ SET <..> ------
	public Set<Campeonato> getCampeonato() {
		return campeonato;
	}
	public void setCampeonato(Set<Campeonato> campeonato) {
		this.campeonato = campeonato;
	}

	//-------------------------------------
//tostring	
	@Override
	public String toString() {
		return "Zona [ " + idZona + "] - " + nombreZona;
	}

}
