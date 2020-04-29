package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Zona;
//--------

public class ZonaDao {
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
		public int agregar(Zona objeto) {
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
		public void actualizar(Zona objeto) throws HibernateException {
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
		public void eliminar(Zona objeto) throws HibernateException {
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
		public void Borrar(Zona objeto) throws HibernateException {
			try {
				iniciaOperacion();
			//--Control del nuevo Estado
				// para la tabla de Zona que me pide el estado.
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
// TRAER (varios)
//--------------------------------------- 
// ZONA
//			traerZona(long idZona)  		 uniqueResult()
//			traerZona(String nombre)         uniqueResult()
	//--------------------------------------
		// Cuando se pide traer el ID se usa SIEMPRE --> session.get(...)
	public Zona traerZona(long idZona) throws HibernateException {
		Zona objeto = null;
		try {
			iniciaOperacion();
			//Casteo del tipo Zona
			objeto = (Zona) session.get(Zona.class, idZona);
		} finally {
			session.close();
		}
		return objeto;
	}

	public Zona traerZona(String nombre) throws HibernateException {
		Zona objeto = null;
		try {
			iniciaOperacion();
		  //Casteo del tipo Zona
	        String query = "from Zona z where z.nombreZona=" + nombre;
	        objeto = (Zona) session.createQuery(query).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
//-------------------------------------------------------------
//	List<tabla> traerTabla()  
//-------------------------------------------------------------	
// 	ZONA
//			List<Zona> traerZona()	--> Listar TODAs las Personas
//-------------------------------------------------------------	
	@SuppressWarnings("unchecked")
	public List<Zona> traerZona() throws HibernateException {
		List<Zona> lista = null;
		try {
			iniciaOperacion();
	        String query = "from Zona z order by z.nombreZona asc";
			lista = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return lista;
	}	

//-----------------	
}//Fin ZonaDao

