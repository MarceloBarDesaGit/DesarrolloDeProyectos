/*
 * 
*/

package negocio;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;

import dao.PersonaDao;
import dao.EquipoDao;
import dao.PartidoDao;
//-------
import datos.Arbitro;
import datos.Cliente;
import datos.Empleado;
import datos.Jugador;
import datos.Partido;
//------------

public class PersonaABM {

	// Patrón Singleton
	private static PersonaABM instancia = null; 

// Constructor
//---------------------------
	protected PersonaABM() {
	}

	// Generar la Instancia del metodo
	public static PersonaABM getInstance() {
		if (instancia == null)
			instancia = new PersonaABM();
		return instancia;
	}
	// Instancia para Jugadores: Eliminar y Cálculos de Tarj y Goles
		private EquipoDao daoEquipo = new EquipoDao(); 
		private PartidoDao daoPartido = new PartidoDao();
		
//------------------------------------------------
// PERSONA 
//	 	traerPersona(int idPersona)
//	  	traerPersona(long dni)
//		traerPersona(String apellido)
//------	
//	  	agregarPersona(todos los campos)
//	  	actualizarPersona(Persona persona)
//	  	eliminarPersona(int idPersona)	
//------
//	  	List<Persona> traePersona()
//------------------------------------------------	
	
//	? cuando se hace un agregar/Actualiar/Eliminar Persona como lo complemento
//			con los campos de cada clase hijo (ej. jugador)
//	? como se hace para poner los ControlJugador = 'A' y la fecha 
//			(va en ABM DATO o DAO)
//	? como armar la relacion dentro del hql porque cambia el inner
//	? donde coloco los CALCULOS
	
	
//------------------------------------------------
// CLIENTE 
// 	 	traerCliente(int idCliente)
//  	traerCliente(long dni)
//		traerCliente(String apellido)
//------	
//  	agregarCliente(todos los campos)
//  	actualizarCliente(Cliente cliente)
//  	eliminarCliente(int idCliente)	
//------
//  	List<Cliente> traeClientes()
//		List<Cliente> traerCliente(char estado)
//------------------------------------------------
	
	public Cliente traerCliente(int idCliente) {
		return PersonaDao.getInstance().traerCliente(idCliente);
	}

	public Cliente traerCliente(long dni) {
		return PersonaDao.getInstance().traerCliente(dni);
	}
	
	public Cliente traerCliente(String apellido) {
		return PersonaDao.getInstance().traerCliente(apellido);
	}
	
  //------------
//	public List<Cliente> traeCliente() {
//		return PersonaDao.getInstance().traerCliente();
//	}
//	
  //------------------------------------------------
	public int agregarCliente(long dni, String nombre, String apellido, LocalDate fechaNacimiento,
			LocalDate fechaDeAlta, int edad, String username, String password,
			String descripcionCliente, char controlCliente, LocalDate fechaCtrlCliente) { 
		int salida = 0;
		Cliente cliente = traerCliente(dni);
		if (cliente == null) {
			salida = PersonaDao.getInstance().agregarCliente(
					new Cliente(dni, nombre, apellido, fechaNacimiento, fechaDeAlta, edad, username, password,
							descripcionCliente, controlCliente, fechaCtrlCliente));
		} else {
			// Depende de lo que pida, si tirar excepción 
			// "El Empleado con el Legajo: " + legajo + " YA existe."
		}
		return salida;
	}
	//------------------------------------------------
	public void actualizarCliente(Cliente cliente) {
		Cliente cli = traerCliente(cliente.getIdCliente());
		if (cli != null) {
			PersonaDao.getInstance().actualizarCliente(cliente);
		} else {
			// Depende de lo que pida, si tirar excepción 
			// "El Cliente " + cliente + " No existe."
		}
		return;
	}
	//------------------------------------------------
	public void eliminarCliente(int idCliente) {
		Cliente cli = traerCliente(idCliente);
		if (cli != null) {
			PersonaDao.getInstance().eliminarCliente(cli);
		} else {
			// Depende de lo que pida, si tirar excepción 
			// "El Cliente con el ID: " + idCliente + " No existe."
		}
		return;
	}
	
//LISTADOS Generales
// ----------------------------
		public List<Cliente> traerCliente() {
			return PersonaDao.getInstance().traerCliente();
		}
		public List<Cliente> traerCliente(char estado) {
			return PersonaDao.getInstance().traerCliente(estado);
		}		
		
//------------------------------------------------
// EMPLEADO
//		traerEmpleado(int idEmpleado) 
//		traerEmpleado(long legajo) 
//		traerEmpleado(String apellido)
//------
//		agregarEmpleado(todos los campos)
//		actualizarEmpleado(Empleado empleado)
//		eliminarEmpleado(int idEmpleado)	
//------
//		List<Empleado> traeEmpleado()
//------------------------------------------------
	public Empleado traerEmpleado(int idEmpleado) {
		return PersonaDao.getInstance().traerEmpleado(idEmpleado);
	}

