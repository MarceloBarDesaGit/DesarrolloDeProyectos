package datos;

public class Periodo {
	private int idPeriodo;          // PK
	private String DetallePeriodo;  //   Mensual / Bimestral / Cuatrimestral / Semestral / Anual / Simple Eliminación
	
//-------------------------------------
//Constructores
	public Periodo() {}
	public Periodo(String detallePeriodo) {
		super();
		DetallePeriodo = detallePeriodo;
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
		return DetallePeriodo;
	}
	public void setDetallePeriodo(String detallePeriodo) {
		DetallePeriodo = detallePeriodo;
	}

//-------------------------------------
//tostring
	@Override
	public String toString() {
		return "Periodo: ID [ " + idPeriodo + " ] Periodo: " + DetallePeriodo;
	}
	
//---------------------	
}//Fin Periodo
