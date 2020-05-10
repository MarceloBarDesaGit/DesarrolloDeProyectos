package datos;

import java.time.LocalDate;
import java.util.Set;

public class Torneo {
	private int idTorneo;              // PK   10 
	private String detalleTorneo;      //      Torneo Liga Aylen Bco. Frances  
	private LocalDate fechaTorneo;     //      20/10/20
	private String sponsorTorneo;      //      Bco. Frances
	private Set<Campeonato> campeonato; // (NO va en el Constructor)  Campeonato Senior 2019 - Campeonato Libre - 20119 - Campeonato Veterano 2019
  //----
	// Set <...> : define que no podemos tener elementos repetidos. Puede estar o no ordenada.
	//Sirve para acceder a una colección sin elementos repetidos (hay que saber 
	//cuándo dos objetos son considerados iguales; para ello se usan equals() y hashcode();). 

//-------------------------------------
//Constructores
	public Torneo() {}
	
	public Torneo(int idTorneo, String detalleTorneo, LocalDate fechaTorneo, String sponsorTorneo) {
		super();
		this.idTorneo = idTorneo;
		this.detalleTorneo = detalleTorneo;
		this.fechaTorneo = fechaTorneo;
		this.sponsorTorneo = sponsorTorneo;
	}
	
//-------------------------------------
//Getter y Setter
	public int getIdTorneo() {
		return idTorneo;
	}

	protected void setIdTorneo(int idTorneo) {
		this.idTorneo = idTorneo;
	}
	//---------
	public String getDetalleTorneo() {
		return detalleTorneo;
	}
	public void setDetalleTorneo(String detalleTorneo) {
		this.detalleTorneo = detalleTorneo;
	}

	public LocalDate getFechaTorneo() {
		return fechaTorneo;
	}

	public void setFechaTorneo(LocalDate fechaTorneo) {
		this.fechaTorneo = fechaTorneo;
	}

	public String getSponsorTorneo() {
		return sponsorTorneo;
	}
	public void setSponsorTorneo(String sponsorTorneo) {
		this.sponsorTorneo = sponsorTorneo;
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
		return "Torneo: ID [ " + idTorneo + " ]  " + detalleTorneo
				+ "      \nFecha de Inicio del Torneo:" + fechaTorneo
				+ "      \nSponsor del Torneo:" + sponsorTorneo;
	}
	
//-----------------
}//Fin Torneo
