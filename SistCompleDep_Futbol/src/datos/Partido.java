package datos;

import java.time.LocalDate;
import java.util.Set;

public class Partido {
	private int idPartido;                // PK con cgo____  187          
	private int jornadaCampPartido;       //                 8
	private LocalDate fechaPartido;       //                 26/04/2020
	private Set<Campeonato> campeonato;   // Relación UaU    Apertura IDA
	private Set<Torneo> torneo;           // Relación UaU    Torneo Liga Aylen Bco. Frances 
	private Set<Categoria> categoria;     // Relación UaU    Senior    / Libre / Veteranos / Empresa / Colegios
	private Set<CanchaHora> canchaHora;   // Relación UaU    Aylen 1 - 09:00
	private Set<Equipo> equipoLocPartido; // Relación UaU    Equipo AAA
	private int resultadoLocPartido;      //                 3       
	private Set<Equipo> equipoVisPartido; // Relación UaU    Equipo BBB
	private int resultadoVisPartido;      //                 1
	private Arbitro cgoArbitroPartido;    // Relación UaU    40 (Juan Quiroz)
	private Set<Sancion> sanciones;       // 1  Roja directa por emppjon al arbitro por parte del jugador del equipoLoc, partido indirigible. suspendo a los 40m 2T
//	private String articEquipoLoc;        // Art. 4  / 1A /Art. 10b
//	private String articEquipoVis;        // Art. 4  / 1A /Art. 10b
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
	public Set<Campeonato> getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Set<Campeonato> campeonato) {
		this.campeonato = campeonato;
	}

	public Set<Torneo> getTorneo() {
		return torneo;
	}

	public void setTorneo(Set<Torneo> torneo) {
		this.torneo = torneo;
	}

	public Set<Categoria> getCategoria() {
		return categoria;
	}

	public void setCategoria(Set<Categoria> categoria) {
		this.categoria = categoria;
	}
	public Set<CanchaHora> getCanchaHora() {
		return canchaHora;
	}
	public void setCanchaHora(Set<CanchaHora> canchaHora) {
		this.canchaHora = canchaHora;
	}

	public Set<Equipo> getEquipoLocPartido() {
		return equipoLocPartido;
	}

	public void setEquipoLocPartido(Set<Equipo> equipoLocPartido) {
		this.equipoLocPartido = equipoLocPartido;
	}

	public int getResultadoLocPartido() {
		return resultadoLocPartido;
	}

	public void setResultadoLocPartido(int resultadoLocPartido) {
		this.resultadoLocPartido = resultadoLocPartido;
	}

	public Set<Equipo> getEquipoVisPartido() {
		return equipoVisPartido;
	}

	public void setEquipoVisPartido(Set<Equipo> equipoVisPartido) {
		this.equipoVisPartido = equipoVisPartido;
	}

	public int getResultadoVisPartido() {
		return resultadoVisPartido;
	}

	public void setResultadoVisPartido(int resultadoVisPartido) {
		this.resultadoVisPartido = resultadoVisPartido;
	}
	
	public Arbitro getCgoArbitroPartido() {
		return cgoArbitroPartido;
	}

	public void setCgoArbitroPartido(Arbitro cgoArbitroPartido) {
		this.cgoArbitroPartido = cgoArbitroPartido;	
	}	

	public Set<Sancion> getSanciones() {
		return sanciones;
	}

	public void setSanciones(Set<Sancion> sanciones) {
		this.sanciones = sanciones;
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
