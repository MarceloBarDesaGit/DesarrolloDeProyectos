package datos;

import java.time.LocalDate;
//import java.util.Set;         // debo importar cuando uso Set<Equipo>

public class Jugador extends Persona {
	private int idJugador;               // PK  120   
    private int golesJugador;            //     15
    private int tarjAmaJugador;          //     3
    private int tarjRojaJugador;         //     0
	private Equipo cgoEquipo;            // FK  Relacion UaU
	//-----------------
	private char controlJugador;         //     A
	private LocalDate fechaCtrlJugador;  //     19/04/20 Solo para las Altas


	//-------------------------------------
//Constructores

	public Jugador() {}
	
	public Jugador(long dni, String nombre, String apellido, LocalDate fechaNacimiento, LocalDate fechaDeAlta,
			int edad, String username, String password, 
			int golesJugador, int tarjAmaJugador, int tarjRojaJugador, Equipo equipo,
			char controlJugador, LocalDate fechaCtrlJugador) {
		super(dni, nombre, apellido, fechaNacimiento, fechaDeAlta, edad, username, password);
		this.golesJugador = golesJugador;
		this.tarjAmaJugador = tarjAmaJugador;
		this.tarjRojaJugador = tarjRojaJugador;
	 //----------
		this.controlJugador = 'A';
		this.fechaCtrlJugador = LocalDate.now();
	}

//-------------------------------------
//Getter y Setter
	public int getIdJugador() {
		return idJugador;
	}

	protected void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}
	//----

	public int getGolesJugador() {
		return golesJugador;
	}

	public void setGolesJugador(int golesJugador) {
		this.golesJugador = golesJugador;
	}

	public int getTarjAmaJugador() {
		return tarjAmaJugador;
	}

	public void setTarjAmaJugador(int tarjAmaJugador) {
		this.tarjAmaJugador = tarjAmaJugador;
	}

	public int getTarjRojaJugador() {
		return tarjRojaJugador;
	}

	public void setTarjRojaJugador(int tarjRojaJugador) {
		this.tarjRojaJugador = tarjRojaJugador;
	}

	public Equipo getCgoEquipo() {
		return cgoEquipo;
	}

	public void setCgoEquipo(Equipo cgoEquipo) {
		this.cgoEquipo = cgoEquipo;
	}

 //--------- CONTROL ----------------
	public char getControlJugador() {
		return controlJugador;
	}

	public void setControlJugador(char controlJugador) {
		this.controlJugador = controlJugador;
	}

	public LocalDate getFechaCtrlJugador() {
		return fechaCtrlJugador;
	}

	public void setFechaCtrlJugador(LocalDate fechaCtrlJugador) {
		this.fechaCtrlJugador = fechaCtrlJugador;
	}
	
//-------------------------------------
//tostring	
	@Override
	public String toString() {
		String estadoJug = "";
		switch (this.getControlJugador()) {
		case 'A':
			estadoJug = "Agregado";
			break;
		case 'B':
			estadoJug = "Eliminado";
			break;
		case 'M':
			estadoJug = "Modificado";
			break;
		default:
			break;
		}
		return "Jugador: " + super.toString() 
				+ "      \nID: [ " + idJugador + " ]"
				+ " Goles: " + golesJugador + ", Tarjetas Amarillas: " + tarjAmaJugador + " Tarjetas Rojas: "
				+ tarjRojaJugador + " N�mero de Equipo: " + cgoEquipo
				+ "      \nEstado: " + estadoJug + " -  " + funciones.Funciones.traerFechaCorta(getFechaCtrlJugador());	
	}

//	@Override
//	public boolean equals(Object o) {
//		// Comparo los productos por id
//		return this.idProducto == ((Producto) o).getIdProducto();
//	}
	
//-----------------
}// Fin Jugador
