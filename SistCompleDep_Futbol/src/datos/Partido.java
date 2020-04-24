package datos;

import java.time.LocalDate;
import java.util.Set;

public class Partido {
	private int idPartido;
	private int codPartido;               // PK las PK son cgo_____
	private int jornadaCampPartido;
	private LocalDate fechaPartido;
	private Set<Campeonato> cgocampeonato;   // Relación UaU
	private Set<Torneo> cgotorneo;           // Relación UaU
	private Set<Categoria> cgocategoria;     // Relación UaU
	private Set<CanchaHora> cgocanchaHora;   // Relación UaU
	private Set<Equipo> cgoequipoLocPArtido; // Relación UaU
	private int resultadoLocPartido;
	private Set<Equipo> cgoequipoVisPArtido; // Relación UaU
	private int resultadoVisPartido;
	
//-------------------------------------
//Constructores
	public Partido() {}
	
	public Partido(int idPartido, int codPartido, int jornadaCampPartido, LocalDate fechaPartido,
			int resultadoLocPartido, int resultadoVisPartido) {
		super();
		this.idPartido = idPartido;
		this.codPartido = codPartido;
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

	public void setIdPartido(int idPartido) {
		this.idPartido = idPartido;
	}

	public int getCodPartido() {
		return codPartido;
	}

	public void setCodPartido(int codPartido) {
		this.codPartido = codPartido;
	}

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

	public Set<Categoria> getCgocategoria() {
		return cgocategoria;
	}

	public void setCgocategoria(Set<Categoria> cgocategoria) {
		this.cgocategoria = cgocategoria;
	}

	public Set<CanchaHora> getCgocanchaHora() {
		return cgocanchaHora;
	}

	public void setCgocanchaHora(Set<CanchaHora> cgocanchaHora) {
		this.cgocanchaHora = cgocanchaHora;
	}

	public Set<Equipo> getCgoequipoLocPArtido() {
		return cgoequipoLocPArtido;
	}

	public void setCgoequipoLocPArtido(Set<Equipo> cgoequipoLocPArtido) {
		this.cgoequipoLocPArtido = cgoequipoLocPArtido;
	}

	public int getResultadoLocPartido() {
		return resultadoLocPartido;
	}

	public void setResultadoLocPartido(int resultadoLocPartido) {
		this.resultadoLocPartido = resultadoLocPartido;
	}

	public Set<Equipo> getCgoequipoVisPArtido() {
		return cgoequipoVisPArtido;
	}

	public void setCgoequipoVisPArtido(Set<Equipo> cgoequipoVisPArtido) {
		this.cgoequipoVisPArtido = cgoequipoVisPArtido;
	}

	public int getResultadoVisPartido() {
		return resultadoVisPartido;
	}

	public void setResultadoVisPartido(int resultadoVisPartido) {
		this.resultadoVisPartido = resultadoVisPartido;
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
		return "Partido: [ " + idPartido + "  Cod. Partido: " + codPartido + " - Jornada: " + jornadaCampPartido 
				+ " -  Fecha del Partido:" + fechaPartido
				+ " Resultado Local: ( " + resultadoLocPartido
				+ " ) -  Resultado Visitante: ( " + resultadoVisPartido + ")";
	}	
	
	
//------------------	
}// Fin Partido
