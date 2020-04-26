package datos;

public class Temporada {
	private int idTemporada;          // PK
	private String descripTemporada;  //    Apertura IDA / VUENTA - Clausura IDA / VUELTA - General IDA / VUELTA - Verano IDA
	private String estacionTemporada; //    Invierno / Verano
	
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
	
//-------------------------------------
//tostring
	@Override
	public String toString() {
		return "Temporada: ID [ " + idTemporada + " ] Descripción: " + descripTemporada
				+ " - Estación: " + estacionTemporada;
	}
	
//---------------------	
}//Fin Temporada
