package datos;

public class Zona {
	private int idZona;
	private int codZona;          // PK las PK son cod_____
	private String nombreZona;
	private int cgoTorneo;        // FK las FK son cgo_____

//-------------------------------------
//Constructores

	public Zona() {
	}

	public Zona(int idZona, int codZona, String nombreZona, int cgoTorneo) {
		super();
		this.idZona = idZona;
		this.codZona = codZona;
		this.nombreZona = nombreZona;
		this.cgoTorneo = cgoTorneo;
	}

//-------------------------------------
//Getter y Setter
	public int getIdZona() {
		return idZona;
	}

	public void setIdZona(int idZona) {
		this.idZona = idZona;
	}

	public int getCodZona() {
		return codZona;
	}

	protected void setCodZona(int codZona) {
		this.codZona = codZona;
	}
//--------

	public String getNombreZona() {
		return nombreZona;
	}

	public void setNombreZona(String nombreZona) {
		this.nombreZona = nombreZona;
	}

	public int getCgoTorneo() {
		return cgoTorneo;
	}

	public void setCgoTorneo(int cgoTorneo) {
		this.cgoTorneo = cgoTorneo;
	}

//-------------------------------------
//tostring	
	@Override
	public String toString() {
		return "Zona [ " + idZona + "] Codigo de la Zona: " + codZona + " - " + nombreZona + " - Codigo de Torneo="
				+ cgoTorneo;
	}

}
