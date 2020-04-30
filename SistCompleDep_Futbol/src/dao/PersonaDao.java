package dao;

import java.time.LocalDate;
import java.util.List;
//--------
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
//--------
import datos.Persona;
import datos.Cliente;
import datos.Empleado;
import datos.Arbitro;
import datos.Jugador;


public class PersonaDao {
	private static Session session;
	private Transaction tx;
	
//-------------------------------------------------------------
// LO NUEVO: 
//         Unicamente para HERENCIA - PERSONA 
//--------------------------
	// Patrón Singleton
	private static PersonaDao instancia = null;

  //--------------------
  //Constructor
	public PersonaDao() {
	}

  //---------------------
  //Instancia DAO
	public static PersonaDao getInstance() {
		if (instancia == null)
			instancia = new PersonaDao();
		return instancia;
	}

// -------------------------------------------------------------
// Conexión a BD y creación de la Session
	protected void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	protected void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}	

//-------------------------------------------------------		
//   AGREGAR
//-------------------------------------------------------	
//	public int agregarPerona(Persona objeto) {
//		int id = 0;
//		try {
//			iniciaOperacion();
//			id = Integer.parseInt(session.save(objeto).toString());
//			tx.commit();
//		} catch (HibernateException he) {
//			manejaExcepcion(he);
//			throw he;
//		} finally {
//			session.close();
//		}
//		return id;
//	}
	
	public int agregarCliente(Cliente objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}
			
	public int agregarEmpleado(Empleado objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}
	
	public int agregarJugador(Jugador objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}
			
	public int agregarArbitro(Arbitro objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}
