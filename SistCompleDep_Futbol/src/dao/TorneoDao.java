package dao;

import java.time.LocalDate;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
//--------
import datos.Torneo;

public class TorneoDao {
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
	public int agregar(Torneo objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
			//throw new HibernateException("El Torneo con el ID: " + objeto.getDetalleTorneo() + "  se Agrego correctamente.");

		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
			//throw new HibernateException("El Torneo con el ID: " + objeto.getDetalleTorneo() + "  YA existe en la BD.");
		} finally {
			session.close();
		}
		return id;
	}

// ACTUALIZAR
	public void actualizar(Torneo objeto) throws HibernateException {
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
	public void eliminar(Torneo objeto) throws HibernateException {
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
// TORNEO
//			traerTorneo(int idTorneo)   uniqueResult()
//			traerTorneo(String nombre)   uniqueResult()
	// --------------------------------------
	// Cuando se pide traer el ID se usa SIEMPRE --> session.get(...)
	public Torneo traerTorneo(int idTorneo) throws HibernateException {
		Torneo objeto = null;
		try {
			iniciaOperacion();
			// Casteo del tipo Torneo
			objeto = (Torneo) session.get(Torneo.class, idTorneo);
		} finally {
			session.close();
		}
		return objeto;
	}

	// Cuando se pide traer cualquier otro tipo de campo
	// SE DEBE HACER SIEMPRE ----> UNA HQL
	public Torneo traerTorneo(String nombre) throws HibernateException {
		Torneo objeto = null;
		try {
			iniciaOperacion();
			// Casteo del tipo Torneo
	        String query = "from Torneo e where e.detalleTorneo=" + nombre;			
			objeto = (Torneo) session.createQuery(query)
					.uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

//	public void traerUltimoRegTorneo() throws HibernateException {
//		try {
//			iniciaOperacion();
//	        String query = "Select count(*) from Torneo";			
//	        int countReg = session.createQuery(query);
//		} finally {
//			session.close();
//		}
//	}	 
	

	//-------------------------------------------------------------
//	List<tabla> traerTabla()  
//-------------------------------------------------------------
//	 	TORNEO
//				List<Torneo> traerTorneo()	--> Listar TODAs las Personas
//				List<Torneo> traerTorneos(String sponsor)
//				List<Torneo> traerTorneo(LocalDate fechaAlta)	
//				List<Torneo> traerTorneo(LocalDate fechaDesde, LocalDate fechaHasta, String sponsor)
	// -------------------------------------------------------------
	@SuppressWarnings("unchecked")
	public List<Torneo> traerTorneo() throws HibernateException {
		List<Torneo> lista = null;
		try {
			iniciaOperacion();
			String query = "from Torneo e "
					+ "order by "
					+ "e.fechaTorneo asc "
					+ "e.sponsorTorneo asc";
			lista = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Torneo> traerTorneos(String sponsor) throws HibernateException {
		List<Torneo> objeto = null;
		try {
			iniciaOperacion();
			String query = "from Torneo e "
					+ "where e.sponsorTorneo=" + sponsor
					+ "order by "
					+ "e.fechaTorneo asc "
					+ "e.sponsorTorneo asc";
			objeto = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return objeto;
	}

	@SuppressWarnings("unchecked")
	public List<Torneo> traerTorneo(LocalDate fechaDesde, LocalDate fechaHasta) throws HibernateException {
		List<Torneo> objeto = null;
		try {
			iniciaOperacion();
			String query = "from Torneo e "
					+ "where (e.fechaTorneo >=" + fechaDesde + " and j.fechaTorneo <=" + fechaHasta 
					+ "order by "
					+ "e.fechaTorneo asc "
					+ "e.sponsorTorneo asc";
			objeto = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return objeto;
	}

	@SuppressWarnings("unchecked")
	public List<Torneo> traerTorneo(LocalDate fechaDesde, LocalDate fechaHasta, String sponsor)
			throws HibernateException {
		List<Torneo> objeto = null;
		try {
			iniciaOperacion();
			String query = "from Torneo e "
					+ "where (e.fechaTorneo >=" + fechaDesde + " and j.fechaTorneo <=" + fechaHasta 
					+ ") and (e.sponsorTorneo=" + sponsor 
					+ "order by "
					+ "e.fechaTorneo asc "
					+ "e.sponsorTorneo asc";
			objeto = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return objeto;
	}
//-----------------	

}//Fin TorneoDao


