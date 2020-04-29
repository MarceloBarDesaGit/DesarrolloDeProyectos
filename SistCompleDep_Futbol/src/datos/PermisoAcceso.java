package datos;

public class PermisoAcceso {
	private int idPermisoAcceso;
	private String descripcionPAcceso;
	
	public PermisoAcceso() {
		
	}

	public PermisoAcceso(int idPermisoAcceso, String descripcionPAcceso) {
		super();
		this.idPermisoAcceso = idPermisoAcceso;
		this.descripcionPAcceso = descripcionPAcceso;
	}

	public int getIdPermisoAcceso() {
		return idPermisoAcceso;
	}

	protected void setIdPermisoAcceso(int idPermisoAcceso) {
		this.idPermisoAcceso = idPermisoAcceso;
	}

	public String getDescripcionPAcceso() {
		return descripcionPAcceso;
	}

	public void setDescripcionPAcceso(String descripcionPAcceso) {
		this.descripcionPAcceso = descripcionPAcceso;
	}
	
	
}
