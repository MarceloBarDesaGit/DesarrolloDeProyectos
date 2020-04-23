package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
//--------
import datos.Zona;

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
	public int agregar(Zona objeto) {
		int id = 0;
		try {
			iniciaOperacion();  // Se abre la conexión con la session a la ND
			id = Integer.parseInt(session.save(objeto).toString());
		
			//--Control del nuevo Estado
			// para la tabla de Productos que me pide el estado.
			// Estafo = "A"
			//FechaCtrl=xx/xx/xx
			//FechaModf=xx/xx/xx
			
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();   // Se cierra la Transaccion con la conexión 
		}
		return id;
	}

	public void actualizar(Zona objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(objeto);
		
			//--Control del nuevo Estado
			// para la tabla de Productos que me pide el estado.
			// Estafo = "M"
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

	// Borrado Fisico  - BUSCAR SI EXISTEN LAS DEPENDENCIAS
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
	
//------------------------------------------------------
/*
TIPOS DE LISTADOS
traer idZona	         uniqueResult()
	  nombreZona       uniqueResult()
    //--------  
      traer()            list()   traer todos los Zonas	
*/
	
//Cuando se debe traer el ID de cualquier Tabla...
//      SE DE DEBE USAR UN session.Get(...) ---> SIEMPRE 
	public Zona traer(long idZona) throws HibernateException {
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

	public Zona traer(String nombre) throws HibernateException {
		Zona objeto = null;
		try {
			iniciaOperacion();
		  //Casteo del tipo Zona
			objeto = (Zona) session.createQuery("from Zona z where z.nombreZona=" + nombre).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
//---------Listados Generales -----------------
	@SuppressWarnings("unchecked")
	public List<Zona> traer() throws HibernateException {
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

