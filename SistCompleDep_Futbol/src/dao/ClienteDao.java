package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
//--------
import datos.Cliente;


public class ClienteDao {
	private static Session session;
	private Transaction tx;
	
  //Podemos obtener u CREAR la Session para trabajar con Hibernate
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la CAPA de acceso a DATOS", he);
	}

	public int agregar(Cliente objeto) {
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

	public void actualizar(Cliente objeto) throws HibernateException {
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

	// Borrado Fisico  - BUSCAR SI EXISREN LAS DEPENDENCIAS
	public void eliminar(Cliente objeto) throws HibernateException {
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
	public void Borrar(Cliente objeto) throws HibernateException {
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
	//Cuando se debe traer el ID de cualquier Tabla...
	//      SE DE DEBE USAR UN session.Get(...) ---> SIEMPRE 
	public Cliente traer(long idCliente) throws HibernateException {
		Cliente objeto = null;
		try {
			iniciaOperacion();   // abro la conexion a la session
			//Casteo del tipo Cliente
			objeto = (Cliente) session.get(Cliente.class, idCliente);
		} finally {
			session.close();
		}
		return objeto;
	}

	//Cuando se debe traer una consulta por cualquier otro tipo de campo
	//       que no sea el Id, SE DEBE HACER UNA HQL----> SIEMPRE
	public Cliente traer(int dni) throws HibernateException {
		Cliente objeto = null;
		try {
			iniciaOperacion();
        //-------------
		// USO de una Variable con la Query
		// String query = "from clientes where c.dni ="+dni;
		//objeto = (Cliente) session.createQuery(query).uniqueResult();
		//-------------	
			//Casteo del tipo Cliente
			objeto = (Cliente) session.createQuery("from Cliente c where c.dni=" + dni).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}
//-------------------------
	@SuppressWarnings("unchecked")
	public List<Cliente> traer() throws HibernateException {
		List<Cliente> lista = null;
		try {
			iniciaOperacion();
		 // Variable que GUARDA todo el recordSet de la tabla
			lista = session.createQuery("from Cliente c order by c.apellido asc c.nombre asc").list();
		} finally {
			session.close();
		}
		return lista;
	}
}