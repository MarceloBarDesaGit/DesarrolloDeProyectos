package datos;

import java.util.Set;

public class PermisoAcceso {
	private int idPermisoAcceso;
	private String descripcionPAcceso;  // Control Total; tiene accedo a toda la administraci�n de los recursos.
	private Set<Rol> rol;               // (NO va en el Constructor) Control Total - Gesti�n Total -  Autorizaci�n - Autenticaci�n - Creaci�n - B�squeda - Lectura - Escritura - Eliminar 

//-------------------------------------
//Constructores	
	public PermisoAcceso() {}

	public PermisoAcceso(String descripcionPAcceso) {
		super();
		this.descripcionPAcceso = descripcionPAcceso;
	}
	
//-------------------------------------
//Getter y Setter
	public int getIdPermisoAcceso() {
		return idPermisoAcceso;
	}

	protected void setIdPermisoAcceso(int idPermisoAcceso) {
		this.idPermisoAcceso = idPermisoAcceso;
	}
	//---------
	public String getDescripcionPAcceso() {
		return descripcionPAcceso;
	}

	public void setDescripcionPAcceso(String descripcionPAcceso) {
		this.descripcionPAcceso = descripcionPAcceso;
	}
	
//------- SET<---> ---------------	
	public Set<Rol> getRol() {
		return rol;
	}
	public void setRol(Set<Rol> rol) {
		this.rol = rol;
	}

	//-------------------------------------
//tostring	
	@Override
	public String toString() {
		return "PermisoAcceso: ID [ " + idPermisoAcceso + " ] Descripci�n del Permiso:" + descripcionPAcceso;
	}

	
}
