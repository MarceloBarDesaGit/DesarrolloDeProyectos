package datos;

import java.time.LocalDate;
import java.util.Set;

public class Campeonato {
	private int idCampeonato;                // PK 25
	private String descripCampeonato;        //    detalle completo delcampeonato
	private Set<Temporada> cgoTemporada;     //    Apertura IDA / VUENTA - Clausura IDA / VUELTA - General IDA / VUELTA - Verano IDA
    private LocalDate fechaCampeonato;       //    25/10/20
	private Set<Periodo> cgoPeriodo;         //    Cuatrimestral / Semestral / Anual
	
//-------------------------------------
//Constructores
	public Campeonato() {}
	
	public Campeonato(String descripCampeonato, LocalDate fechaCampeonato) {
		super();
		this.descripCampeonato = descripCampeonato;
		this.fechaCampeonato = fechaCampeonato;
	}
	
//-------------------------------------
//Getter y Setter

	public int getIdCampeonato() {
		return idCampeonato;
	}

	protected void setIdCampeonato(int idCampeonato) {
		this.idCampeonato = idCampeonato;
	}
	//------
	public String getDescripCampeonato() {
		return descripCampeonato;
	}

	public void setDescripCampeonato(String descripCampeonato) {
		this.descripCampeonato = descripCampeonato;
	}

	public Set<Temporada> getCgoTemporada() {
		return cgoTemporada;
	}

	public void setCgoTemporada(Set<Temporada> cgoTemporada) {
		this.cgoTemporada = cgoTemporada;
	}

	public LocalDate getFechaCampeonato() {
		return fechaCampeonato;
	}

	public void setFechaCampeonato(LocalDate fechaCampeonato) {
		this.fechaCampeonato = fechaCampeonato;
	}

	public Set<Periodo> getCgoPeriodo() {
		return cgoPeriodo;
	}

	public void setCgoPeriodo(Set<Periodo> cgoPeriodo) {
		this.cgoPeriodo = cgoPeriodo;
	}
	
//-------------------------------------
//tostring

	@Override
	public String toString() {
		return "Campeonato: ID [ " + idCampeonato + " ] " + descripCampeonato + " Temporada: " + cgoTemporada
				+ "      \nFecha del Campeonato: " + fechaCampeonato + " - Periodo:" + cgoPeriodo;
	}

	//-----------------
}//Fin Campeonato
