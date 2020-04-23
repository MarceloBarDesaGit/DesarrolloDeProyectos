package datos;

public class Categoria {

	private int idCategoria;
	private int codCategoria; // PK las PK son cod_____
	private String Categoria;
	private int cgoZona; // FK las FK son cgo_____

//-------------------------------------
//Constructores
	public Categoria() {
	}

	public Categoria(int idCategoria, int codCategoria, String categoria, int cgoZona) {
		super();
		this.idCategoria = idCategoria;
		this.codCategoria = codCategoria;
		Categoria = categoria;
		this.cgoZona = cgoZona;
	}

//-------------------------------------
//Getter y Setter
	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public int getCodCategoria() {
		return codCategoria;
	}

	protected void setCodCategoria(int codCategoria) {
		this.codCategoria = codCategoria;
	}

//-----------
	public String getCategoria() {
		return Categoria;
	}

	public void setCategoria(String categoria) {
		Categoria = categoria;
	}

	public int getCgoZona() {
		return cgoZona;
	}

	public void setCgoZona(int cgoZona) {
		this.cgoZona = cgoZona;
	}

//-------------------------------------
//tostring	
	@Override
	public String toString() {
		return "Categoria [ " + idCategoria + "]  Codigo de Categoria:" + codCategoria + "  -  " + Categoria
				+ "  Codigo de la Zona: " + cgoZona;
	}

//------------------------
}// Fin Categoria
