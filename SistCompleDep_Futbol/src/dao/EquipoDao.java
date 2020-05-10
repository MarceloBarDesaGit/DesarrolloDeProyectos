package dao;

import java.time.LocalDate;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Categoria;
//--------
import datos.Equipo;

public class EquipoDao {
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
	public int agregar(Equipo objeto) {
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
	public void actualizar(Equipo objeto) throws HibernateException {
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
	public void eliminar(Equipo objeto) throws HibernateException {
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
	
	// Borrado Logico
	public void Borrar(Equipo objeto) throws HibernateException {
		try {
			iniciaOperacion();
		//--Control del nuevo Estado
			// para la tabla de Equipo que me pide el estado.
			// Estafo = "A"
			//FechaCtrl=xx/xx/xx
			//FechaModf=xx/xx/xx
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
// EQUIPO
//		traerEquipo(int idEquipo)   	   uniqueResult()
//		traerEquipo(String nombreEquipo)   uniqueResult()
//--------------------------------------
	// Cuando se pide traer el ID se usa SIEMPRE --> session.get(...)
	public Equipo traerEquipo(int idEquipo) throws HibernateException {
		Equipo objeto = null;
		try {
			iniciaOperacion();
			//Casteo del tipo Equipo
			objeto = (Equipo) session.get(Equipo.class, idEquipo);
		} finally {
			session.close();
		}
		return objeto;
	}

    // Cuando se pide traer cualquier otro tipo de campo
    //       SE DEBE HACER SIEMPRE ----> UNA HQL
	public Equipo traerEquipo(String nombre) throws HibernateException {
		Equipo objeto = null;
		try {
			iniciaOperacion();
		  //Casteo del tipo Equipo
			objeto = (Equipo) session.createQuery("from Equipo e where e.nombreEquipo=" + nombre).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
//-------------------------------------------------------------
//	List<tabla> traerTabla()  
//-------------------------------------------------------------	
// 	EQUIPO
//			List<Equipo> traerEquipo()	--> Listar TODAs las Personas
//			List<Equipo> traerEquipos(int zona)
//			List<Equipo> traerEquipo(LocalDate fechaAlta)	
//			List<Equipo> traerEquipoPorFechaAlta(LocalDate fechaAlta)	
//			List<Equipo> traerEquipo(LocalDate fechaDesde, LocalDate fechaHasta, int zona)
//	 --> para Eliminar
//			List<Equipo> traerCategoriaPorEquipo(int categoria)
//-------------------------------------------------------------	
	@SuppressWarnings("unchecked")
	public List<Equipo> traerEquipo() throws HibernateException {
		List<Equipo> lista = null;
		try {
			iniciaOperacion();
	        String query = "from Equipo e "
	        		+ "order by "
	        		+ "e.nombreEquipo asc";
			lista = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return lista;
	}	

	@SuppressWarnings("unchecked")
	public List<Equipo> traerEquipos(int zona) throws HibernateException {
		List<Equipo> lista = null;
		try {
			iniciaOperacion();
	        String query = "from Equipo e "
	        		+ "where e.cgoZona=" + zona 
	        		+ "order by "
	        		+ "e.cgoZona asc "
	        		+ "e.nombreEquipo asc";
			lista = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Equipo> traerEquipo(LocalDate fechaAlta) throws HibernateException {
		List<Equipo> lista = null;
		try {
			iniciaOperacion();
	        String query = "from Equipo e "
	        		+ "where e.FechaAltaEquipo=" + fechaAlta 
	        		+ "order by "
	        		+ "e.cgoZona asc "
	        		+ "e.nombreEquipo asc";			
			lista = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return lista;
	}		
	
	@SuppressWarnings("unchecked")
	public List<Equipo> traerEquipo(LocalDate fechaDesde, LocalDate fechaHasta) throws HibernateException {
		List<Equipo> objeto = null;
		try {
			iniciaOperacion();
			String query = "from Equipo e "
					+ "where (e.FechaAltaEquipo >=" + fechaDesde + " and j.FechaAltaEquipo <=" + fechaHasta +")"
					+ " order by "
					+ "e.cgoZona asc "
					+ "e.nombreEquipo asc";
			objeto = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<Equipo> traerEquipo(LocalDate fechaDesde, LocalDate fechaHasta, int zona) throws HibernateException {
		List<Equipo> objeto = null;
		try {
			iniciaOperacion();
			String query = "from Equipo e "
					+ "where (e.FechaAltaEquipo >=" + fechaDesde + " and j.FechaAltaEquipo <=" + fechaHasta +")"
					+ " and (e.cgoZona=" + zona +")"
					+ " order by "
					+ "e.cgoZona asc "
					+ "e.nombreEquipo asc";
			objeto = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return objeto;
	}
	
	// Para el Eliminar
	//------------------------
	public List<Equipo> traerCategoriaPorEquipo(int categoria) throws HibernateException {
		List<Equipo> equipos = null;
		try {
			iniciaOperacion();
			String query = "from Equipo e where e.cgoCategoria = " + categoria;
			equipos = session.createQuery(query).list();

		} finally {
			session.close();
		}
		return equipos;
	}	
	
	
//-----------------	
}//Fin EquipoDao
