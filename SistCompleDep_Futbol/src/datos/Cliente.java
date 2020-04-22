package datos;

import java.time.LocalDate;

import funciones.Funciones;

public class Cliente {
	private long idCliente;
	private String apellido;
	private String nombre;
	private int dni;
	private LocalDate fechaDeNacimiento ;
	private boolean baja;

	
//-------------------------------------
//Constructor
	public Cliente() { 	   // SIEMPRE HAY que implementar el contructor VACIO
		
	}
	
	// IMPORTANTE:  NUNCA VA EL  id  --> En el constructor por ser autoincrementable
	public Cliente(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento) { 
		super();
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.baja = false;
	}
	
//-------------------------------------
//Getter y Setter
	public long getIdCliente() {
		return idCliente;
	}

 // SIEMPRE VA protected, el ID ----> para que NO SEA modificado
	protected void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public boolean isBaja() {
		return baja;
	}

	public void setBaja(boolean baja) {
		this.baja = baja;
	}
	
//-------------------------------------
//tostring		
	@Override
	public String toString() {
		return "Cliente [Id.: " + idCliente + " - Apellido= y Nombre: " + apellido + ", " + nombre + " - DNI: " + dni 
				+ "  F.de Nacimiento: " + funciones.Funciones.traerFechaCorta(fechaDeNacimiento) + " - " + baja + "]";
	}

	
	
//-----------------
}// Fin Cliente
