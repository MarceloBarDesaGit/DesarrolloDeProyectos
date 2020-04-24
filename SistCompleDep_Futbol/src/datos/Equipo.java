package datos;

import java.time.LocalDate;
import java.util.Set;

public class Equipo {
	private int idEquipo;
	private int codEquipo;				 // PK   las PK son cod_____
	private String nombreEquipo;
	private Set<Zona> cgoZona;           // FK   las FK son cgo_____ 
	private LocalDate fechaEquipoAlta;
	private Set<Jugador> cgojugador;     // Relación UaM
	//---
	private char controlEquipo;
	private LocalDate fechaCtrlEquipo;   // Solo para las Bajas
	private LocalDate fechaModifEquipo;  // Fecha de Modificaión para Altas y Modificaciones
//-------------------------------------
//Constructores
	public Equipo() {}  // SIEMPRE HAY que implementar el contructor VACIO

// IMPORTANTE:  NUNCA VA EL  id  --> En el constructor por ser autoincrementable
	public Equipo(int codEquipo, String nombreEquipo, int cgoZona, LocalDate fechaEquipoAlta) {
		super();
		this.codEquipo = codEquipo;
		this.nombreEquipo = nombreEquipo;
		this.fechaEquipoAlta = fechaEquipoAlta;
		// ----------
		this.controlEquipo = 'A';
		this.fechaCtrlEquipo = LocalDate.now();
		this.fechaModifEquipo = LocalDate.now();
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

	public int getCodEquipo() {
		return codEquipo;
	}

	public void setCodEquipo(int codEquipo) {
		this.codEquipo = codEquipo;
	}

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
	
	//------ Set<Clase> ------

	public Set<Zona> getCgoZona() {
		return cgoZona;
	}

	public void setCgoZona(Set<Zona> cgoZona) {
		this.cgoZona = cgoZona;
	}	
		
	public Set<Jugador> getCgojugador() {
		return cgojugador;
	}

	public void setCgojugador(Set<Jugador> cgojugador) {
		this.cgojugador = cgojugador;
	}

//--------- CONTROL ----------------
	public LocalDate getFechaModifEquipo() {
		return fechaModifEquipo;
	}

	public void setFechaModifEquipo(LocalDate fechaModifEquipo) {
		this.fechaModifEquipo = fechaModifEquipo;
	}

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
		return "Equipo [ " + idEquipo + "]  Codigo del Equipo:" + codEquipo + " - " + nombreEquipo
				+ "      \ncodZona:" + cgoZona
	            + "      \nFecha de Alta: " + funciones.Funciones.traerFechaCorta(fechaEquipoAlta)
                + "      \nEatado Actual: [ " + estadoEqui + " - " + funciones.Funciones.traerFechaCorta(getFechaCtrlEquipo()) + " ]"
                + "      \nFecha de Modificación: [ " + funciones.Funciones.traerFechaCorta(getFechaModifEquipo()) +" ]";
	}

	
	
	
	
	
//------------------	
}// Fin Equipo
