package datos;

public class Rol {
	private int idRol;					      //PK  1
	private String descripcionRol;            //    Contadora / AdmSistemas / AdmCobranza / Canchero / BuffetChef / buffetVta1 / BuffetVta2
	private PermisoAcceso cgoPermisoAc;   // (NO va en el Constructor)  Control Total - Gestión Total -  Autorización - Autenticación - Creación - Búsqueda - Lectura - Escritura - Eliminar 
	
//-------------------------------------
//Constructores	
	public Rol() {}

	public Rol(int idRol, String descripcionRol, PermisoAcceso cgoPermisoAc) {
		super();
		this.idRol = 0;
		this.descripcionRol = descripcionRol;
		this.cgoPermisoAc = cgoPermisoAc;
	}

//-------------------------------------
//Getter y Setter	
	public int getIdRol() {
		return idRol;
	}

	protected void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	//--------
	
	public String getDescripcionRol() {
		return descripcionRol;
	}

	public void setDescripcionRol(String descripcionRol) {
		this.descripcionRol = descripcionRol;
	}

	public PermisoAcceso getCgoPermisoAc() {
		return cgoPermisoAc;
	}

	public void setCgoPermisoAc(PermisoAcceso cgoPermisoAc) {
		this.cgoPermisoAc = cgoPermisoAc;
	}

	//-------------------------------------
//tostring
	@Override
	public String toString() {
		return "Rol: [ " + idRol + " ] - Descripcion: " + descripcionRol;
	}
	
	
//------------
}//Fin Rol