//------------------------------------------------
//	ACTUALIZAR
//------------------------------------------------				
//	public void actualizarPersona(Persona objeto) throws HibernateException {
//		try {
//			iniciaOperacion();
//			session.update(objeto);
//			tx.commit();
//		} catch (HibernateException he) {
//			manejaExcepcion(he);
//			throw he;
//		} finally {
//			session.close();
//		}
//	}
	
	public void actualizarCliente(Cliente objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
			
	public void actualizarEmpleado(Empleado objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	public void actualizarJugador(Jugador objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	public void actualizarArbitro(Arbitro objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
//------------------------------------------------
//	ELIMINAR  (Físico sin Dependencia)
//------------------------------------------------	
//	public void eliminarPersona(Persona objeto) throws HibernateException {
//		try {
//			iniciaOperacion();
//			session.delete(objeto);
//			tx.commit();
//		} catch (HibernateException he) {
//			manejaExcepcion(he);
//			throw he;
//		} finally {
//			session.close();
//		}
//	}
	
	public void eliminarCliente(Cliente objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
			
	public void eliminarEmpleado(Empleado objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	public void eliminarJugador(Jugador objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
	public void eliminarArbitro(Arbitro objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
//---------------------------------------
//	TRAER 
//--------------------------------------- 
// PERSONA
//	traerPersona(int idPersona)    uniqueResult()
//	traerPersona(long dni)         uniqueResult()
//	traerPersona(String apellido)  uniqueResult()
//--------------------------------------
	
	public Persona traerPersona(int idPersona) throws HibernateException {
		Persona objeto = null;
		try {
			iniciaOperacion();
			objeto = (Persona) session.get(Persona.class, idPersona);  // Casteo del tipo Persona
		} finally {
			session.close();
		}
		return objeto;
	}	

	public Persona traerPersona(long dni) throws HibernateException {
		Persona objeto = null;
		try {
			iniciaOperacion(); // abro la conexion a la session
			String query = "from Persona p where c.dni = " + dni;
			objeto = (Persona) session.createQuery(query).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Persona traerPersona(String apellido) throws HibernateException {
		Persona objeto = null;
		try {
			iniciaOperacion();
			String query = "from Persona p where p.apellido = " + apellido;
			objeto = (Persona) session.createQuery(query).uniqueResult();

		} finally {
			session.close();
		}
		return objeto;
	}	
		
//------------------------------------------------	
//	 CLIENTE
//		traerCliente(int idCliente)     Cuando se debe traer el ID de cualquier Tabla, SE DE USA session.Get(...) 
//		traerCliente(long dni)          cuando se usa cualquier otro campo se hace una QUERY
//		traerCliente(String apellido)
//------------------------------------------------		
	public Cliente traerCliente(int idCliente) throws HibernateException {
		Cliente objeto = null;
		try {
			iniciaOperacion();
			objeto = (Cliente) session.get(Cliente.class, idCliente);  // Casteo del tipo Cliente
		} finally {
			session.close();
		}
		return objeto;
	}

	public Cliente traerCliente(long dni) throws HibernateException {
		Cliente objeto = null;
		try {
			iniciaOperacion(); // abro la conexion a la session
			String query = "from Cliente c where c.dni = " + dni;
			objeto = (Cliente) session.createQuery(query).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	public Cliente traerCliente(String apellido) throws HibernateException {
		Cliente objeto = null;
		try {
			iniciaOperacion();
			String query = "from Cliente c where c.nombre = " + apellido;
			objeto = (Cliente) session.createQuery(query).uniqueResult();

		} finally {
			session.close();
		}
		return objeto;
	}			
			
//-----------------------------------------------		
// EMPLEADOS
//		traerEmpleado(int idEmpleado) 
//		traerEmpleado(long legajo) 
//		traerEmpleado(String apellido)
//------------------------------------------------
	public Empleado traerEmpleado(int idEmpleado) throws HibernateException {
		Empleado objeto = null;
		try {
			iniciaOperacion();
			objeto = (Empleado) session.get(Empleado.class, idEmpleado);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	public Empleado traerEmpleado(long legajo) throws HibernateException {
		Empleado objeto = null;
		try {
			iniciaOperacion();
			String query = "from Empleado e where e.legajo = " + legajo;
			objeto = (Empleado) session.createQuery(query).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	public Empleado traerEmpleado(String apellido) throws HibernateException {
		Empleado objeto = null;
		try {
			iniciaOperacion();
			String query = "from Empleado c where c.apellido = " + apellido;
			objeto = (Empleado) session.createQuery(query).uniqueResult();

		} finally {
			session.close();
		}
		return objeto;
	}
	
//-----------------------------------------------		
// JUGADOR
//			traerJugador(int idJugador) 
//			traerJugador(long dni) 
//			traerJugador(String apellido)
//------------------------------------------------
		public Jugador traerJugador(int idJugador) throws HibernateException {
			Jugador objeto = null;
			try {
				iniciaOperacion();
				objeto = (Jugador) session.get(Jugador.class, idJugador);
			} finally {
				session.close();
			}
			return objeto;
		}
		
		public Jugador traerJugador(long dni) throws HibernateException {
			Jugador objeto = null;
			try {
				iniciaOperacion();
				String query = "from Jugador j where j.dni = " + dni;
				objeto = (Jugador) session.createQuery(query).uniqueResult();
			} finally {
				session.close();
			}
			return objeto;
		}

		public Jugador traerJugador(String apellido) throws HibernateException {
			Jugador objeto = null;
			try {
				iniciaOperacion();
				String query = "from Jugador j where j.apellido = " + apellido;
				objeto = (Jugador) session.createQuery(query).uniqueResult();

			} finally {
				session.close();
			}
			return objeto;
		}	
	
//-----------------------------------------------		
// ARBITRO
//			traerArbitro(int idArbitro) 
//			traerArbitro(long dni) 
//			traerArbitro(String apellido)
//------------------------------------------------
	public Arbitro traerArbitro(int idArbitro) throws HibernateException {
		Arbitro objeto = null;
		try {
			iniciaOperacion();
			objeto = (Arbitro) session.get(Arbitro.class, idArbitro);
		} finally {
			session.close();
		}
		return objeto;
	}
				
	public Arbitro traerArbitro(long dni) throws HibernateException {
		Arbitro objeto = null;
		try {
			iniciaOperacion();
			String query = "from Arbitro a where a.dni = " + dni;
			objeto = (Arbitro) session.createQuery(query).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

	public Arbitro traerArbitro(String apellido) throws HibernateException {
		Arbitro objeto = null;
		try {
			iniciaOperacion();
			String query = "from Arbitro a where a.apellido = " + apellido;
			objeto = (Arbitro) session.createQuery(query).uniqueResult();

		} finally {
			session.close();
		}
		return objeto;
	}	
		
//-------------------------------------------------------------
//	List<tabla> traerTabla()  -  LISTADOS  GENERRALES
//-------------------------------------------------------------	
// 	PERSONA
//			List<Persona> traerPersona()	--> Listar TODAs las Personas
//-------------------------------------------------------------	
	@SuppressWarnings("unchecked")
	public List<Persona> traerPersonas() throws HibernateException {
		List<Persona> lista = null;
		try {
			iniciaOperacion();
			String query = "from Persona p order by p.Apellido asc p.nombre asc";
			lista = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return lista;
	}
	
//-------------------------------------------------------------	
// 	EMPLEADO
//			List<Empleado> traerEmpleado()	--> Listar TODOs los Empleados
//-------------------------------------------------------------		
	@SuppressWarnings("unchecked")
	public List<Empleado> traerEmpleado() throws HibernateException {
		List<Empleado> lista = null;
		try {
			iniciaOperacion();
			String query = "from Empleado e order by e.Apellido asc e.nombre asc";
			lista = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return lista;
	}
//-------------------------------------------------------------	
//	JUGADOR
//			List<Jugador> traerJugador()              ordenado por Equipo, apellido, nombre
//			List<Jugador> traerJugador(char estado)   o booleano es igual
//          List<Jugador> traerJugador(LocalDate fechaDesde, LocalDate fechaHasta)
//          List<Jugador> traerJugador(LocalDate fechaDesde, LocalDate fechaHasta, char estado)	
//
// VALIDAR por campos Nulos --> is null / is not null
//-------------------------------------------------------------	
	@SuppressWarnings("unchecked")
	public List<Jugador> traerJugador() throws HibernateException {
		List<Jugador> lista = null;
		try {
			iniciaOperacion();
			String query = "from Jugador j order by j.Apellido asc j.nombre asc"; // como pongo oredenado por EQUIPO?
			lista = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Jugador> traerJugador(char estado) throws HibernateException {
		List<Jugador> lista = null;
		try {
			iniciaOperacion();
			String query = "from Jugador j where j.controlJugador =" + estado + "order by j.apellido asc j.nombre asc";
			lista = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Jugador> traerJugador(LocalDate fechaDesde, LocalDate fechaHasta) throws HibernateException {
		List<Jugador> lista = null;
		try {
			iniciaOperacion();
			String query = "from Jugador j where (j.fechaDeAlta >=" + fechaDesde + " and j.fechaDeAlta <=" + fechaHasta + ") order by j.apellido asc j.nombre asc";
			lista = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return lista;
	}	
	
	@SuppressWarnings("unchecked")
	public List<Jugador> traerJugador(LocalDate fechaDesde, LocalDate fechaHasta, char estado) throws HibernateException {
		List<Jugador> lista = null;
		try {
			iniciaOperacion();
			String query = "from Jugador j where (j.fechaDeAlta >=" + fechaDesde + " and j.fechaDeAlta <=" + fechaHasta + ") and (j.controlJugador =" + estado + ") order by j.apellido asc j.nombre asc";
			lista = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return lista;
	}	
	
//	@SuppressWarnings("unchecked")        // HACERLO POR CADA OPCION
//	public List<Jugador> traerJugador(int goles, int amarillas, int rojas) throws HibernateException {
//		List<Jugador> lista = null;
//		try {
//			iniciaOperacion();
//			String query = "from Jugador j where j.golesJugador >" + 0 + " or j.tarjAmaJugador >" + 0 + " or j.tarjRojaJugador >" + 0 + " order by j.apellido asc j.nombre asc j.golesJugador asc";
//			lista = session.createQuery(query).list();
//		} finally {
//			session.close();
//		}
//		return lista;
//	}	
//-------------------------------------------------------------	
//	ARBITRO
//		List<Arbitro> traerArbitro()
//		List<Arbitro> traerArbitro(char estado)  --> A B M	
//-------------------------------------------------------------	
	@SuppressWarnings("unchecked")
	public List<Arbitro> traerArbitro() throws HibernateException {
		List<Arbitro> lista = null;
		try {
			iniciaOperacion();
			String query = "from Arbitro a order by a.apellido asc a.nombre asc";
			lista = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Arbitro> traerArbitro(char estado) throws HibernateException {
		List<Arbitro> lista = null;
		try {
			iniciaOperacion();
			String query = "from Arbitro a where a.controlArbitro =" + estado + "order by a.apellido asc a.nombre asc";
			lista = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return lista;
	}

	// que PARTIDOs dirigio cada ARBITRO VA EN partidos
//				public Partido traerPartidosConArbitros() throws HibernateException {
//					Partido objeto = null;
//					try {
//						iniciaOperacion();
//						String hql = "from Partido pa order by pa.cgotorneo asc pa.cgocampeonato asc pa.cgoCategoria asc";
//						objeto = (Partido) session.createQuery(hql).uniqueResult();
//					} finally {
//						session.close();
//					}
//					return objeto;
//				}
	
//----------------------------------------------------------------			
//		CLIENTES			
//			List<Cliente> traerCliente()	
//			List<Cliente> traerCliente(char estado)		
//-------------------------------------------------------------	
	@SuppressWarnings("unchecked")
	public List<Cliente> traerCliente() throws HibernateException {
		List<Cliente> lista = null;
		try {
			iniciaOperacion();
			String query = "from Cliente c order by c.Apellido asc c.nombre asc";
			lista = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> traerCliente(char estado) throws HibernateException {
		List<Cliente> objeto = null;
		try {
			iniciaOperacion();
			String query = "from Cliente c where c.controlCliente =" + estado + "order by c.apellido asc c.nombre asc";
			objeto = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return objeto;
	}		
						
//----------------
}//Fin Persona
	
