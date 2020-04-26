package datos;

import java.util.Set;

public class Categoria {

	private int idCategoria;    // PK con cod___
	private String Categoria;
	private Set<Zona> cgoZona;  // FK con cgo___ 

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
		return "Categoria [ " + idCategoria + "] - " + Categoria;
	}

//------------------------
}// Fin Categoria
