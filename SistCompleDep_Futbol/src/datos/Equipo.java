package datos;

import java.time.LocalDate;
import java.util.Set;

public class Equipo {
	private int idEquipo;              //  PK con cod_____
	private String nombreEquipo;
	private LocalDate fechaEquipoAlta;
	private int puntosEquipoRnk;       //  8 (Valor Amarilla 1 - Roja 3)
	private Partido cgopartido;        // FK Relación UaM  (va en el Constructor)
	private Set<Jugador> jugador;      // (NO va en el Constructor)
	//---
	private char controlEquipo;			// A B M
	private LocalDate fechaCtrlEquipo;  // xx/xx/xx
//-------------------------------------
//Constructores
	public Equipo() {} 



	// IMPORTANTE:  NUNCA VA EL  id  
//	--> En el constructor por ser autoincrementable
	public Equipo(String nombreEquipo, Partido cgopartido, LocalDate fechaEquipoAlta,int puntosEquipoRnk) {
		super();
		this.nombreEquipo = nombreEquipo;
		this.cgopartido= cgopartido;
		this.fechaEquipoAlta = fechaEquipoAlta;
		this.puntosEquipoRnk = puntosEquipoRnk;
		// ----------
		this.controlEquipo = 'A';
		this.fechaCtrlEquipo = LocalDate.now();
	}

//-------------------------------------
//Getter y Setter
	public int getIdEquipo() {
		return idEquipo;
	}
  // SIEMPRE VA protected
	protected void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}
  //----------------
	public String getNombreEquipo() {
		return nombreEquipo;
	}
	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}
	public LocalDate getFechaEquipoAlta() {
		return fechaEquipoAlta;
	}
	public void setFechaEquipoAlta(LocalDate fechaEquipoAlta) {
		this.fechaEquipoAlta = fechaEquipoAlta;
	}
	
	public int getPuntosEquipoRnk() {
		return puntosEquipoRnk;
	}

	public void setPuntosEquipoRnk(int puntosEquipoRnk) {
		this.puntosEquipoRnk = puntosEquipoRnk;
	}
	
	//------ Set<Clase> ------
	public Partido getCgopartido() {
		return cgopartido;
	}
	public void setCgopartidoo(Partido cgopartido) {
		this.cgopartido = cgopartido;
	}	
	//-------	
	public Set<Jugador> getJugador() {
		return jugador;
	}
	public void setCgojugador(Set<Jugador> jugador) {
		this.jugador = jugador;
	}

//--------- CONTROL ---------------
	public char getControlEquipo() {
		return controlEquipo;
	}
	public void setControlEquipo(char controlEquipo) {
		this.controlEquipo = controlEquipo;
	}
	public LocalDate getFechaCtrlEquipo() {
		return fechaCtrlEquipo;
	}
	public void setFechaCtrlEquipo(LocalDate fechaCtrlEquipo) {
		this.fechaCtrlEquipo = fechaCtrlEquipo;
	}
	
//-------------------------------------
//tostring	
	@Override
	public String toString() {
		String estadoEqui = "";
		switch (this.getControlEquipo()) {
		case 'A':
			estadoEqui = "Agregado";
			break;
		case 'B':
			estadoEqui = "Eliminado";
			break;
		case 'M':
			estadoEqui = "Modificado";
			break;
		default:
			break;
		}
		return "Equipo [ " + idEquipo + "] - " + nombreEquipo
				+ "      \nPartido:" + cgopartido
	            + "      \nFecha de Alta: " + funciones.Funciones.traerFechaCorta(fechaEquipoAlta)
                + "      \nEatado Actual: [ " + estadoEqui + " - " 
	            + funciones.Funciones.traerFechaCorta(getFechaCtrlEquipo()) + " ]";
	}

	
//------------------	
}// Fin Equipo
