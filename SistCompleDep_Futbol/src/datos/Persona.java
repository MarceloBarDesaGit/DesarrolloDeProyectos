package datos;

import java.time.LocalDate;

public class Persona {
	private int idPersona;             //PK 1354
	private long dni;                    // 12345678
	private String nombre;               // Marcelo
	private String apellido;             // Barbieri
	private LocalDate fechaNacimiento;   // 25/04/63
	private LocalDate fechaDeAlta;       // 26/04/20
    private int edad;                    // 56
	private String username;             // MarceloBar  
	private String password;             // 1234MEB

//-------------------------------------
//Constructores	
	public Persona() {}
	
	public Persona(long dni, String nombre, String apellido, LocalDate fechaNacimiento,
			LocalDate fechaDeAlta, int edad, String username, String password) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaDeAlta = fechaDeAlta;
		this.edad = edad;
		this.username = username;
		this.password = password;
	}
	
//-------------------------------------
//Getter y Setter	
	public int getIdPersona() {
		return idPersona;
	}
	protected void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	//-----------
	public long getDni() {
		return dni;
	}
	public void setDni(long dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public LocalDate getFechaDeAlta() {
		return fechaDeAlta;
	}
	public void setFechaDeAlta(LocalDate fechaDeAlta) {
		this.fechaDeAlta = fechaDeAlta;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

//-------------------------------------
//tostring

	@Override
	public String toString() {
		return "Persona:  ID[ " + idPersona + " ] DNI: " + dni + " Nombre y Apellido: " + nombre + " " + apellido 
				+ ", Fecha de Nacimiento:" + fechaNacimiento + " -  Edad: " + edad
				+ "      \nFecha de Alta:" + fechaDeAlta + " - Username: " + username + " - Password: " + password;
	}
	
	
	
	
	
//-----------------
}//Fin Persona
