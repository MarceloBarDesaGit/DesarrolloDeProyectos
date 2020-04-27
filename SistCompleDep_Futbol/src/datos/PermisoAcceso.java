package datos;

public class PermisoAcceso {
	private int idPermisoAcceso;
	private String descripcion;
	
	public PermisoAcceso() {
		
	}

	public PermisoAcceso(int idPermisoAcceso, String descripcion) {
		super();
		this.idPermisoAcceso = idPermisoAcceso;
		this.descripcion = descripcion;
	}

	public int getIdPermisoAcceso() {
		return idPermisoAcceso;
	}

	protected void setIdPermisoAcceso(int idPermisoAcceso) {
		this.idPermisoAcceso = idPermisoAcceso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
