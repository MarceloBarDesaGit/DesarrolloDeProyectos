package dao;

import java.time.LocalDate;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
	public int agregar(Equipo objeto) {
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

	public void actualizar(Equipo objeto) throws HibernateException {
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
	
//------------------------------------------------------
/*
TIPOS DE LISTADOS
traer idEquipo	         uniqueResult()
	  nombreEquipo       uniqueResult()
	  cgoZona            list()   traer toda una zona
    //--------  
 	// Variable "lista" GUARDA todo el recordSet de la tabla
      traer()            list()   traer todos los equipos	
      traerPorZonas      list()
      traerPorNombres    list()
      traerPorFechaAlta  list()
*/
	
//Cuando se debe traer el ID de cualquier Tabla...
//      SE DE DEBE USAR UN session.Get(...) ---> SIEMPRE 
	public Equipo traer(long idEquipo) throws HibernateException {
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

  //Cuando se debe traer una consulta por cualquier otro tipo de campo
  //       que no sea el Id, SE DEBE HACER UNA HQL----> SIEMPRE
	public Equipo traer(String nombre) throws HibernateException {
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
	
	public Equipo traer(int codigoZona) throws HibernateException {
		Equipo objeto = null;
		try {
			iniciaOperacion();
		//-------------	
			//Casteo del tipo Equipo
			objeto = (Equipo) session.createQuery("from Equipo e where e.cgoZona=" + codigoZona).list();
		} finally {
			session.close();
		}
		return objeto;
	}
	
//---------Listados Generales -----------------
	@SuppressWarnings("unchecked")
	public List<Equipo> traer() throws HibernateException {
		List<Equipo> lista = null;
		try {
			iniciaOperacion();
	        String query = "from Equipo e order by e.nombreEquipo asc";
			lista = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return lista;
	}	

	@SuppressWarnings("unchecked")
	public List<Equipo> traerPorZonas() throws HibernateException {
		List<Equipo> lista = null;
		try {
			iniciaOperacion();
	        String query = "from Equipo e order by e.cgoZona asc e.nombreEquipo asc";
			lista = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Equipo> traerPorNombres(String nombre) throws HibernateException {
		List<Equipo> objeto = null;
		try {
			iniciaOperacion();
	        String query = "from Equipo e where e.nombreEquipo like '%" + nombre + "%' order by e.nombreEquipo asc";
			objeto = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return objeto;
	}	
	
	@SuppressWarnings("unchecked")
	public List<Equipo> traerPorFechaAlta(LocalDate fechaAlta) throws HibernateException {
		List<Equipo> objeto = null;
		try {
			iniciaOperacion();
			objeto = session.createQuery("from Equipo e where e.FechaAltaEquipo=" + fechaAlta).list();
		} finally {
			session.close();
		}
		return objeto;
	}		
	
	
//-----------------	
}//Fin EquipoDao