	public Empleado traerEmpleado(String legajo) {
		return PersonaDao.getInstance().traerEmpleado(legajo);
	}
	
   //----------------------------
	public int agregarEmpleado(long dni, String nombre, String apellido, LocalDate fechaNacimiento, LocalDate fechaDeAlta,
			int edad, String username, String password,
			int legajo, float sueldoBase, char controlEmpleado, LocalDate fechaCtrlEmpleado) {
		int salida = 0;
		Empleado empleado = traerEmpleado(legajo);
		if (empleado == null) {
			salida = PersonaDao.getInstance()
					.agregarEmpleado(new Empleado(dni, nombre, apellido, fechaNacimiento, fechaDeAlta, edad, username, password,
							legajo, sueldoBase, controlEmpleado, fechaCtrlEmpleado));
		} else {
			// Depende de lo que pida, si tirar excepción 
			// "El Empleado con el Legajo: " + legajo + " YA existe."
		}
		return salida;
	}

	public void actualizarEmpleado(Empleado empleado) {
		Empleado emp = traerEmpleado(empleado.getIdEmpleado());
		if (emp != null) {
			PersonaDao.getInstance().actualizarEmpleado(empleado);
		} else {
			// Depende de lo que pida, si tirar excepción 
			// "El Empleado " + empleado + " No existe."
		}
		return;
	}

	public void eliminarEmpleado(int idEmpleado) {
		Empleado emp = traerEmpleado(idEmpleado);
		if (emp != null) {
			PersonaDao.getInstance().eliminarEmpleado(emp);
		} else {
			// Depende de lo que pida, si tirar excepción 
			// "El Empleado con el ID: " + idEmpleado + " No existe."
		}
		return;
	}

//LISTADOS Generales
// ----------------------------
	public List<Empleado> traerEmpleado() {
		return PersonaDao.getInstance().traerEmpleado();
	}
	
//------------------------------------------------
//  JUGADOR
//		traerJugador(int idJugador) 
//		traerJugador(long dni) 
//		traerJugador(String apellido)
//------
//		agregarJugador(todos los campos)
//		actualizarJugador(Jugador jugador)
//		eliminarJugador(int idJugador)		
//------
//		List<Jugador> traerJugador()    
//		List<Jugador> traerJugador(char estado)
//  	List<Jugador> traerJugador(LocalDate fechaDesde, LocalDate fechaHasta)
//  	List<Jugador> traerJugador(LocalDate fechaDesde, LocalDate fechaHasta, char estado)	

//------------------------------------------------
	public Jugador traerJugador(int idJugador) {
		return PersonaDao.getInstance().traerJugador(idJugador);
	}

	public Jugador traerJugador(long dni) {
		return PersonaDao.getInstance().traerJugador(dni);
	}
	public Jugador traerJugador(String apellido) {
		return PersonaDao.getInstance().traerJugador(apellido);
	}
	
	// ----------------------------
	public int agregarJugador(Jugador j) {
		int salida = 0;
		Jugador ju = traerJugador(j.getIdJugador());
		if (ju == null) {
			salida = PersonaDao.getInstance()
					.agregarJugador(new Jugador());
			// "El jugador con el DNI: " + dni + " se dió de Alta correctamente."
		} else {
			// Depende de lo que pida, si tirar excepción
			// "El jugador con el DNI: " + dni + " YA existe."
		}
		return salida;
	}

