package dao;

	import java.util.List;
	import org.hibernate.HibernateException;
	import org.hibernate.Session;
	import org.hibernate.Transaction;
	//--------
	import datos.Rol;

	public class RolDao {
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
	public int agregar(Rol objeto) {
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
	public void actualizar(Rol objeto) throws HibernateException {
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
	public void eliminar(Rol objeto) throws HibernateException {
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
//  ROL
//			traerRol(int idRol)   uniqueResult()
//			traerRol(String nombre)       uniqueResult()
	// --------------------------------------
	// Cuando se pide traer el ID se usa SIEMPRE --> session.get(...)
	public Rol traerRol(int idRol) throws HibernateException {
		Rol objeto = null;
		try {
			iniciaOperacion();
			// Casteo del tipo Rol
			objeto = (Rol) session.get(Rol.class, idRol);
		} finally {
			session.close();
		}
		return objeto;
	}

	// Cuando se pide traer cualquier otro tipo de campo
	// SE DEBE HACER SIEMPRE ----> UNA HQL
	public Rol traerRol(String nombre) throws HibernateException {
		Rol objeto = null;
		try {
			iniciaOperacion();
			// Casteo del tipo Rol
	        String query = "from Rol e where e.descripcionRol=" + nombre;			
			objeto = (Rol) session.createQuery(query).uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

//-------------------------------------------------------------
//	List<tabla> traerTabla()  
//-------------------------------------------------------------
//	ROL
//		List<Rol> traerRol()	--> Listar TODAs las Personas
//		List<Rol> traerRols(int permiso)
// -------------------------------------------------------------
	@SuppressWarnings("unchecked")
	public List<Rol> traerRol() throws HibernateException {
		List<Rol> lista = null;
		try {
			iniciaOperacion();
			String query = "from Rol e "
					+ "order by "
					+ "e.descripcionRol asc ";
			lista = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Rol> traerRols(int permiso) throws HibernateException {
		List<Rol> lista = null;
		try {
			iniciaOperacion();
			String query = "from Rol e "
					+ "where e.permisoRol =" + permiso
					+ "order by "
					+ "e.descripcionRol asc";
			lista = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return lista;
	}

	
//-----------------	
}//Fin RolDao


