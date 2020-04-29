package dao;

	import java.util.List;
	import org.hibernate.HibernateException;
	import org.hibernate.Session;
	import org.hibernate.Transaction;
	//--------
	import datos.CanchaHora;

	public class CanchaHoraDao {
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
	public int agregar(CanchaHora objeto) {
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
	public void actualizar(CanchaHora objeto) throws HibernateException {
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
	public void eliminar(CanchaHora objeto) throws HibernateException {
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
// CanchaHora
//			traerCanchaHora(int idCanchaHora)   uniqueResult()
//			traerCanchaHora(String nombre)       uniqueResult()
	// --------------------------------------
	// Cuando se pide traer el ID se usa SIEMPRE --> session.get(...)
	public CanchaHora traerCanchaHora(int idCanchaHora) throws HibernateException {
		CanchaHora objeto = null;
		try {
			iniciaOperacion();
			// Casteo del tipo CanchaHora
			objeto = (CanchaHora) session.get(CanchaHora.class, idCanchaHora);
		} finally {
			session.close();
		}
		return objeto;
	}

	// Cuando se pide traer cualquier otro tipo de campo
	// SE DEBE HACER SIEMPRE ----> UNA HQL
	public CanchaHora traerCanchaHora(String nombre) throws HibernateException {
		CanchaHora objeto = null;
		try {
			iniciaOperacion();
			// Casteo del tipo CanchaHora
	        String query = "from CanchaHora e where e.detalleCancha=" + nombre;			
			objeto = (CanchaHora) session.createQuery(query)
					.uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

//-------------------------------------------------------------
//	List<tabla> traerTabla()  
//-------------------------------------------------------------
//	 	CanchaHora
//				List<CanchaHora> traerCanchaHora()	--> Listar TODAs las Personas
//				List<CanchaHora> traerCanchaHoras(String dia)
// -------------------------------------------------------------
	@SuppressWarnings("unchecked")
	public List<CanchaHora> traerCanchaHora() throws HibernateException {
		List<CanchaHora> lista = null;
		try {
			iniciaOperacion();
			String query = "from CanchaHora e "
					+ "order by "
					+ "e.turnoCampeonato asc "
					+ "e.diaCampeonato asc "
					+ "e.detalleCancha asc "
					+ "e.detalleHora asc";
			lista = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<CanchaHora> traerCanchaHoras(String dia) throws HibernateException {
		List<CanchaHora> lista = null;
		try {
			iniciaOperacion();
			String query = "from CanchaHora e "
					+ "where e.diaCampeonato=" + dia
					+ "order by "
					+ "e.detalleCancha asc "
					+ "e.detalleHora asc";
			lista = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return lista;
	}
	
//-----------------	
}//Fin CanchaHoraDao