	public void actualizarJugador(Jugador jugador) {
		Jugador jug = traerJugador(jugador.getIdJugador());
		if (jug != null) {
			PersonaDao.getInstance().actualizarJugador(jugador);
		} else {
			// Depende de lo que pida, si tirar excepción 
			// "El Jugador: " + Jugador + " No existe."
		}
		return;
	}

	//Para la Eliminación y Borrado se debe tocar Equipo, no sanciones
	// en sanciones queda hasta que lo decide el organizador.
	public void eliminarJugador(int idJugador) {
		Jugador jug = traerJugador(idJugador);
		if (jug != null) {
			PersonaDao.getInstance().eliminarJugador(jug);
		} else {
			// Depende de lo que pida, si tirar excepción 
			// "El Jugador con el ID: " + idJugador + " No existe."
		}
		return;
	}

	// Borrado Logico
	public void BorrarJugador(Jugador jugador) throws HibernateException {
		Jugador jug = traerJugador(jugador.getIdJugador());
		if (jug != null) {
			// Estado: se cambia
			// Estafo = "B"
			// FechaCtrl=xx/xx/xx			
			PersonaDao.getInstance().actualizarJugador(jugador);
			// "El Jugador: " + Jugador + " se borro de forma Lógica."
		} else {
			// Depende de lo que pida, si tirar excepción 
			// "El Jugador: " + Jugador + " No existe."
		}
		return;
	}	
	
//LISTADOS Generales
//----------------------------
	public List<Jugador> traerJugador() {
		return PersonaDao.getInstance().traerJugador();
	}	
	public List<Jugador> traerJugador(char estado) {
		return PersonaDao.getInstance().traerJugador(estado);
	}
	public List<Jugador> traerJugador(LocalDate fechaDesde, LocalDate fechaHasta) {
		return PersonaDao.getInstance().traerJugador(fechaDesde, fechaHasta);
	}
	public List<Jugador> traerJugador(LocalDate fechaDesde, LocalDate fechaHasta, char estado) {
		return PersonaDao.getInstance().traerJugador(fechaDesde, fechaHasta, estado);
	}
	
//------------------------------------------------
//  ARBITRO
//		traerArbitro(int idJugador) 
//		traerArbitro(long dni) 
//		traerArbitro(String apellido)
//------
//		agregarArbitro(todos los campos)
//		actualizarArbitro(Arbitro arbitro)
//		eliminarArbitro(int idArbitro)	
//------
//		List<Arbitro> traerArbitro()   
//		List<Arbitro> traerArbitro(char estado) 
//------------------------------------------------	
	public Arbitro traerArbitro(int idArbitro) {
		return PersonaDao.getInstance().traerArbitro(idArbitro);
	}

	public Arbitro traerArbitro(long dni) {
		return PersonaDao.getInstance().traerArbitro(dni);
	}

	// ----------------------------
	public int agregarArbitro(Arbitro arbitro) {
		int salida = 0;
		if (traerArbitro(arbitro.getIdArbitro()) == null) {
			salida = PersonaDao.getInstance().agregarArbitro(new Arbitro());
		} else {
			// Depende de lo que pida, si tirar excepción
			// "El Arbitro con el ID: " + arbitro.getIdArbitro() + " YA existe."
		}
		return salida;
	}

	public void actualizarArbitro(Arbitro arbitro) {
		if (traerArbitro(arbitro.getIdArbitro()) != null) {
			PersonaDao.getInstance().actualizarArbitro(arbitro);
		} else {
			// Depende de lo que pida, si tirar excepción
			// "El Arbitro con el ID: " + arbitro.getIdArbitro() + " No existe."
		}
		return;
	}

	public void eliminarArbitro(int idArbitro) {
		Arbitro arb = traerArbitro(idArbitro);
		if (arb != null) {
			PersonaDao.getInstance().eliminarArbitro(arb);
		} else {
			// Depende de lo que pida, si tirar excepción
			// "El Arbitro con el ID: " + arbitro.getIdArbitro() + " No existe."
		}
		return;
	}

//LISTADOS Generales
//----------------------------
	public List<Arbitro> traerArbitro() {
		return PersonaDao.getInstance().traerArbitro();
	}
	
	public List<Arbitro> traerArbitro(char estado) {
		return PersonaDao.getInstance().traerArbitro(estado);
	}
	
//------------------------
}// Fin PersonaABM