package datos;

import java.time.LocalDate;

public class Arbitro extends Persona {
	private int idArbitro;           // PK 40
	private long celuArbitro;        //    1150364587
 	//-----------------
	private char controlArbitro;         // A  B  M
	private LocalDate fechaCtrlArbitro;  // 26/04/20

//-------------------------------------
//Constructores

	public Arbitro() {}

	public Arbitro(long dni, String nombre, String apellido, LocalDate fechaNacimiento, LocalDate fechaDeAlta,
			int edad, String username, String password, 
			long celuArbitro, char controlArbitro, LocalDate fechaCtrlArbitro) {
		super(dni, nombre, apellido, fechaNacimiento, fechaDeAlta, edad, username, password);
		this.celuArbitro = celuArbitro;
		// ----------
		this.controlArbitro = 'A';
		this.fechaCtrlArbitro = LocalDate.now();
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

	public long getCeluArbitro() {
		return celuArbitro;
	}

	public void setCeluArbitro(long celuArbitro) {
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
		+ "      \nID: [ " + idArbitro + " ] - Celular: " + celuArbitro
		+ "      \nEstado: " + estadoArb + " -  " + funciones.Funciones.traerFechaCorta(getFechaCtrlArbitro());	
	}
	
	
//----------------
}// Fin Arbitro
