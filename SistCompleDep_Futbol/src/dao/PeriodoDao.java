package dao;

	import java.time.LocalDate;
	import java.util.List;
	import org.hibernate.HibernateException;
	import org.hibernate.Session;
	import org.hibernate.Transaction;
	//--------
	import datos.Periodo;

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
//	 	Periodo
//				List<Periodo> traerPeriodo()	--> Listar TODAs las Personas
//				List<Periodo> traerPeriodos(String sponsor)
//				List<Periodo> traerPeriodo(LocalDate fechaAlta)	
//				List<Periodo> traerPeriodo(LocalDate fechaDesde, LocalDate fechaHasta, String sponsor)
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

	@SuppressWarnings("unchecked")
	public List<Periodo> traerPeriodos(String sponsor) throws HibernateException {
		List<Periodo> lista = null;
		try {
			iniciaOperacion();
			String query = "from Periodo e "
					+ "where e.sponsorPeriodo=" + sponsor
					+ "order by "
					+ "e.fechaPeriodo asc "
					+ "e.sponsorPeriodo asc";
			lista = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Periodo> traerPeriodo(LocalDate fechaDesde, LocalDate fechaHasta) throws HibernateException {
		List<Periodo> objeto = null;
		try {
			iniciaOperacion();
			String query = "from Periodo e "
					+ "where (e.fechaPeriodo >=" + fechaDesde + " and j.fechaPeriodo <=" + fechaHasta 
					+ "order by "
					+ "e.fechaPeriodo asc "
					+ "e.sponsorPeriodo asc";
			objeto = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return objeto;
	}

	@SuppressWarnings("unchecked")
	public List<Periodo> traerPeriodo(LocalDate fechaDesde, LocalDate fechaHasta, String sponsor)
			throws HibernateException {
		List<Periodo> objeto = null;
		try {
			iniciaOperacion();
			String query = "from Periodo e "
					+ "where (e.fechaPeriodo >=" + fechaDesde + " and j.fechaPeriodo <=" + fechaHasta 
					+ ") and (e.sponsorPeriodo=" + sponsor 
					+ "order by "
					+ "e.fechaPeriodo asc "
					+ "e.sponsorPeriodo asc";
			objeto = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return objeto;
	}
//-----------------	
}//Fin PeriodoDao



