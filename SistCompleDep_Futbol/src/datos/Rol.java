package datos;

import java.util.HashSet;
import java.util.Set;

public class Rol {
	private int idRol;					 //PK  1
	private String descripcionRol;          //    Contadora / AdmSistemas / AdmCobranza / Canchero / BuffetChef / buffetVta1 / BuffetVta2
	private Set<PermisoAcceso> permisoRol; //    Control Total - Gestión Total -  Autorización - Autenticación - Creación - Búsqueda - Lectura - Escritura - Eliminar 
	
//-------------------------------------
//Constructores	
	public Rol() {}

	public Rol(String descripcionRol) {
		super();
		this.idRol = 0;
		this.descripcionRol = descripcionRol;
		this.permisoRol = new HashSet<PermisoAcceso>();
	}

	public Rol(String descripcionRol, Set<PermisoAcceso> permisoRol) {
		super();
		this.idRol = 0;
		this.descripcionRol = descripcionRol;
		this.permisoRol = permisoRol;
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

	public Set<PermisoAcceso> getPermisos() {
		return permisoRol;
	}

	public void setPermisoRol(Set<PermisoAcceso> permisoRol) {
		this.permisoRol = permisoRol;
	}
	
	public void agregarPermisoRol(PermisoAcceso pa) {
		this.permisoRol.add(pa);
	}

//-------------------------------------
//tostring
	@Override
	public String toString() {
		return "Rol: [ " + idRol + " ] - Descripcion: " + descripcionRol + " - Permisos: " + permisoRol;
	}
	
	
//------------
}//Fin Rol
