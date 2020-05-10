package dao;

	import java.util.List;
	import org.hibernate.HibernateException;
	import org.hibernate.Session;
	import org.hibernate.Transaction;

import datos.Equipo;
//--------
	import datos.Temporada;

	public class TemporadaDao {
		private static Session session;
		private Transaction tx;
		
		//---------------------
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
//   Agregar-Eliminar-Modificar-Traer - List de Contacto
//-------------------------------------------------------
// AGREGAR
	public int agregar(Temporada objeto) {
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

// ACTUALIZAR
	public void actualizar(Temporada objeto) throws HibernateException {
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

// ELIMINAR
	// Físico (sin Dependencia)
	public void eliminar(Temporada objeto) throws HibernateException {
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
//	TRAER (varios) 
//---------------------------------------
//	TEMPORADA
//			traerTemporada(int idTemporada)   uniqueResult()
//			traerTemporada(String nombre)       uniqueResult()
	// --------------------------------------
	// Cuando se pide traer el ID se usa SIEMPRE --> session.get(...)
	public Temporada traerTemporada(int idTemporada) throws HibernateException {
		Temporada objeto = null;
		try {
			iniciaOperacion();
			// Casteo del tipo Temporada
			objeto = (Temporada) session.get(Temporada.class, idTemporada);
		} finally {
			session.close();
		}
		return objeto;
	}

	// Cuando se pide traer cualquier otro tipo de campo
	// SE DEBE HACER SIEMPRE ----> UNA HQL
	public Temporada traerTemporada(String nombre) throws HibernateException {
		Temporada objeto = null;
		try {
			iniciaOperacion();
			// Casteo del tipo Temporada
	        String query = "from Temporada e where e.descripTemporada=" + nombre;			
			objeto = (Temporada) session.createQuery(query).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

//-------------------------------------------------------------
//	List<tabla> traerTabla()  
//-------------------------------------------------------------
//	 TEMPORADA
//				List<Temporada> traerTemporada()	--> Listar TODAs las Personas
//				List<Temporada> traerTemporadas(String temporada) 
//				List<Temporada> traerTemporadaPorCampeonato(int campeonato) --> para Elimiinar con Dependencias
	// -------------------------------------------------------------
	@SuppressWarnings("unchecked")
	public List<Temporada> traerTemporada() throws HibernateException {
		List<Temporada> lista = null;
		try {
			iniciaOperacion();
			String query = "from Temporada e "
					+ "order by "
					+ "e.estacionTemporada asc"
					+ "e.descripTemporada asc";
			lista = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Temporada> traerTemporadas(String estacion) throws HibernateException {
		List<Temporada> lista = null;
		try {
			iniciaOperacion();
			String query = "from Temporada e "
					+ "where e.estacionTemporada=" + estacion
					+ "order by "
					+ "e.estacionTemporada asc"
					+ "e.descripTemporada asc";
			lista = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return lista;
	}

	// Para el Eliminar
	//------------------------
	public List<Temporada> traerTemporadaPorCampeonato(int campeonato) throws HibernateException {
		List<Temporada> Temporadas = null;
		try {
			iniciaOperacion();
			String query = "from Temporada t where t.cgoCampeonato = " + campeonato;
			Temporadas = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return Temporadas;
	}	
	
	
	
//-----------------	
}//Fin TemporadaDao

