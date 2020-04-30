package datos;

import java.time.LocalDate;

public class Cliente extends Persona {
	private int idCliente;
	private String descripcionCliente;
	//-----------------
	private char controlCliente;         // A  B  M
	private LocalDate fechaCtrlCliente;  // 26/04/20
//-------------------------------------
//Constructores
	public Cliente() {}  // SIEMPRE HAY que implementar el contructor VACIO

	// IMPORTANTE:  NUNCA VA EL  id  --> En el constructor por ser autoincrementable
	public Cliente(long dni, String nombre, String apellido, LocalDate fechaNacimiento,
			LocalDate fechaDeAlta, int edad, String username, String password,
			String descripcionCliente, char controlCliente, LocalDate fechaCtrlCliente) { 
		super(dni, nombre, apellido, fechaNacimiento, fechaDeAlta, edad, username, password);
		this.descripcionCliente = descripcionCliente;
		// ----------
		this.controlCliente = 'A';
		this.fechaCtrlCliente = LocalDate.now();
	}
	
//-------------------------------------
//Getter y Setter
	public int getIdCliente() {
		return idCliente;
	}

 // SIEMPRE VA protected, el ID ----> para que NO SEA modificado
	protected void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	//--------
	
	public String getDescripcionCliente() {
		return descripcionCliente;
	}

	public void setDescripcionClienteo(String descripcionCliente) {
		this.descripcionCliente = descripcionCliente;
	}
	
    //--------- CONTROL ----------------	
	public char getControlCliente() {
		return controlCliente;
	}

	public void setControlCliente(char controlCliente) {
		this.controlCliente = controlCliente;
	}

	public LocalDate getFechaCtrlCliente() {
		return fechaCtrlCliente;
	}

	public void setFechaCtrlCliente(LocalDate fechaCtrlCliente) {
		this.fechaCtrlCliente = fechaCtrlCliente;
	}	
//-------------------------------------
//tostring		
	@Override
	public String toString() {
		String estadoClien = "";
		switch (this.getControlCliente()) {
		case 'A':
			estadoClien = "Agregado";
			break;
		case 'B':
			estadoClien = "Eliminado";
			break;
		case 'M':
			estadoClien = "Modificado";
			break;
		default:
			break;
		}
		return "Cliente [Id.: " + idCliente 
			+ "      \nDescripción del Cliente: " + descripcionCliente
			+ "      \nEstado: " + estadoClien + " -  " + funciones.Funciones.traerFechaCorta(getFechaCtrlCliente());	
	}

	
	
//-----------------
}// Fin Cliente
