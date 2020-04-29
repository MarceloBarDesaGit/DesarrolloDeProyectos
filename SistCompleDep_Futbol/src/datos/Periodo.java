package datos;

public class Periodo {
	private int idPeriodo;          // PK
	private String detallePeriodo;  //   Mensual / Bimestral / Cuatrimestral / Semestral / Anual / Simple Eliminación
	
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

//-------------------------------------
//tostring
	@Override
	public String toString() {
		return "Periodo: ID [ " + idPeriodo + " ] Periodo: " + detallePeriodo;
	}
	
//---------------------	
}//Fin Periodo
