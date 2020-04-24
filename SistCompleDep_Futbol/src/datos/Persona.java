package datos;

import java.time.LocalDate;

public class Persona {
	private int idPersona;
	private String dni;
	private String nombre;
	private String apellido;
	private LocalDate fechaNacimiento;
	private LocalDate fechaDeAlta;
    private int edad;
	private String username;
	private String password;

//-------------------------------------
//Constructores	
	public Persona() {}
	
	public Persona(String dni, String nombre, String apellido, LocalDate fechaNacimiento,
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
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
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
		return "Persona [idPersona=" + idPersona + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", fechaNacimiento=" + fechaNacimiento + ", fechaDeAlta=" + fechaDeAlta + ", edad=" + edad
				+ ", username=" + username + ", password=" + password + "]";
	}
	
	
	
	
	
//-----------------
}//Fin Persona
