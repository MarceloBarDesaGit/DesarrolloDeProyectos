package datos;

import java.time.LocalTime;

public class CanchaHora {
	private int idCanchaHora;       // PK son cgo_____ 
	private String detalleCancha;   // Aylen 1 Aylen 2 Aylen 3 Aylen 4 Aylen 5 Aylen 6
	private LocalTime detalleHora;  // 09:00 / 10:30 / 12:00 / 13:00
	private String diaCampeonato;   // Sábado / Domingo
	private String turnoCampeonato; // Mañana / Tarde
	private Partido cgoPartido;     // 187  (va en el constructor)

//-------------------------------------
//Constructores
	public CanchaHora() {}
			
	public CanchaHora(String detalleCancha, LocalTime detalleHora, 
				String diaCampeonato, String turnoCampeonato, Partido cgoPartido) {
		super();
		this.detalleCancha = detalleCancha;
		this.detalleHora = detalleHora;
		this.diaCampeonato = diaCampeonato;
		this.turnoCampeonato = turnoCampeonato;
		this.cgoPartido = cgoPartido;
	}

//-------------------------------------
//Getter y Setter
	public int getIdCanchaHora() {
		return idCanchaHora;
	}
	protected void setIdCanchaHora(int idCanchaHora) {
		this.idCanchaHora = idCanchaHora;
	}

	// ------
	public String getDetalleCancha() {
		return detalleCancha;
	}
	public void setDetalleCancha(String detalleCancha) {
		this.detalleCancha = detalleCancha;
	}

	public LocalTime getDetalleHora() {
		return detalleHora;
	}
	public void setDetalleHora(LocalTime detalleHora) {
		this.detalleHora = detalleHora;
	}

	public String getDiaCampeonato() {
		return diaCampeonato;
	}
	public void setDiaCampeonato(String diaCampeonato) {
		this.diaCampeonato = diaCampeonato;
	}
	
	public String getTurnoCampeonato() {
		return turnoCampeonato;
	}
	public void setTurnoCampeonato(String turnoCampeonato) {
		this.turnoCampeonato = turnoCampeonato;
	}

	public Partido getCgoPartido() {
		return cgoPartido;
	}
	public void setCgoPartido(Partido cgoPartido) {
		this.cgoPartido = cgoPartido;
	}

	//-------------------------------------
//tostring
	@Override
	public String toString() {
		return "Canchas y Hora ID [ " + idCanchaHora + " ] Cancha: " + detalleCancha + " - " + detalleHora
				+ " - " + diaCampeonato + " - " + turnoCampeonato;
	}

//---------------
}//Fin CanchaHora
