package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
//--------
import datos.Categoria;

public class CategoriaDao {
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
	public int agregar(Categoria objeto) {
		int id = 0;
		try {
			iniciaOperacion();  // Se abre la conexión con la session a la ND
			id = Integer.parseInt(session.save(objeto).toString());
		
			//--Control del nuevo Estado
			// para la tabla de Categoria que me pide el estado.
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

	public void actualizar(Categoria objeto) throws HibernateException {
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
	public void eliminar(Categoria objeto) throws HibernateException {
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
	public void Borrar(Categoria objeto) throws HibernateException {
		try {
			iniciaOperacion();
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
			session.close();
		}
	}
	
//------------------------------------------------------
/*
TIPOS DE LISTADOS
traer idCategoria	         uniqueResult()
	  nombreCategoria       uniqueResult()
    //--------  
      traer()            list()   traer todos los Categorias	
*/
	
//Cuando se debe traer el ID de cualquier Tabla...
//      SE DE DEBE USAR UN session.Get(...) ---> SIEMPRE 
	public Categoria traer(long idCategoria) throws HibernateException {
		Categoria objeto = null;
		try {
			iniciaOperacion();
			//Casteo del tipo Categoria
			objeto = (Categoria) session.get(Categoria.class, idCategoria);
		} finally {
			session.close();
		}
		return objeto;
	}

	public Categoria traer(String nombre) throws HibernateException {
		Categoria objeto = null;
		try {
			iniciaOperacion();
		  //Casteo del tipo Categoria
			objeto = (Categoria) session.createQuery("from Categoria c where c.Categoria=" + nombre).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
	
//---------Listados Generales -----------------
	@SuppressWarnings("unchecked")
	public List<Categoria> traer() throws HibernateException {
		List<Categoria> lista = null;
		try {
			iniciaOperacion();
	        String query = "from Categoria e order by e.nombreCategoria asc";
			lista = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return lista;
	}	

//-----------------	
}//Fin CategoriaDao

