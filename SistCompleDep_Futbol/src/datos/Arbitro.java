package datos;

import java.time.LocalDate;
import java.util.Set;

public class Arbitro extends Persona {
	private int idArbitro;
	private String nomreArbitro;
	private String apellidoArbitro;
	private int celuArbitro;
	private Set<Partido> partidos;
//-------------------------------------
//Constructores

	public Arbitro() {
	}

	public Arbitro(String dni, String nombre, String apellido, LocalDate fechaNacimiento, LocalDate fechaDeAlta,
			int edad, String username, String password, String nomreArbitro, String apellidoArbitro, int celuArbitro) {
		super(dni, nombre, apellido, fechaNacimiento, fechaDeAlta, edad, username, password);
		this.nomreArbitro = nomreArbitro;
		this.apellidoArbitro = apellidoArbitro;
		this.celuArbitro = celuArbitro;
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
	//-------------
	public Set<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(Set<Partido> partidos) {
		this.partidos = partidos;
	}
	
//-------------------------------------
//tostring	
	@Override
	public String toString() {
		return "Arbitro: " + super.toString() 
		+ "      \nID: [ " + idArbitro + " ] Nombre y Apellido: " + nomreArbitro + " " + apellidoArbitro + " - Celula: " + celuArbitro;
	}
//----------------
}// Fin Arbitro
