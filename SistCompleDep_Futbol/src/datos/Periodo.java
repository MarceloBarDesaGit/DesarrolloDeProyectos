package datos;

import java.util.Set;

public class Periodo {
	private int idPeriodo;              // PK 100
	private String detallePeriodo;      //   Mensual / Bimestral / Cuatrimestral / Semestral / Anual / Simple Eliminación
	private Set<Campeonato> campeonato; // (NO va en el Constructor)  Campeonato Senior 2019 - Campeonato Libre - 20119 - Campeonato Veterano 2019
	
	//-------------------------------------
//Constructores
	public Periodo() {}
	
	public Periodo(String detallePeriodo) {
		super();
		this.detallePeriodo = detallePeriodo;
	}
	//-------------------------------------
	//Getter y Setter
	public int getIdPeriodo() {
		return idPeriodo;
	}
	protected void setIdPeriodo(int idPeriodo) {
		this.idPeriodo = idPeriodo;
	}
	//-----
	public String getDetallePeriodo() {
		return detallePeriodo;
	}
	public void setDetallePeriodo(String detallePeriodo) {
		detallePeriodo = detallePeriodo;
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
		return "Periodo: ID [ " + idPeriodo + " ] Periodo: " + detallePeriodo;
	}
	
//---------------------	
}//Fin Periodo
