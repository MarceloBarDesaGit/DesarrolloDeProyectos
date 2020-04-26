package datos;

public class Zona {
	private int idZona;            // PK   1     
	private String nombreZona;    //        Senior A B C - Libre A B C - Veterano A B C - Empresa A B C - Colegio A B C
	private int cgoTorneo;        // FK son cgo__
//-------------------------------------
//Constructores

	public Zona() {
	}

	public Zona(String nombreZona, int cgoTorneo) {
		super();
		this.nombreZona = nombreZona;
		this.cgoTorneo = cgoTorneo;
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
		return "Zona [ " + idZona + "] - " + nombreZona + " - Codigo de Torneo: " + cgoTorneo;
	}

}
