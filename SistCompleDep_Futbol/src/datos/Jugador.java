package datos;

import java.time.LocalDate;
import java.util.Set;         // debo importar cuando uso Set<Equipo>

public class Jugador extends Persona {
	private int idJugador;          //PK con cod_____	    
    private int golesJugador;
    private int tarjAmaJugador;
    private int tarjRojaJugador;
	private Set<Equipo> cgoEquipo;  //FK   las FK son cgo_____ UaU
	//-----------------
	private char controlJugador;
	private LocalDate fechaCtrlJugador;  // Solo para las Bajas
	private LocalDate fechaModifJugador; // Fecha de Modificai�n para Altas y Modificaciones

//-------------------------------------
//Constructores

	public Jugador() {}
	
public Jugador(String dni, String nombre, String apellido, LocalDate fechaNacimiento,
		LocalDate fechaDeAlta, int edad, String username, String password, 
		int golesJugador, int tarjAmaJugador, int tarjRojaJugador,
		char controlJugador, LocalDate fechaCtrlJugador, LocalDate fechaModifJugador) {
	super(dni, nombre, apellido, fechaNacimiento, fechaDeAlta, edad, username, password);
		this.golesJugador = golesJugador;
		this.tarjAmaJugador = tarjAmaJugador;
		this.tarjRojaJugador = tarjRojaJugador;
		// ----------
		this.controlJugador = 'A';
		this.fechaCtrlJugador = LocalDate.now();
		this.fechaModifJugador = LocalDate.now();		
	}

//-------------------------------------
//Getter y Setter
	public int getIdJugador() {
		return idJugador;
	}

	protected void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}
	//----

	public int getGolesJugador() {
		return golesJugador;
	}

	public void setGolesJugador(int golesJugador) {
		this.golesJugador = golesJugador;
	}

	public int getTarjAmaJugador() {
		return tarjAmaJugador;
	}

	public void setTarjAmaJugador(int tarjAmaJugador) {
		this.tarjAmaJugador = tarjAmaJugador;
	}

	public int getTarjRojaJugador() {
		return tarjRojaJugador;
	}

	public void setTarjRojaJugador(int tarjRojaJugador) {
		this.tarjRojaJugador = tarjRojaJugador;
	}

	public Set<Equipo> getCgoEquipo() {
		return cgoEquipo;
	}

	public void setCgoEquipo(Set<Equipo> cgoEquipo) {
		this.cgoEquipo = cgoEquipo;
	}
	
//--------- CONTROL ----------------
	public char getControlJugador() {
		return controlJugador;
	}

	public void setControlJugador(char controlJugador) {
		this.controlJugador = controlJugador;
	}

	public LocalDate getFechaCtrlJugador() {
		return fechaCtrlJugador;
	}

	public void setFechaCtrlJugador(LocalDate fechaCtrlJugador) {
		this.fechaCtrlJugador = fechaCtrlJugador;
	}

	public LocalDate getFechaModifJugador() {
		return fechaModifJugador;
	}

	public void setFechaModifJugador(LocalDate fechaModifJugador) {
		this.fechaModifJugador = fechaModifJugador;
	}

//-------------------------------------
//tostring	
	@Override
	public String toString() {
		String estadoJug = "";
		switch (this.getControlJugador()) {
		case 'A':
			estadoJug = "Agregado";
			break;
		case 'B':
			estadoJug = "Eliminado";
			break;
		case 'M':
			estadoJug = "Modificado";
			break;
		default:
			break;
		}
		return "Jugador: " + super.toString() + "      \nID: [ " + idJugador + " ]"
				+ "      \nGoles: " + golesJugador + ", Tarjetas Amarillas: " + tarjAmaJugador + " Tarjetas Rojas: "
				+ tarjRojaJugador + "      \nN�mero de Equipo: " + cgoEquipo + "      \nEstado: " + estadoJug + " -  "
				+ funciones.Funciones.traerFechaCorta(getFechaCtrlJugador()) + ", Modificaci�n de datos: "
				+ funciones.Funciones.traerFechaCorta(getFechaModifJugador());
	}

	
//-----------------
}// Fin Jugador