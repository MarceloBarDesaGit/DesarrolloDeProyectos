package datos;

import java.time.LocalDate;
import java.util.Set;

public class Partido {
	private int idPartido;                   // PK con cgo____  187          
	private int jornadaCampPartido;          //                 8
	private LocalDate fechaPartido;          //                 26/04/2020
	private Set<Campeonato> cgocampeonato;   // Relación UaU    Apertura IDA
	private Set<Torneo> cgotorneo;           // Relación UaU    Torneo Liga Aylen Bco. Frances 
	private Set<Categoria> cgoCategoria;     // Relación UaU    Senior    / Libre / Veteranos / Empresa / Colegios
	private Set<CanchaHora> cgoCanchaHora;   // Relación UaU    Aylen 1 - 09:00
	private Set<Equipo> cgoEquipoLocPartido; // Relación UaU    Equipo AAA
	private int resultadoLocPartido;         //                 3       
	private Set<Equipo> cgoEquipoVisPartido; // Relación UaU    Equipo BBB
	private int resultadoVisPartido;         //                 1
	private Set<Arbitro> cgoArbitroPartido;  // Relación UaU    40 (Juan Quiroz)
	private Set<Sancion> cgoSanciones;       // 1  Roja directa por emppjon al arbitro por parte del jugador del equipoLoc, partido indirigible. suspendo a los 40m 2T
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
	public Set<CanchaHora> getCgoCanchaHora() {
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

	public Set<Sancion> getCgoSanciones() {
		return cgoSanciones;
	}

	public void setCgoSanciones(Set<Sancion> cgoSanciones) {
		this.cgoSanciones = cgoSanciones;
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
