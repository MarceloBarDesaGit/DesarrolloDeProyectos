package datos;

import java.time.LocalDate;

public class Campeonato {
	private int idCampeonato;             // PK 25
	private String descripCampeonato;     //    Liga Aylen Senior
    private LocalDate fechaCampeonato;    //    25/10/20	
    private Torneo cgoTorneo;             //    Torneo Liga Aylen Bco. Frances
	private Zona cgoZona;				  //    Senior - Libre - Veterano - Empresa 
	private Categoria cgoCategoria;		  //    Senior A B C - Libre A B C - Veterano A B C - Empresa A B C - Colegio A B C
    private Temporada cgoTemporada;       //	Apertura IDA / VUENTA - Clausura IDA / VUELTA - General IDA / VUELTA - Verano IDA
	private Periodo cgoPeriodo;           //    Cuatrimestral / Semestral / Anual
//-------------------------------------
//Constructores
	public Campeonato() {}
		
	public Campeonato(int idCampeonato, String descripCampeonato, LocalDate fechaCampeonato, Torneo cgoTorneo,
			Zona cgoZona, Categoria cgoCategoria, Temporada cgoTemporada, Periodo cgoPeriodo) {
		super();
		this.idCampeonato = idCampeonato;
		this.descripCampeonato = descripCampeonato;
		this.fechaCampeonato = fechaCampeonato;
		this.cgoTorneo = cgoTorneo;
		this.cgoZona = cgoZona;
		this.cgoCategoria = cgoCategoria;
		this.cgoTemporada = cgoTemporada;
		this.cgoPeriodo = cgoPeriodo;
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

	public LocalDate getFechaCampeonato() {
		return fechaCampeonato;
	}
	public void setFechaCampeonato(LocalDate fechaCampeonato) {
		this.fechaCampeonato = fechaCampeonato;
	}	
	
    public Torneo getCgoTorneo() {
		return cgoTorneo;
	}
	public void setCgoTorneo(Torneo cgoTorneo) {
		this.cgoTorneo = cgoTorneo;
	}
	
	public Zona getCgoZona() {
		return cgoZona;
	}

	public void setCgoZona(Zona cgoZona) {
		this.cgoZona = cgoZona;
	}

	public Categoria getCgoCategoria() {
		return cgoCategoria;
	}

	public void setCgoCategoria(Categoria cgoCategoria) {
		this.cgoCategoria = cgoCategoria;
	}

	public Temporada getCgoTemporada() {
		return cgoTemporada;
	}

	public void setCgoTemporada(Temporada cgoTemporada) {
		this.cgoTemporada = cgoTemporada;
	}

	public Periodo getCgoPeriodo() {
		return cgoPeriodo;
	}

	public void setCgoPeriodo(Periodo cgoPeriodo) {
		this.cgoPeriodo = cgoPeriodo;
	}

	//-------------------------------------
//tostring
	@Override
	public String toString() {
		return "Campeonato: ID [ " + idCampeonato + " ] " + descripCampeonato 
				+ "      \nFecha del Campeonato: " + fechaCampeonato;
	}

	//-----------------
}//Fin Campeonato
