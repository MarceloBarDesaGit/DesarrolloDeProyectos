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
// AGREGAR
	public int agregar(Categoria objeto) {
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
	public void actualizar(Categoria objeto) throws HibernateException {
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
			// --Control del nuevo Estado
			// para la tabla de Categoria que me pide el estado.
			// Estafo = "A"
			// FechaCtrl=xx/xx/xx
			// FechaModf=xx/xx/xx
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
//		traerCategoria(long idCategoria)    uniqueResult()
//		traerCategoria(String nombre)		uniqueResult()
//--------------------------------------
	// Cuando se pide traer el ID se usa SIEMPRE --> session.get(...)
	public Categoria traerCategoria(long idCategoria) throws HibernateException {
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
	// Cuando se pide traer cualquier otro tipo de campo
	//       SE DEBE HACER SIEMPRE ----> UNA HQL
	public Categoria traerCategoria(String Categ) throws HibernateException {
		Categoria objeto = null;
		try {
			iniciaOperacion();
		  //Casteo del tipo Categoria
	        String query = "from Categoria c where c.descripCategoria=" + Categ;
			objeto = (Categoria) session.createQuery(query).uniqueResult();
		} finally {
			session.close();    
		}
		return objeto;
	}
	
//-------------------------------------------------------------
//	List<tabla> traerTabla()  
//-------------------------------------------------------------	
// 	CATEGORIA
//			List<Categoria> traerCategoria()	--> Listar TODAs
//	 --> para Elimiinar con Dependencias
//
//-------------------------------------------------------------	

	@SuppressWarnings("unchecked")
	public List<Categoria> traerCategoria() throws HibernateException {
		List<Categoria> lista = null;
		try {
			iniciaOperacion();
	        String query = "from Categoria c order by c.descripCategoria asc";
			lista = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return lista;
	}	

	
	
//-----------------	
}//Fin CategoriaDao

