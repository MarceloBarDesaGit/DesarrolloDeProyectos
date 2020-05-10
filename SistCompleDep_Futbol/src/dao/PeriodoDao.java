package dao;

	import java.time.LocalDate;
	import java.util.List;
	import org.hibernate.HibernateException;
	import org.hibernate.Session;
	import org.hibernate.Transaction;
	//--------
	import datos.Periodo;
import datos.Temporada;

	public class PeriodoDao {
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
	public int agregar(Periodo objeto) {
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
	public void actualizar(Periodo objeto) throws HibernateException {
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
	public void eliminar(Periodo objeto) throws HibernateException {
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
// Periodo
//			traerPeriodo(long idPeriodo)   uniqueResult()
//			traerPeriodo(String nombre)   uniqueResult()
	// --------------------------------------
	// Cuando se pide traer el ID se usa SIEMPRE --> session.get(...)
	public Periodo traerPeriodo(int idPeriodo) throws HibernateException {
		Periodo objeto = null;
		try {
			iniciaOperacion();
			// Casteo del tipo Periodo
			objeto = (Periodo) session.get(Periodo.class, idPeriodo);
		} finally {
			session.close();
		}
		return objeto;
	}

	// Cuando se pide traer cualquier otro tipo de campo
	// SE DEBE HACER SIEMPRE ----> UNA HQL
	public Periodo traerPeriodo(String nombre) throws HibernateException {
		Periodo objeto = null;
		try {
			iniciaOperacion();
			// Casteo del tipo Periodo
	        String query = "from Periodo e where e.detallePeriodo=" + nombre;			
			objeto = (Periodo) session.createQuery(query).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

//-------------------------------------------------------------
//	List<tabla> traerTabla()  
//-------------------------------------------------------------
//	PERIODO
//			List<Periodo> traerPeriodo()	--> Listar TODAs las Personas
//	 --> para Elimiinar con Dependencias
//  		List<Periodo> traerPeriodoPorCampeonato(int campeonato) 
// -------------------------------------------------------------
	@SuppressWarnings("unchecked")
	public List<Periodo> traerPeriodo() throws HibernateException {
		List<Periodo> lista = null;
		try {
			iniciaOperacion();
			String query = "from Periodo e "
					+ "order by "
					+ "e.fechaPeriodo asc "
					+ "e.sponsorPeriodo asc";
			lista = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return lista;
	}
	
// Para el Eliminar
//------------------------
	public List<Periodo> traerPeriodoPorCampeonato(int campeonato) throws HibernateException {
		List<Periodo> Periodos = null;
		try {
			iniciaOperacion();
			String query = "from Periodo p where p.cgoCampeonato = " + campeonato;
			Periodos = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return Periodos;
	}	
	
//-----------------	
}//Fin PeriodoDao



