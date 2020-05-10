package dao;

import java.time.LocalDate;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

//--------
import datos.Partido;

public class PartidoDao {
	private static Session session;
	private Transaction tx;

	// ---------------------
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
	public int agregar(Partido objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
			// throw new HibernateException("El Paartido entre: " 
			//		+ objeto.getCgoEquipoLocPartido() + " y " 
			//		+ objeto.getCgoEquipoVisPartido() + 
			//		"se Agrego correctamente.");
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
			//throw new HibernateException("El Partido con ID: " 
			//		+ objeto.getIdPartido() + " YA existe en la BD.");
		} finally {
			session.close();
		}
		return id;
	}

// ACTUALIZAR
	public void actualizar(Partido objeto) throws HibernateException {
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
	public void eliminar(Partido objeto) throws HibernateException {
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
// Partido
//		traerPartido(int idPartido)   	   uniqueResult()
//--------------------------------------
	// Cuando se pide traer el ID se usa SIEMPRE --> session.get(...)
	public Partido traerPartido(int idPartido) throws HibernateException {
		Partido objeto = null;
		try {
			iniciaOperacion();
			// Casteo del tipo Partido
			objeto = (Partido) session.get(Partido.class, idPartido);
		} finally {
			session.close();
		}
		return objeto;
	}

//-------------------------------------------------------------
//	List<tabla> traerTabla()  
//-------------------------------------------------------------	
// 	PARTIDO
//			List<Partido> traerPartido()	--> Listar TODAs las Personas
//			List<Partido> traerPartidos(int categoria)
//			List<Partido> traerPartido(LocalDate fechaAlta)	
//			List<Partido> traerPartidoPorFechaAlta(LocalDate fechaAlta)	
//			List<Partido> traerPartido(LocalDate fechaDesde, LocalDate fechaHasta, int zona)
//	---> para Eliminar con Dependencias
//			List<Partido> traerCategoriaPorPartido(int categoria)
//			List<Partido> traerArbitroPorPartido(int arbitro) 
//-------------------------------------------------------------	
	@SuppressWarnings("unchecked")
	public List<Partido> traerPartido() throws HibernateException {
		List<Partido> lista = null;
		try {
			iniciaOperacion();
			String query = "from Partido p " 
					+ "order by " 
					+ "p.fechaPartido asc"
					+ "p.jornadaCampPartido asc";
			lista = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Partido> traerPartidos(int categoria) throws HibernateException {
		List<Partido> lista = null;
		try {
			iniciaOperacion();
			String query = "from Partido p " 
			+ "where (p.cgoCategoria=" + categoria + ")"
					+ "order by " 
					+ "p.cgoCategoria asc "
					+ "p.jornadaCampPartido asc"
					+ "p.fechaPartido asc ";
			lista = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Partido> traerPartido(LocalDate fechaPart) throws HibernateException {
		List<Partido> lista = null;
		try {
			iniciaOperacion();
			String query = "from Partido p " 
					+ "where (p.fechaPartido=" + fechaPart +")"
					+ "order by " 
					+ "p.cgoCategoria asc "
					+ "p.jornadaCampPartido asc";
			lista = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Partido> traerPartido(LocalDate fechaDesde, LocalDate fechaHasta) throws HibernateException {
		List<Partido> objeto = null;
		try {
			iniciaOperacion();
			String query = "from Partido p " 
					+ "where (p.fechaPartido >=" + fechaDesde + " and p.fechaPartido <=" + fechaHasta + ")"
					+ " order by " 
					+ "p.cgoCategoria asc "
					+ "p.jornadaCampPartido asc";
			objeto = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return objeto;
	}

	@SuppressWarnings("unchecked")
	public List<Partido> traerPartido(LocalDate fechaDesde, LocalDate fechaHasta, int categoria) throws HibernateException {
		List<Partido> objeto = null;
		try {
			iniciaOperacion();
			String query = "from Partido p " + "where (p.fechaPartido >=" + fechaDesde + " and p.fechaPartido <=" + fechaHasta + ")"
					+ " and (p.cgoCategoria=" + categoria + ")" 
					+ " order by "
					+ "p.cgoCategoria asc "
					+ "p.jornadaCampPartido asc";
			objeto = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return objeto;
	}

//	// Para el Eliminar PLANTILLA
//	// ------------------------
//	public List<Partido> traerCanchaHoraPorPartido(int categoria) throws HibernateException {
//		List<Partido> Partidos = null;
//		try {
//			iniciaOperacion();
//			String query = "from Partido e where e.cgoCategoria = " + categoria;
//			Partidos = session.createQuery(query).list();
//
//		} finally {
//			session.close();
//		}
//		return Partidos;
//	}
	
//-----------------	
}//Fin PartidoDao
