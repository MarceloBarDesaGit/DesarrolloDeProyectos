package datos;

import java.time.LocalDate;

public class Torneo {
	private int idTorneo;             // PK   10 
	private String detalleTorneo;     //      Torneo Liga Aylen Bco. Frances  
	private LocalDate fechaTorneo;    //      20/10/20
	private String sponsorTorneo;     //      Bco. Frances

	//-------------------------------------
//Constructores
	public Torneo() {}
	
	public Torneo(String detalleTorneo, LocalDate fechaTorneo, String sponsorTorneo) {
		super();
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

//-------------------------------------
//tostring
	
	@Override
	public String toString() {
		return "Torneo: ID [ " + idTorneo + " ]  " + detalleTorneo + " - " + fechaTorneo 
				+ "      \nSponsor del Torneo:" + sponsorTorneo;
	}
	
//-----------------
}//Fin Torneo
