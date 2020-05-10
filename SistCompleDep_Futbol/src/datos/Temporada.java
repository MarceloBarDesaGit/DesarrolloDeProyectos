package datos;

import java.util.Set;

public class Temporada {
	private int idTemporada;          // PK 200
	private String descripTemporada;  //    Apertura IDA / VUENTA - Clausura IDA / VUELTA - General IDA / VUELTA - Verano IDA
	private String estacionTemporada; //    Invierno / Verano
	private Set<Campeonato> campeonato; // (NO va en el Constructor)  Campeonato Senior 2019 - Campeonato Libre - 20119 - Campeonato Veterano 2019

	//-------------------------------------
//Constructores	
	public Temporada(String descripTemporada, String estacionTemporada) {
		super();
		this.descripTemporada = descripTemporada;
		this.estacionTemporada = estacionTemporada;
	}
	
//-------------------------------------
//Getter y Setter
	public int getIdTemporada() {
		return idTemporada;
	}
	protected void setIdTemporada(int idTemporada) {
		this.idTemporada = idTemporada;
	}
	//--------
	
	public String getDescripTemporada() {
		return descripTemporada;
	}
	public void setDescripTemporada(String descripTemporada) {
		this.descripTemporada = descripTemporada;
	}
	
	public String getEstacionTemporada() {
		return estacionTemporada;
	}
	public void setEstacionTemporada(String estacionTemporada) {
		this.estacionTemporada = estacionTemporada;
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
		return "Temporada: ID [ " + idTemporada + " ] Descripción: " + descripTemporada
				+ " - Estación: " + estacionTemporada;
	}
	
//---------------------	
}//Fin Temporada
