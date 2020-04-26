package datos;

import java.time.LocalDate;
import java.util.Set;

public class Partido {
	private int idPartido;                   // PK con cgo____  187          
	private int jornadaCampPartido;          //                 8
	private LocalDate fechaPartido;          //                 26/04/2020
	private Set<Campeonato> cgocampeonato;   // Relaci�n UaU    Apertura IDA
	private Set<Torneo> cgotorneo;           // Relaci�n UaU    Torneo Liga Aylen Bco. Frances 
	private Set<Categoria> cgoCategoria;     // Relaci�n UaU    Senior    / Libre / Veteranos / Empresa / Colegios
	private Set<CanchaHora> cgoCanchaHora;   // Relaci�n UaU    Aylen 1 - 09:00
	private Set<Equipo> cgoEquipoLocPartido; // Relaci�n UaU    Equipo AAA
	private int resultadoLocPartido;         //                 3       
	private Set<Equipo> cgoEquipoVisPartido; // Relaci�n UaU    Equipo BBB
	private int resultadoVisPartido;         //                 1
	private Set<Arbitro> cgoArbitroPartido;  // Relaci�n UaU    40 (Juan Quiroz)
//-------------------------------------
//Constructores
	public Partido() {}
	
	public Partido(int jornadaCampPartido, LocalDate fechaPartido,
			int resultadoLocPartido, int resultadoVisPartido) {
		super();
		this.jornadaCampPartido = jornadaCampPartido;
		this.fechaPartido = fechaPartido;
		this.resultadoLocPartido = resultadoLocPartido;
		this.resultadoVisPartido = resultadoVisPartido;
	}
//-------------------------------------
//Getter y Setter

	public int getIdPartido() {
		return idPartido;
	}

	protected void setIdPartido(int idPartido) {
		this.idPartido = idPartido;
	}
	//-----

	public int getJornadaCampPartido() {
		return jornadaCampPartido;
	}

	public void setJornadaCampPartido(int jornadaCampPartido) {
		this.jornadaCampPartido = jornadaCampPartido;
	}

	public LocalDate getFechaPartido() {
		return fechaPartido;
	}

	public void setFechaPartido(LocalDate fechaPartido) {
		this.fechaPartido = fechaPartido;
	}
	
  //-------------------------
	public Set<Campeonato> getCgocampeonato() {
		return cgocampeonato;
	}

	public void setCgocampeonato(Set<Campeonato> cgocampeonato) {
		this.cgocampeonato = cgocampeonato;
	}

	public Set<Torneo> getCgotorneo() {
		return cgotorneo;
	}

	public void setCgotorneo(Set<Torneo> cgotorneo) {
		this.cgotorneo = cgotorneo;
	}

	public Set<Categoria> getCgoCategoria() {
		return cgoCategoria;
	}

	public void setCgoCategoria(Set<Categoria> cgoCategoria) {
		this.cgoCategoria = cgoCategoria;
	}

	public Set<CanchaHora> getCgocanchaHora() {
		return cgoCanchaHora;
	}

	public void setCgoCanchaHora(Set<CanchaHora> cgoCanchaHora) {
		this.cgoCanchaHora = cgoCanchaHora;
	}

	public Set<Equipo> getCgoEquipoLocPartido() {
		return cgoEquipoLocPartido;
	}

	public void setCgoEquipoLocPartido(Set<Equipo> cgoEquipoLocPartido) {
		this.cgoEquipoLocPartido = cgoEquipoLocPartido;
	}

	public int getResultadoLocPartido() {
		return resultadoLocPartido;
	}

	public void setResultadoLocPartido(int resultadoLocPartido) {
		this.resultadoLocPartido = resultadoLocPartido;
	}

	public Set<Equipo> getCgoEquipoVisPartido() {
		return cgoEquipoVisPartido;
	}

	public void setCgoEquipoVisPartido(Set<Equipo> cgoEquipoVisPartido) {
		this.cgoEquipoVisPartido = cgoEquipoVisPartido;
	}

	public int getResultadoVisPartido() {
		return resultadoVisPartido;
	}

	public void setResultadoVisPartido(int resultadoVisPartido) {
		this.resultadoVisPartido = resultadoVisPartido;
	}
	
	public Set<Arbitro> getCgoArbitroPartido() {
		return cgoArbitroPartido;
	}

	public void setCgoArbitroPartido(Set<Arbitro> cgoArbitroPartido) {
		this.cgoArbitroPartido = cgoArbitroPartido;	
	}	
//-------------------------------------
//tostring	
//	@Override
//	public String toString() {
//		return "Partido [idPartido=" + idPartido + ", codPartido=" + codPartido + ", jornadaCampPartido=",
//				+ jornadaCampPartido + ", fechaPartido=" + fechaPartido + ", cgocampeonato=" + cgocampeonato
//				+ ", cgotorneo=" + cgotorneo + ", cgocategoria=" + cgocategoria + ", cgocanchaHora=" + cgocanchaHora
//				+ ", cgoequipoLocPArtido=" + cgoequipoLocPArtido + ", resultadoLocPartido=" + resultadoLocPartido
//				+ ", cgoequipoVisPArtido=" + cgoequipoVisPArtido + ", resultadoVisPartido=" + resultadoVisPartido + "]";
//	}

	@Override
	public String toString() {
		return "Partido: [ " + idPartido + " ] - Jornada Nro.: " + jornadaCampPartido + " -  Fecha del Partido:" + fechaPartido
				+ "      \nFResultado Local: ( " + resultadoLocPartido + " )"
				+ "      \nFResultado Visitante: ( " + resultadoVisPartido + ")";
	}	
	
	
//------------------	
}// Fin Partido