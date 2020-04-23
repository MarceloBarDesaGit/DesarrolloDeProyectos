package datos;

import java.time.LocalDate;

public class Equipo {
	private int idEquipo;
	private int codEquipo;				//PK   las PK son cod_____
	private String nombreEquipo;
	private int cgoZona;                //FK   las FK son cgo_____
	private LocalDate fechaEquipoAlta; 
//-------------------------------------
//Constructores
	public Equipo() {}  // SIEMPRE HAY que implementar el contructor VACIO

// IMPORTANTE:  NUNCA VA EL  id  --> En el constructor por ser autoincrementable
	public Equipo(int codEquipo, String nombreEquipo, int cgoZona, LocalDate fechaEquipoAlta) {
		super();
		this.codEquipo = codEquipo;
		this.nombreEquipo = nombreEquipo;
		this.fechaEquipoAlta = fechaEquipoAlta;
		this.cgoZona = cgoZona;
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

	public int getCgoZona() {
		return cgoZona;
	}

	public void setCgoZona(int cgoZona) {
		this.cgoZona = cgoZona;
	}

	public LocalDate getFechaEquipoAlta() {
		return fechaEquipoAlta;
	}

	public void setFechaEquipoAlta(LocalDate fechaEquipoAlta) {
		this.fechaEquipoAlta = fechaEquipoAlta;
	}

//-------------------------------------
//tostring	
	@Override
	public String toString() {
		return "Equipo [ " + idEquipo + "]  Codigo del Equipo:" + codEquipo + " - " + nombreEquipo
				+ "      \ncodZona:" + cgoZona
	            + "      \nFecha de Alta:" + funciones.Funciones.traerFechaCorta(fechaEquipoAlta);		
	}

}// Fin Equipo
