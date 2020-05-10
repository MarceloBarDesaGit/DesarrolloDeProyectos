package datos;

public class Sancion {
	private int idSancion;
	private Jugador cgoJugador;
	private String informeArbitroSanc;
	private int cantFechasDeSuspencion;
	private String cantX; // X / XX / XXX / XXXX (art.18) / XXXXX (Art.99 de por vida)

//-------------------------------------
//Constructores
	public Sancion() {
	}

	public Sancion(int idSancion, Jugador cgoJugador, String informeArbitroSanc, int cantFechasDeSuspencion,
			Partido cgoPartido, String cantX) {
		super();
		this.idSancion = idSancion;
		this.cgoJugador = cgoJugador;
		this.informeArbitroSanc = informeArbitroSanc;
		this.cantFechasDeSuspencion = cantFechasDeSuspencion;
		this.cantX = cantX;
	}

//-------------------------------------
//Getter y Setter
	public int getIdSancion() {
		return idSancion;
	}

	protected void setIdSancion(int idSancion) {
		this.idSancion = idSancion;
	}

//-----------
	public Jugador getCgoJugador() {
		return cgoJugador;
	}

	public void setCgoJugador(Jugador cgoJugador) {
		this.cgoJugador = cgoJugador;
	}

	public String getInformeArbitroSanc() {
		return informeArbitroSanc;
	}

	public void setInformeArbitroSanc(String informeArbitroSanc) {
		this.informeArbitroSanc = informeArbitroSanc;
	}

	public int getCantFechasDeSuspencion() {
		return cantFechasDeSuspencion;
	}

	public void setCantFechasDeSuspencion(int cantFechasDeSuspencion) {
		this.cantFechasDeSuspencion = cantFechasDeSuspencion;
	}

	public String getCantX() {
		return cantX;
	}

	public void setCantX(String cantX) {
		this.cantX = cantX;
	}

//-------------------------------------
//tostring	
	@Override
	public String toString() {
		return "Sancion [idSancion=" + idSancion + ", cgoJugador=" + cgoJugador + ", informeArbitroSanc="
				+ informeArbitroSanc + ", cantFechasDeSuspencion=" + cantFechasDeSuspencion 
				+ ", cantX=" + cantX + "]";
	}

//----------------
}// Fin Sancion
