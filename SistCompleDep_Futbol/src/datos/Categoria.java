package datos;

import java.util.Set;

public class Categoria {

	private int idCategoria;    // PK con cod___ 1
	private String Categoria;   //               Senior - Libre - Veterano - Empresa - Colegio 
	private Set<Zona> cgoZona;  // FK con cgo___ Senior A B C - Libre A B C - Veterano A B C - Empresa A B C - Colegio A B C 

//-------------------------------------
//Constructores
	public Categoria() {
	}

	public Categoria(String categoria) {
		super();
		Categoria = categoria;
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
	
	public String getCategoria() {
		return Categoria;
	}

	public void setCategoria(String categoria) {
		Categoria = categoria;
	}

	public Set<Zona> getCgoZona() {
		return cgoZona;
	}

	public void setCgoZona(Set<Zona> cgoZona) {
		this.cgoZona = cgoZona;
	}	
	
//-------------------------------------
//tostring	
	@Override
	public String toString() {
		return "Categoria: ID [ " + idCategoria + " ] - " + Categoria;
	}

//------------------------
}// Fin Categoria
