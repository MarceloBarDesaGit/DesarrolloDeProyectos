package datos;


public class Periodo {
	private int idPeriodo;              // PK 100
	private String detallePeriodo;      //   Mensual / Bimestral / Cuatrimestral / Semestral / Anual / Simple Eliminación
	private Campeonato cgoCampeonato; // (NO va en el Constructor)  Campeonato Senior 2019 - Campeonato Libre - 20119 - Campeonato Veterano 2019
	
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
		this.detallePeriodo = detallePeriodo;
	}

	//------ SET <..> ------
	public Campeonato getCgoCampeonato() {
		return cgoCampeonato;
	}
	public void setCgoCampeonato(Campeonato cgoCampeonato) {
		this.cgoCampeonato = cgoCampeonato;
	}
//-------------------------------------
//tostring
	@Override
	public String toString() {
		return "Periodo: ID [ " + idPeriodo + " ] Periodo: " + detallePeriodo;
	}
	
//---------------------	
}//Fin Periodo
