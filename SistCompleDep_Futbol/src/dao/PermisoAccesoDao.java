package dao;

	import java.util.List;
	import org.hibernate.HibernateException;
	import org.hibernate.Session;
	import org.hibernate.Transaction;
	//--------
	import datos.PermisoAcceso;

	public class PermisoAccesoDao {
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
	public int agregar(PermisoAcceso objeto) {
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
	public void actualizar(PermisoAcceso objeto) throws HibernateException {
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
	public void eliminar(PermisoAcceso objeto) throws HibernateException {
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
// PermisoAcceso
//			traerPermisoAcceso(long idPermisoAcceso)   uniqueResult()
//			traerPermisoAcceso(String nombre)   uniqueResult()
// --------------------------------------
	// Cuando se pide traer el ID se usa SIEMPRE --> session.get(...)
	public PermisoAcceso traerPermisoAcceso(int idPermisoAcceso) throws HibernateException {
		PermisoAcceso objeto = null;
		try {
			iniciaOperacion();
			// Casteo del tipo PermisoAcceso
			objeto = (PermisoAcceso) session.get(PermisoAcceso.class, idPermisoAcceso);
		} finally {
			session.close();
		}
		return objeto;
	}

	// Cuando se pide traer cualquier otro tipo de campo
	// SE DEBE HACER SIEMPRE ----> UNA HQL
	public PermisoAcceso traerPermisoAcceso(String nombre) throws HibernateException {
		PermisoAcceso objeto = null;
		try {
			iniciaOperacion();
			// Casteo del tipo PermisoAcceso
	        String query = "from PermisoAcceso e where e.descripcionPAcceso=" + nombre;			
			objeto = (PermisoAcceso) session.createQuery(query)
					.uniqueResult();
		} finally {
			session.close();
		}
		return objeto;
	}

//-------------------------------------------------------------
//	List<tabla> traerTabla()  
//-------------------------------------------------------------
//	 	PermisoAcceso
//				List<PermisoAcceso> traerPermisoAcceso()	--> Listar TODAs las Personas
// -------------------------------------------------------------
	@SuppressWarnings("unchecked")
	public List<PermisoAcceso> traerPermisoAcceso() throws HibernateException {
		List<PermisoAcceso> lista = null;
		try {
			iniciaOperacion();
			String query = "from PermisoAcceso e "
					+ "order by "
					+ "e.descripcionPAcceso asc ";
			lista = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return lista;
	}

//******************************************
	@SuppressWarnings("unchecked")
	//Se traen TODOS los PermisosAcceso con ese ID que haya en los Roles 
//				y arma una Lista, que puede servir para eliminar dependencias
//				o hacer algun tipo de calculo. (es correcta la interpretacion ?)
	
	// La tabla PermisoAcceso tiene un atributo: Rol cgoRolPAcceso

	public List<PermisoAcceso> traerPermisosPorRol(int RolPAcceso) {
		List<PermisoAcceso> permisos = null;
		try {
			iniciaOperacion();
			//                  como se arma el iiner si el campo es de PermisoAcceo ?
			String query = "from PermisoAcceso pa inner join fetch pa.cgoRolPAcceso where pa.cgoRolPAcceso = "	+ RolPAcceso;
			permisos = session.createQuery(query).list();
		} finally {
			session.close();
		}
		return permisos;
	}
//******************************************	
	
	
//-----------------	
}//Fin PermisoAccesoDao




