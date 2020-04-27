package datos;

import java.time.LocalDate;
import java.util.Set;

public class Arbitro extends Persona {
	private int idArbitro;           // PK 40
	private String nomreArbitro;     //    Juan
	private String apellidoArbitro;  //    Quiroz
	private int celuArbitro;         //    1150364587
	//-----------------
	private char controlArbitro;         // A        B  M
	private LocalDate fechaCtrlArbitro;  // 26/04/20
	private LocalDate fechaModifArbitro; // Fecha de Modificaión para Baja y Modificaciones	

//-------------------------------------
//Constructores

	public Arbitro() {
	}

	public Arbitro(long dni, String nombre, String apellido, LocalDate fechaNacimiento, LocalDate fechaDeAlta,
			int edad, String username, String password, 
			String nomreArbitro, String apellidoArbitro, int celuArbitro) {
		super(dni, nombre, apellido, fechaNacimiento, fechaDeAlta, edad, username, password);
		this.nomreArbitro = nomreArbitro;
		this.apellidoArbitro = apellidoArbitro;
		this.celuArbitro = celuArbitro;
		// ----------
		this.controlArbitro = 'A';
		this.fechaCtrlArbitro = LocalDate.now();
		this.fechaModifArbitro = LocalDate.now();
	}
//-------------------------------------
//Getter y Setter

	public int getIdArbitro() {
		return idArbitro;
	}

	protected void setIdArbitro(int idArbitro) {
		this.idArbitro = idArbitro;
	}
	//-------
	public String getNomreArbitro() {
		return nomreArbitro;
	}

	public void setNomreArbitro(String nomreArbitro) {
		this.nomreArbitro = nomreArbitro;
	}

	public String getApellidoArbitro() {
		return apellidoArbitro;
	}

	public void setApellidoArbitro(String apellidoArbitro) {
		this.apellidoArbitro = apellidoArbitro;
	}

	public int getCeluArbitro() {
		return celuArbitro;
	}

	public void setCeluArbitro(int celuArbitro) {
		this.celuArbitro = celuArbitro;
	}
	
	//--------- CONTROL ----------------
	public char getControlArbitro() {
		return controlArbitro;
	}

	public void setControlArbitro(char controlArbitro) {
		this.controlArbitro = controlArbitro;
	}

	public LocalDate getFechaCtrlArbitro() {
		return fechaCtrlArbitro;
	}

	public void setFechaCtrlArbitro(LocalDate fechaCtrlArbitro) {
		this.fechaCtrlArbitro = fechaCtrlArbitro;
	}

	public LocalDate getFechaModifArbitro() {
		return fechaModifArbitro;
	}

	public void setFechaModifArbitro(LocalDate fechaModifArbitro) {
		this.fechaModifArbitro = fechaModifArbitro;
	}
	
//-------------------------------------
//tostring	
	@Override
	public String toString() {
		String estadoArb = "";
		switch (this.getControlArbitro()) {
		case 'A':
			estadoArb = "Agregado";
			break;
		case 'B':
			estadoArb = "Eliminado";
			break;
		case 'M':
			estadoArb = "Modificado";
			break;
		default:
			break;
		}		
		return "Arbitro: " + super.toString() 
		+ "      \nID: [ " + idArbitro + " ] Nombre y Apellido: " + nomreArbitro + " " + apellidoArbitro + " - Celular: " + celuArbitro
		+ "      \nEstado: " + estadoArb + " -  " + funciones.Funciones.traerFechaCorta(getFechaCtrlArbitro()) 
		+ "      \nModificación de datos: "	+ funciones.Funciones.traerFechaCorta(getFechaModifArbitro());		
	}
	
	
//----------------
}// Fin Arbitro
