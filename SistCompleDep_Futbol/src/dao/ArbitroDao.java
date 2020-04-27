package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Arbitro;

public class ArbitroDao {
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
	public int agregar(Arbitro objeto) {
		int id = 0;
		try {
			iniciaOperacion();  // Se abre la conexión con la session a la ND
			id = Integer.parseInt(session.save(objeto).toString());
			char estado = objeto.getControlArbitro();
			LocalDate fechaCtrl = objeto.getFechaCtrlArbitro();
			LocalDate fechaModif = objeto.getFechaModifArbitro();
		  //-----
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();   // Se cierra la Transaccion con la conexión 
		}
		return id;
	}

	public void actualizar(Arbitro objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(objeto);
		  //--Control del nuevo Estado
			char estado = 'M';
			LocalDate fechaCtrl = objeto.getFechaCtrlArbitro();
			LocalDate fechaModif = objeto.getFechaModifArbitro();
		  //-----
			
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	// Borrado Fisico  - BUSCAR SI EXISREN LAS DEPENDENCIAS
	public void eliminar(Arbitro objeto) throws HibernateException {
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
	public void Borrar(Arbitro objeto) throws HibernateException {
		try {
			iniciaOperacion();
		  // --Control del nuevo Estado
			char estado = 'B';
			LocalDate fechaCtrl = objeto.getFechaCtrlArbitro();
			LocalDate fechaModif = objeto.getFechaModifArbitro();
		  // -----
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
	
//------------------------------------------------------
//Cuando se debe traer el ID de cualquier Tabla, SE DE DEBE USAR UN session.Get(...)
	public Arbitro traer(int idArbitro) throws HibernateException {
		Arbitro objeto = null;
		try {
			iniciaOperacion(); 
			//Casteo del tipo Arbitro
			objeto = (Arbitro) session.get(Arbitro.class, idArbitro);
		} finally {
			session.close();
		}
		return objeto;
	}

	public Arbitro traer(long dni) throws HibernateException {
		Arbitro objeto = null;
		try {
			iniciaOperacion();
          //-------------
		    String query = "from Arbitros where c.dni ="+dni;
		  //-------------	
			//Casteo del tipo Arbitro
			objeto = (Arbitro) session.createQuery(query).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
//-------------------------
	@SuppressWarnings("unchecked")
	public List<Arbitro> traer() throws HibernateException {
		List<Arbitro> lista = null;
		try {
			iniciaOperacion();
		  //-------------
			String query = "from Arbitro c order by c.apellido asc c.nombre asc";
		  //-------------
			// Variable lista --> GUARDA todo el recordSet de la tabla
			lista = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return lista;
	}
	

	
//----------	
}//Fin ArbitroDao