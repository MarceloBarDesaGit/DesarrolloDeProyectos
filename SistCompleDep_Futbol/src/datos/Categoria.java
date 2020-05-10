package datos;

import java.util.Set;

public class Categoria {

	private int idCategoria;            // PK con cod___ 1
	private String descripCategoria;    //    Senior A B C - Libre A B C - Veterano A B C - Empresa A B C - Colegio A B C 
	private Set<Campeonato> campeonato; // (NO va en el Constructor)  Campeonato Senior 2019 - Campeonato Libre - 20119 - Campeonato Veterano 2019

//-------------------------------------
//Constructores
	public Categoria() {
	}

	public Categoria(String descripCategoria) {
		super();
		this.descripCategoria = descripCategoria;
	}

//-------------------------------------
//Getter y Setter
	public int getIdCategoria() {
		return idCategoria;
	}

	protected void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
//-----------
	
	public String getDescripCategoria() {
		return descripCategoria;
	}
	public void setDescripCategoria(String descripCategoria) {
		this.descripCategoria = descripCategoria;
	}

	//------ SET <..> ------
	public Set<Campeonato> getCampeonato() {
		return campeonato;
	}
	public void setCampeonato(Set<Campeonato> campeonato) {
		this.campeonato = campeonato;
	}
	
//-------------------------------------
//tostring	
	@Override
	public String toString() {
		return "Categoria: ID [ " + idCategoria + " ] - " + descripCategoria;
	}

//------------------------
}// Fin Categoria
